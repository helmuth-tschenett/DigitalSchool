package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the unterrichtet database table.
 * 
 */
@Embeddable
public class UnterrichtetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String professor_ID;

	@Column(insertable=false, updatable=false)
	private String fach_ID;

	@Column(insertable=false, updatable=false)
	private String klasse_ID;

	public UnterrichtetPK() {
	}
	public String getProfessor_ID() {
		return this.professor_ID;
	}
	public void setProfessor_ID(String professor_ID) {
		this.professor_ID = professor_ID;
	}
	public String getFach_ID() {
		return this.fach_ID;
	}
	public void setFach_ID(String fach_ID) {
		this.fach_ID = fach_ID;
	}
	public String getKlasse_ID() {
		return this.klasse_ID;
	}
	public void setKlasse_ID(String klasse_ID) {
		this.klasse_ID = klasse_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UnterrichtetPK)) {
			return false;
		}
		UnterrichtetPK castOther = (UnterrichtetPK)other;
		return 
			this.professor_ID.equals(castOther.professor_ID)
			&& this.fach_ID.equals(castOther.fach_ID)
			&& this.klasse_ID.equals(castOther.klasse_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.professor_ID.hashCode();
		hash = hash * prime + this.fach_ID.hashCode();
		hash = hash * prime + this.klasse_ID.hashCode();
		
		return hash;
	}
}