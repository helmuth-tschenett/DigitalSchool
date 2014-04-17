package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tagesregister database table.
 * 
 */
@Entity
@NamedQuery(name="Tagesregister.findAll", query="SELECT t FROM Tagesregister t")
public class Tagesregister implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String besonderheiten;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String thema;

	//bi-directional many-to-one association to Eintragung
	@OneToMany(mappedBy="tagesregister")
	private List<Eintragung> eintragungs;

	//bi-directional many-to-one association to Fehlt
	@OneToMany(mappedBy="tagesregister")
	private List<Fehlt> fehlts;

	//bi-directional many-to-one association to Fach
	@ManyToOne
	private Fach fach;

	//bi-directional many-to-one association to Klasse
	@ManyToOne
	private Klasse klasse;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	private Professor professor;

	//bi-directional many-to-one association to Prüfung
	@ManyToOne
	private Prüfung prüfung;

	//bi-directional many-to-one association to Schulraum
	@ManyToOne
	@JoinColumn(name="Spezialraum")
	private Schulraum schulraum;

	//bi-directional many-to-one association to Stundeneinteilung
	@ManyToOne
	private Stundeneinteilung stundeneinteilung;

	public Tagesregister() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBesonderheiten() {
		return this.besonderheiten;
	}

	public void setBesonderheiten(String besonderheiten) {
		this.besonderheiten = besonderheiten;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getThema() {
		return this.thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public List<Eintragung> getEintragungs() {
		return this.eintragungs;
	}

	public void setEintragungs(List<Eintragung> eintragungs) {
		this.eintragungs = eintragungs;
	}

	public Eintragung addEintragung(Eintragung eintragung) {
		getEintragungs().add(eintragung);
		eintragung.setTagesregister(this);

		return eintragung;
	}

	public Eintragung removeEintragung(Eintragung eintragung) {
		getEintragungs().remove(eintragung);
		eintragung.setTagesregister(null);

		return eintragung;
	}

	public List<Fehlt> getFehlts() {
		return this.fehlts;
	}

	public void setFehlts(List<Fehlt> fehlts) {
		this.fehlts = fehlts;
	}

	public Fehlt addFehlt(Fehlt fehlt) {
		getFehlts().add(fehlt);
		fehlt.setTagesregister(this);

		return fehlt;
	}

	public Fehlt removeFehlt(Fehlt fehlt) {
		getFehlts().remove(fehlt);
		fehlt.setTagesregister(null);

		return fehlt;
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

	public Prüfung getPrüfung() {
		return this.prüfung;
	}

	public void setPrüfung(Prüfung prüfung) {
		this.prüfung = prüfung;
	}

	public Schulraum getSchulraum() {
		return this.schulraum;
	}

	public void setSchulraum(Schulraum schulraum) {
		this.schulraum = schulraum;
	}

	public Stundeneinteilung getStundeneinteilung() {
		return this.stundeneinteilung;
	}

	public void setStundeneinteilung(Stundeneinteilung stundeneinteilung) {
		this.stundeneinteilung = stundeneinteilung;
	}

}