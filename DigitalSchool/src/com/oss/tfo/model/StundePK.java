package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the stunde database table.
 * 
 */
@Embeddable
public class StundePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String fach_ID;

	@Column(insertable=false, updatable=false)
	private String stundenEinteilung_ID;

	@Column(insertable=false, updatable=false)
	private String klasse_ID;

	public StundePK() {
	}
	public String getFach_ID() {
		return this.fach_ID;
	}
	public void setFach_ID(String fach_ID) {
		this.fach_ID = fach_ID;
	}
	public String getStundenEinteilung_ID() {
		return this.stundenEinteilung_ID;
	}
	public void setStundenEinteilung_ID(String stundenEinteilung_ID) {
		this.stundenEinteilung_ID = stundenEinteilung_ID;
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
		if (!(other instanceof StundePK)) {
			return false;
		}
		StundePK castOther = (StundePK)other;
		return 
			this.fach_ID.equals(castOther.fach_ID)
			&& this.stundenEinteilung_ID.equals(castOther.stundenEinteilung_ID)
			&& this.klasse_ID.equals(castOther.klasse_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fach_ID.hashCode();
		hash = hash * prime + this.stundenEinteilung_ID.hashCode();
		hash = hash * prime + this.klasse_ID.hashCode();
		
		return hash;
	}
}