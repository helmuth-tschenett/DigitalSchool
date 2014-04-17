package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fehlt database table.
 * 
 */
@Entity
@NamedQuery(name="Fehlt.findAll", query="SELECT f FROM Fehlt f")
public class Fehlt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FehltPK id;

	private Byte entschuldigt;

	//bi-directional many-to-one association to Schüler
	@ManyToOne
	private Schüler schüler;

	//bi-directional many-to-one association to Tagesregister
	@ManyToOne
	private Tagesregister tagesregister;

	public Fehlt() {
	}

	public FehltPK getId() {
		return this.id;
	}

	public void setId(FehltPK id) {
		this.id = id;
	}

	public Byte getEntschuldigt() {
		return this.entschuldigt;
	}

	public void setEntschuldigt(Byte entschuldigt) {
		this.entschuldigt = entschuldigt;
	}

	public Schüler getSchüler() {
		return this.schüler;
	}

	public void setSchüler(Schüler schüler) {
		this.schüler = schüler;
	}

	public Tagesregister getTagesregister() {
		return this.tagesregister;
	}

	public void setTagesregister(Tagesregister tagesregister) {
		this.tagesregister = tagesregister;
	}

}