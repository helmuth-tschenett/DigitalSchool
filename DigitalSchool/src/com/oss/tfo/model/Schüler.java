package com.oss.tfo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the schüler database table.
 * 
 */
@Entity
@NamedQuery(name="Schüler.findAll", query="SELECT s FROM Schüler s")
public class Schüler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String adresse;

	private String EMail;

	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;

	private Boolean geschlecht;

	private Boolean mitgliedSchulrat;

	private String nachname;

	private Boolean repetent;

	private String telefonnummer;

	private String telefonnummerEltern;

	private String vorname;

	private short wiederholteJahre;

	//bi-directional many-to-one association to Benotung
	@OneToMany(mappedBy="schüler")
	private List<Benotung> benotungs;

	//bi-directional many-to-one association to Eintragung
	@OneToMany(mappedBy="schüler")
	private List<Eintragung> eintragungs;

	//bi-directional many-to-one association to Fehlt
	@OneToMany(mappedBy="schüler")
	private List<Fehlt> fehlts;

	//bi-directional many-to-one association to Klasse
	@OneToMany(mappedBy="schüler1")
	private List<Klasse> klasses1;

	//bi-directional many-to-one association to Klasse
	@OneToMany(mappedBy="schüler2")
	private List<Klasse> klasses2;

	//bi-directional many-to-one association to Klasse
	@ManyToOne
	private Klasse klasse;

	public Schüler() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	public Date getGeburtsdatum() {
		return this.geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Boolean getGeschlecht() {
		return this.geschlecht;
	}

	public void setGeschlecht(Boolean geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Boolean getMitgliedSchulrat() {
		return this.mitgliedSchulrat;
	}

	public void setMitgliedSchulrat(Boolean mitgliedSchulrat) {
		this.mitgliedSchulrat = mitgliedSchulrat;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Boolean getRepetent() {
		return this.repetent;
	}

	public void setRepetent(Boolean repetent) {
		this.repetent = repetent;
	}

	public String getTelefonnummer() {
		return this.telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getTelefonnummerEltern() {
		return this.telefonnummerEltern;
	}

	public void setTelefonnummerEltern(String telefonnummerEltern) {
		this.telefonnummerEltern = telefonnummerEltern;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public short getWiederholteJahre() {
		return this.wiederholteJahre;
	}

	public void setWiederholteJahre(short wiederholteJahre) {
		this.wiederholteJahre = wiederholteJahre;
	}

	public List<Benotung> getBenotungs() {
		return this.benotungs;
	}

	public void setBenotungs(List<Benotung> benotungs) {
		this.benotungs = benotungs;
	}

	public Benotung addBenotung(Benotung benotung) {
		getBenotungs().add(benotung);
		benotung.setSchüler(this);

		return benotung;
	}

	public Benotung removeBenotung(Benotung benotung) {
		getBenotungs().remove(benotung);
		benotung.setSchüler(null);

		return benotung;
	}

	public List<Eintragung> getEintragungs() {
		return this.eintragungs;
	}

	public void setEintragungs(List<Eintragung> eintragungs) {
		this.eintragungs = eintragungs;
	}

	public Eintragung addEintragung(Eintragung eintragung) {
		getEintragungs().add(eintragung);
		eintragung.setSchüler(this);

		return eintragung;
	}

	public Eintragung removeEintragung(Eintragung eintragung) {
		getEintragungs().remove(eintragung);
		eintragung.setSchüler(null);

		return eintragung;
	}

	public List<Fehlt> getFehlts() {
		return this.fehlts;
	}

	public void setFehlts(List<Fehlt> fehlts) {
		this.fehlts = fehlts;
	}

	public Fehlt addFehlt(Fehlt fehlt) {
		getFehlts().add(fehlt);
		fehlt.setSchüler(this);

		return fehlt;
	}

	public Fehlt removeFehlt(Fehlt fehlt) {
		getFehlts().remove(fehlt);
		fehlt.setSchüler(null);

		return fehlt;
	}

	public List<Klasse> getKlasses1() {
		return this.klasses1;
	}

	public void setKlasses1(List<Klasse> klasses1) {
		this.klasses1 = klasses1;
	}

	public Klasse addKlasses1(Klasse klasses1) {
		getKlasses1().add(klasses1);
		klasses1.setSchüler1(this);

		return klasses1;
	}

	public Klasse removeKlasses1(Klasse klasses1) {
		getKlasses1().remove(klasses1);
		klasses1.setSchüler1(null);

		return klasses1;
	}

	public List<Klasse> getKlasses2() {
		return this.klasses2;
	}

	public void setKlasses2(List<Klasse> klasses2) {
		this.klasses2 = klasses2;
	}

	public Klasse addKlasses2(Klasse klasses2) {
		getKlasses2().add(klasses2);
		klasses2.setSchüler2(this);

		return klasses2;
	}

	public Klasse removeKlasses2(Klasse klasses2) {
		getKlasses2().remove(klasses2);
		klasses2.setSchüler2(null);

		return klasses2;
	}

	public Klasse getKlasse() {
		return this.klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

}