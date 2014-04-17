package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the schulraum database table.
 * 
 */
@Entity
@NamedQuery(name="Schulraum.findAll", query="SELECT s FROM Schulraum s")
public class Schulraum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String raumnummer;

	private String verwendungszweck;

	//bi-directional many-to-one association to Klasse
	@OneToMany(mappedBy="schulraum")
	private List<Klasse> klasses;

	//bi-directional many-to-one association to Stunde
	@OneToMany(mappedBy="schulraum")
	private List<Stunde> stundes;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="schulraum")
	private List<Tagesregister> tagesregisters;

	public Schulraum() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaumnummer() {
		return this.raumnummer;
	}

	public void setRaumnummer(String raumnummer) {
		this.raumnummer = raumnummer;
	}

	public String getVerwendungszweck() {
		return this.verwendungszweck;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

	public List<Klasse> getKlasses() {
		return this.klasses;
	}

	public void setKlasses(List<Klasse> klasses) {
		this.klasses = klasses;
	}

	public Klasse addKlass(Klasse klass) {
		getKlasses().add(klass);
		klass.setSchulraum(this);

		return klass;
	}

	public Klasse removeKlass(Klasse klass) {
		getKlasses().remove(klass);
		klass.setSchulraum(null);

		return klass;
	}

	public List<Stunde> getStundes() {
		return this.stundes;
	}

	public void setStundes(List<Stunde> stundes) {
		this.stundes = stundes;
	}

	public Stunde addStunde(Stunde stunde) {
		getStundes().add(stunde);
		stunde.setSchulraum(this);

		return stunde;
	}

	public Stunde removeStunde(Stunde stunde) {
		getStundes().remove(stunde);
		stunde.setSchulraum(null);

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
		tagesregister.setSchulraum(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setSchulraum(null);

		return tagesregister;
	}

}