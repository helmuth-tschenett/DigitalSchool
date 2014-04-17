package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pr�fung database table.
 * 
 */
@Entity
@NamedQuery(name="Pr�fung.findAll", query="SELECT p FROM Pr�fung p")
public class Pr�fung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String thema;

	//bi-directional many-to-one association to Benotung
	@OneToMany(mappedBy="pr�fung")
	private List<Benotung> benotungs;

	//bi-directional many-to-one association to Pr�fungstyp
	@ManyToOne
	private Pr�fungstyp pr�fungstyp;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="pr�fung")
	private List<Tagesregister> tagesregisters;

	public Pr�fung() {
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
		benotung.setPr�fung(this);

		return benotung;
	}

	public Benotung removeBenotung(Benotung benotung) {
		getBenotungs().remove(benotung);
		benotung.setPr�fung(null);

		return benotung;
	}

	public Pr�fungstyp getPr�fungstyp() {
		return this.pr�fungstyp;
	}

	public void setPr�fungstyp(Pr�fungstyp pr�fungstyp) {
		this.pr�fungstyp = pr�fungstyp;
	}

	public List<Tagesregister> getTagesregisters() {
		return this.tagesregisters;
	}

	public void setTagesregisters(List<Tagesregister> tagesregisters) {
		this.tagesregisters = tagesregisters;
	}

	public Tagesregister addTagesregister(Tagesregister tagesregister) {
		getTagesregisters().add(tagesregister);
		tagesregister.setPr�fung(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setPr�fung(null);

		return tagesregister;
	}

}