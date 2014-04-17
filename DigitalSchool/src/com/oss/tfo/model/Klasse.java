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

	//bi-directional many-to-one association to Sch�ler
	@ManyToOne
	@JoinColumn(name="Klassensprecher")
	private Sch�ler sch�ler1;

	//bi-directional many-to-one association to Sch�ler
	@ManyToOne
	@JoinColumn(name="Vizeklassensprecher")
	private Sch�ler sch�ler2;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="klasse")
	private List<Professor> professors;

	//bi-directional many-to-one association to Sch�ler
	@OneToMany(mappedBy="klasse")
	private List<Sch�ler> sch�lers;

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

	public Sch�ler getSch�ler1() {
		return this.sch�ler1;
	}

	public void setSch�ler1(Sch�ler sch�ler1) {
		this.sch�ler1 = sch�ler1;
	}

	public Sch�ler getSch�ler2() {
		return this.sch�ler2;
	}

	public void setSch�ler2(Sch�ler sch�ler2) {
		this.sch�ler2 = sch�ler2;
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

	public List<Sch�ler> getSch�lers() {
		return this.sch�lers;
	}

	public void setSch�lers(List<Sch�ler> sch�lers) {
		this.sch�lers = sch�lers;
	}

	public Sch�ler addSch�ler(Sch�ler sch�ler) {
		getSch�lers().add(sch�ler);
		sch�ler.setKlasse(this);

		return sch�ler;
	}

	public Sch�ler removeSch�ler(Sch�ler sch�ler) {
		getSch�lers().remove(sch�ler);
		sch�ler.setKlasse(null);

		return sch�ler;
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