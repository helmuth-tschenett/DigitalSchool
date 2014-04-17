package com.oss.tfo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the stunde database table.
 * 
 */
@Entity
@NamedQuery(name="Stunde.findAll", query="SELECT s FROM Stunde s")
public class Stunde implements Serializable,Comparable<Object> {
	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Object object) {
		if (object instanceof Stunde) {
			Stunde stunde = (Stunde)object;
			return this.stundeneinteilung.compareTo(stunde.stundeneinteilung);
		}
		else
			return 0;
	}
	
	@EmbeddedId
	private StundePK id;

	//bi-directional many-to-one association to Fach
	@ManyToOne
	private Fach fach;

	//bi-directional many-to-one association to Klasse
	@ManyToOne
	private Klasse klasse;

	//bi-directional many-to-one association to Schulraum
	@ManyToOne
	@JoinColumn(name="Spezialraum")
	private Schulraum schulraum;

	//bi-directional many-to-one association to Stundeneinteilung
	@ManyToOne
	private Stundeneinteilung stundeneinteilung;

	public Stunde() {
	}

	public StundePK getId() {
		return this.id;
	}

	public void setId(StundePK id) {
		this.id = id;
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