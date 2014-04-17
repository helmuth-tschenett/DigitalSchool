package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Boolean geschlecht;

	private String nachname;
	private String vorname;

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	private short wielangeschon;

	//bi-directional many-to-one association to Klasse
	@ManyToOne
	@JoinColumn(name="Klassenlehrer")
	private Klasse klasse;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="professor")
	private List<Tagesregister> tagesregisters;

	//bi-directional many-to-one association to Unterrichtet
	@OneToMany(mappedBy="professor")
	private List<Unterrichtet> unterrichtets;

	public Professor() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getGeschlecht() {
		return this.geschlecht;
	}

	public void setGeschlecht(Boolean geschlecht) {
		this.geschlecht = geschlecht;
	}

	public short getWielangeschon() {
		return this.wielangeschon;
	}

	public void setWielangeschon(short wielangeschon) {
		this.wielangeschon = wielangeschon;
	}

	public Klasse getKlasse() {
		return this.klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public List<Tagesregister> getTagesregisters() {
		return this.tagesregisters;
	}

	public void setTagesregisters(List<Tagesregister> tagesregisters) {
		this.tagesregisters = tagesregisters;
	}

	public Tagesregister addTagesregister(Tagesregister tagesregister) {
		getTagesregisters().add(tagesregister);
		tagesregister.setProfessor(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setProfessor(null);

		return tagesregister;
	}

	public List<Unterrichtet> getUnterrichtets() {
		return this.unterrichtets;
	}

	public void setUnterrichtets(List<Unterrichtet> unterrichtets) {
		this.unterrichtets = unterrichtets;
	}

	public Unterrichtet addUnterrichtet(Unterrichtet unterrichtet) {
		getUnterrichtets().add(unterrichtet);
		unterrichtet.setProfessor(this);

		return unterrichtet;
	}

	public Unterrichtet removeUnterrichtet(Unterrichtet unterrichtet) {
		getUnterrichtets().remove(unterrichtet);
		unterrichtet.setProfessor(null);

		return unterrichtet;
	}

}