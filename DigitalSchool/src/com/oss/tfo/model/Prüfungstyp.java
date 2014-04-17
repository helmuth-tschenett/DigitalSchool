package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prüfungstyp database table.
 * 
 */
@Entity
@NamedQuery(name="Prüfungstyp.findAll", query="SELECT p FROM Prüfungstyp p")
public class Prüfungstyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String typ;

	//bi-directional many-to-one association to Prüfung
	@OneToMany(mappedBy="prüfungstyp")
	private List<Prüfung> prüfungs;

	public Prüfungstyp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public List<Prüfung> getPrüfungs() {
		return this.prüfungs;
	}

	public void setPrüfungs(List<Prüfung> prüfungs) {
		this.prüfungs = prüfungs;
	}

	public Prüfung addPrüfung(Prüfung prüfung) {
		getPrüfungs().add(prüfung);
		prüfung.setPrüfungstyp(this);

		return prüfung;
	}

	public Prüfung removePrüfung(Prüfung prüfung) {
		getPrüfungs().remove(prüfung);
		prüfung.setPrüfungstyp(null);

		return prüfung;
	}

}