package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the benotung database table.
 * 
 */
@Entity
@NamedQuery(name="Benotung.findAll", query="SELECT b FROM Benotung b")
public class Benotung implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BenotungPK id;

	private short note;

	//bi-directional many-to-one association to Prüfung
	@ManyToOne
	private Prüfung prüfung;

	//bi-directional many-to-one association to Schüler
	@ManyToOne
	private Schüler schüler;

	public Benotung() {
	}

	public BenotungPK getId() {
		return this.id;
	}

	public void setId(BenotungPK id) {
		this.id = id;
	}

	public short getNote() {
		return this.note;
	}

	public void setNote(short note) {
		this.note = note;
	}

	public Prüfung getPrüfung() {
		return this.prüfung;
	}

	public void setPrüfung(Prüfung prüfung) {
		this.prüfung = prüfung;
	}

	public Schüler getSchüler() {
		return this.schüler;
	}

	public void setSchüler(Schüler schüler) {
		this.schüler = schüler;
	}

}