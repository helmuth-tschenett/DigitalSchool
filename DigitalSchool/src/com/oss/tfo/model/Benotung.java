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

	//bi-directional many-to-one association to Pr�fung
	@ManyToOne
	private Pr�fung pr�fung;

	//bi-directional many-to-one association to Sch�ler
	@ManyToOne
	private Sch�ler sch�ler;

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

	public Pr�fung getPr�fung() {
		return this.pr�fung;
	}

	public void setPr�fung(Pr�fung pr�fung) {
		this.pr�fung = pr�fung;
	}

	public Sch�ler getSch�ler() {
		return this.sch�ler;
	}

	public void setSch�ler(Sch�ler sch�ler) {
		this.sch�ler = sch�ler;
	}

}