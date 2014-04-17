package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eintragung database table.
 * 
 */
@Entity
@NamedQuery(name="Eintragung.findAll", query="SELECT e FROM Eintragung e")
public class Eintragung implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EintragungPK id;

	private String grund;

	//bi-directional many-to-one association to Schüler
	@ManyToOne
	private Schüler schüler;

	//bi-directional many-to-one association to Tagesregister
	@ManyToOne
	private Tagesregister tagesregister;

	public Eintragung() {
	}

	public EintragungPK getId() {
		return this.id;
	}

	public void setId(EintragungPK id) {
		this.id = id;
	}

	public String getGrund() {
		return this.grund;
	}

	public void setGrund(String grund) {
		this.grund = grund;
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