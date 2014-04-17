package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the klasse database table.
 * 
 */
@Entity
@NamedQuery(name="Klasse.findAll", query="SELECT k FROM Klasse k")
public class Klasse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	//bi-directional many-to-one association to Schulraum
	@ManyToOne
	@JoinColumn(name="Klassenraum")
	private Schulraum schulraum;

	//bi-directional many-to-one association to Schüler
	@ManyToOne
	@JoinColumn(name="Klassensprecher")
	private Schüler schüler1;

	//bi-directional many-to-one association to Schüler
	@ManyToOne
	@JoinColumn(name="Vizeklassensprecher")
	private Schüler schüler2;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="klasse")
	private List<Professor> professors;

	//bi-directional many-to-one association to Schüler
	@OneToMany(mappedBy="klasse")
	private List<Schüler> schülers;

	//bi-directional many-to-one association to Stunde
	@OneToMany(mappedBy="klasse")
	private List<Stunde> stundes;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="klasse")
	private List<Tagesregister> tagesregisters;

	//bi-directional many-to-one association to Unterrichtet
	@OneToMany(mappedBy="klasse")
	private List<Unterrichtet> unterrichtets;

	public Klasse() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Schulraum getSchulraum() {
		return this.schulraum;
	}

	public void setSchulraum(Schulraum schulraum) {
		this.schulraum = schulraum;
	}

	public Schüler getSchüler1() {
		return this.schüler1;
	}

	public void setSchüler1(Schüler schüler1) {
		this.schüler1 = schüler1;
	}

	public Schüler getSchüler2() {
		return this.schüler2;
	}

	public void setSchüler2(Schüler schüler2) {
		this.schüler2 = schüler2;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setKlasse(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setKlasse(null);

		return professor;
	}

	public List<Schüler> getSchülers() {
		return this.schülers;
	}

	public void setSchülers(List<Schüler> schülers) {
		this.schülers = schülers;
	}

	public Schüler addSchüler(Schüler schüler) {
		getSchülers().add(schüler);
		schüler.setKlasse(this);

		return schüler;
	}

	public Schüler removeSchüler(Schüler schüler) {
		getSchülers().remove(schüler);
		schüler.setKlasse(null);

		return schüler;
	}

	public List<Stunde> getStundes() {
		return this.stundes;
	}

	public void setStundes(List<Stunde> stundes) {
		this.stundes = stundes;
	}

	public Stunde addStunde(Stunde stunde) {
		getStundes().add(stunde);
		stunde.setKlasse(this);

		return stunde;
	}

	public Stunde removeStunde(Stunde stunde) {
		getStundes().remove(stunde);
		stunde.setKlasse(null);

		return stunde;
	}

	public List<Tagesregister> getTagesregisters() {
		return this.tagesregisters;
	}

	public void setTagesregisters(List<Tagesregister> tagesregisters) {
		this.tagesregisters = tagesregisters;
	}

	public Tagesregister addTagesregister(Tagesregister tagesregister) {
		getTagesregisters().add(tagesregister);
		tagesregister.setKlasse(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setKlasse(null);

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
		unterrichtet.setKlasse(this);

		return unterrichtet;
	}

	public Unterrichtet removeUnterrichtet(Unterrichtet unterrichtet) {
		getUnterrichtets().remove(unterrichtet);
		unterrichtet.setKlasse(null);

		return unterrichtet;
	}

}