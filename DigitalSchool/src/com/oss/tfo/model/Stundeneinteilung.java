package com.oss.tfo.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the stundeneinteilung database table.
 * 
 */
@Entity
@NamedQuery(name="Stundeneinteilung.findAll", query="SELECT s FROM Stundeneinteilung s")
public class Stundeneinteilung implements Serializable,Comparable<Object> {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Time beginn;

	private Time ende;

	private Byte pause;

	//bi-directional many-to-one association to Stunde
	@OneToMany(mappedBy="stundeneinteilung")
	private List<Stunde> stundes;

	//bi-directional many-to-one association to Wochentag
	private int wochentag;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="stundeneinteilung")
	private List<Tagesregister> tagesregisters;

	public Stundeneinteilung() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Time getBeginn() {
		return this.beginn;
	}

	public void setBeginn(Time beginn) {
		this.beginn = beginn;
	}

	public Time getEnde() {
		return this.ende;
	}

	public void setEnde(Time ende) {
		this.ende = ende;
	}

	public Byte getPause() {
		return this.pause;
	}

	public void setPause(Byte pause) {
		this.pause = pause;
	}

	public List<Stunde> getStundes() {
		return this.stundes;
	}

	public void setStundes(List<Stunde> stundes) {
		this.stundes = stundes;
	}

	public Stunde addStunde(Stunde stunde) {
		getStundes().add(stunde);
		stunde.setStundeneinteilung(this);

		return stunde;
	}

	public Stunde removeStunde(Stunde stunde) {
		getStundes().remove(stunde);
		stunde.setStundeneinteilung(null);

		return stunde;
	}

	public int getWochentag() {
		return this.wochentag;
	}

	public void setWochentag(int wochentag) {
		this.wochentag = wochentag;
	}

	public List<Tagesregister> getTagesregisters() {
		return this.tagesregisters;
	}

	public void setTagesregisters(List<Tagesregister> tagesregisters) {
		this.tagesregisters = tagesregisters;
	}

	public Tagesregister addTagesregister(Tagesregister tagesregister) {
		getTagesregisters().add(tagesregister);
		tagesregister.setStundeneinteilung(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setStundeneinteilung(null);

		return tagesregister;
	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Stundeneinteilung) {
			Stundeneinteilung se = (Stundeneinteilung)object;
			if (this.getBeginn().compareTo(se.getBeginn())==0) {
				if (this.getWochentag()>se.getWochentag()) return 1;
				if (this.getWochentag()<se.getWochentag()) return -1;
				return 0;
			}
			else 
				return (getBeginn().compareTo(se.getBeginn()));
		}
		else
			return 0;
	}
}