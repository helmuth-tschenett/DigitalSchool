package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the benotung database table.
 * 
 */
@Embeddable
public class BenotungPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int prüfung_ID;

	@Column(insertable=false, updatable=false)
	private String schüler_ID;

	public BenotungPK() {
	}
	public int getPrüfung_ID() {
		return this.prüfung_ID;
	}
	public void setPrüfung_ID(int prüfung_ID) {
		this.prüfung_ID = prüfung_ID;
	}
	public String getSchüler_ID() {
		return this.schüler_ID;
	}
	public void setSchüler_ID(String schüler_ID) {
		this.schüler_ID = schüler_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BenotungPK)) {
			return false;
		}
		BenotungPK castOther = (BenotungPK)other;
		return 
			(this.prüfung_ID == castOther.prüfung_ID)
			&& this.schüler_ID.equals(castOther.schüler_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prüfung_ID;
		hash = hash * prime + this.schüler_ID.hashCode();
		
		return hash;
	}
}