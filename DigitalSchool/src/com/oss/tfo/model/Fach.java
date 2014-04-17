package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fach database table.
 * 
 */
@Entity
@NamedQuery(name="Fach.findAll", query="SELECT f FROM Fach f")
public class Fach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	//bi-directional many-to-one association to Stunde
	@OneToMany(mappedBy="fach")
	private List<Stunde> stundes;

	//bi-directional many-to-one association to Tagesregister
	@OneToMany(mappedBy="fach")
	private List<Tagesregister> tagesregisters;

	//bi-directional many-to-one association to Unterrichtet
	@OneToMany(mappedBy="fach")
	private List<Unterrichtet> unterrichtets;

	public Fach() {
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

	public List<Stunde> getStundes() {
		return this.stundes;
	}

	public void setStundes(List<Stunde> stundes) {
		this.stundes = stundes;
	}

	public Stunde addStunde(Stunde stunde) {
		getStundes().add(stunde);
		stunde.setFach(this);

		return stunde;
	}

	public Stunde removeStunde(Stunde stunde) {
		getStundes().remove(stunde);
		stunde.setFach(null);

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
		tagesregister.setFach(this);

		return tagesregister;
	}

	public Tagesregister removeTagesregister(Tagesregister tagesregister) {
		getTagesregisters().remove(tagesregister);
		tagesregister.setFach(null);

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
		unterrichtet.setFach(this);

		return unterrichtet;
	}

	public Unterrichtet removeUnterrichtet(Unterrichtet unterrichtet) {
		getUnterrichtets().remove(unterrichtet);
		unterrichtet.setFach(null);

		return unterrichtet;
	}

}