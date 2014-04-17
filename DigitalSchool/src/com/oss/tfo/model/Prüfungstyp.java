package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pr�fungstyp database table.
 * 
 */
@Entity
@NamedQuery(name="Pr�fungstyp.findAll", query="SELECT p FROM Pr�fungstyp p")
public class Pr�fungstyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String typ;

	//bi-directional many-to-one association to Pr�fung
	@OneToMany(mappedBy="pr�fungstyp")
	private List<Pr�fung> pr�fungs;

	public Pr�fungstyp() {
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

	public List<Pr�fung> getPr�fungs() {
		return this.pr�fungs;
	}

	public void setPr�fungs(List<Pr�fung> pr�fungs) {
		this.pr�fungs = pr�fungs;
	}

	public Pr�fung addPr�fung(Pr�fung pr�fung) {
		getPr�fungs().add(pr�fung);
		pr�fung.setPr�fungstyp(this);

		return pr�fung;
	}

	public Pr�fung removePr�fung(Pr�fung pr�fung) {
		getPr�fungs().remove(pr�fung);
		pr�fung.setPr�fungstyp(null);

		return pr�fung;
	}

}