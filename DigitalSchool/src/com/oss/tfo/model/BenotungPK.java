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
	private int pr�fung_ID;

	@Column(insertable=false, updatable=false)
	private String sch�ler_ID;

	public BenotungPK() {
	}
	public int getPr�fung_ID() {
		return this.pr�fung_ID;
	}
	public void setPr�fung_ID(int pr�fung_ID) {
		this.pr�fung_ID = pr�fung_ID;
	}
	public String getSch�ler_ID() {
		return this.sch�ler_ID;
	}
	public void setSch�ler_ID(String sch�ler_ID) {
		this.sch�ler_ID = sch�ler_ID;
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
			(this.pr�fung_ID == castOther.pr�fung_ID)
			&& this.sch�ler_ID.equals(castOther.sch�ler_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pr�fung_ID;
		hash = hash * prime + this.sch�ler_ID.hashCode();
		
		return hash;
	}
}