package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fehlt database table.
 * 
 */
@Embeddable
public class FehltPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String tagesregister_ID;

	@Column(insertable=false, updatable=false)
	private String schüler_ID;

	public FehltPK() {
	}
	public String getTagesregister_ID() {
		return this.tagesregister_ID;
	}
	public void setTagesregister_ID(String tagesregister_ID) {
		this.tagesregister_ID = tagesregister_ID;
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
		if (!(other instanceof FehltPK)) {
			return false;
		}
		FehltPK castOther = (FehltPK)other;
		return 
			this.tagesregister_ID.equals(castOther.tagesregister_ID)
			&& this.schüler_ID.equals(castOther.schüler_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tagesregister_ID.hashCode();
		hash = hash * prime + this.schüler_ID.hashCode();
		
		return hash;
	}
}