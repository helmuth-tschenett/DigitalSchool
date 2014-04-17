package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prüfung database table.
 * 
 */
@Entity
@NamedQuery(name="Prüfung.findAll", query="SELECT p FROM Prüfung p")
public class Prüfung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String thema;

	//bi-directional many-to-one association to Benotung
	@OneToMany(mappedBy="prüfung")
	private List<Benotung> benotungs;

	//bi-directional many-to-one association to Prüfungstyp
	@ManyToOne
	private Prüfungstyp prüfungstyp;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="prüfung")
	private List<Tagesregister> tagesregisters;

	public Prüfung() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThema() {
		return this.thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public List<Benotung> getBenotungs() {
		return this.benotungs;
	}

	public void setBenotungs(List<Benotung> benotungs) {
		this.benotungs = benotungs;
	}

	public Benotung addBenotung(Benotung benotung) {
		getBenotungs().add(benotung);
		benotung.setPrüfung(this);

		return benotung;
	}

	public Benotung removeBenotung(Benotung benotung) {
		getBenotungs().remove(benotung);
		benotung.setPrüfung(null);

		return benotung;
	}

	public Prüfungstyp getPrüfungstyp() {
		return this.prüfungstyp;
	}

	public void setPrüfungstyp(Prüfungstyp prüfungstyp) {
		this.prüfungstyp = prüfungstyp;
	}

	public List<Tagesregister> getTagesregisters() {
		return this.tagesregisters;
	}

	public void setTagesregisters(List<Tagesregister> tagesregisters) {
		this.tagesregisters = tagesregisters;
	}

	public Tagesregister addTagesregister(Tagesregister tagesregister) {
		getTagesregisters().add(tagesregister);
		tagesregister.setPrüfung(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setPrüfung(null);

		return tagesregister;
	}

}