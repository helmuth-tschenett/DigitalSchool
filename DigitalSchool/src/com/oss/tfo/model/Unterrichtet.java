package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the unterrichtet database table.
 * 
 */
@Entity
@NamedQuery(name="Unterrichtet.findAll", query="SELECT u FROM Unterrichtet u")
public class Unterrichtet implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UnterrichtetPK id;

	private short wielangeschon;

	//bi-directional many-to-one association to Fach
	@ManyToOne
	private Fach fach;

	//bi-directional many-to-one association to Klasse
	@ManyToOne
	private Klasse klasse;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	private Professor professor;

	public Unterrichtet() {
	}

	public UnterrichtetPK getId() {
		return this.id;
	}

	public void setId(UnterrichtetPK id) {
		this.id = id;
	}

	public short getWielangeschon() {
		return this.wielangeschon;
	}

	public void setWielangeschon(short wielangeschon) {
		this.wielangeschon = wielangeschon;
	}

	public Fach getFach() {
		return this.fach;
	}

	public void setFach(Fach fach) {
		this.fach = fach;
	}

	public Klasse getKlasse() {
		return this.klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}