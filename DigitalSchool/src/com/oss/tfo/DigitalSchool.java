package com.oss.tfo;

import java.sql.Time;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oss.tfo.model.Klasse;
import com.oss.tfo.model.Professor;
import com.oss.tfo.model.Schüler;
import com.oss.tfo.model.Stunde;
import com.oss.tfo.model.Stundeneinteilung;

public class DigitalSchool {

	static EntityManager em;

	public DigitalSchool() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("DigitalSchool");
		this.em = emf.createEntityManager();
	}

	public static void main(String[] args) {
		DigitalSchool ds = new DigitalSchool();
		String tmp = ds.getStundenpläneAsHtmlTable();
		System.out.println(tmp);
//		Query q1 = em.createQuery("Select prof from Professor prof");
//		List<Professor> prof = q1.getResultList();
//		for (Professor pr: prof) {
//			System.out.println(pr.getVorname()+" "+pr.getNachname());			
//		}
//		q1 = em.createQuery("Select sch from Schüler sch");
//		List<Schüler> schülerlist = q1.getResultList();
//		for (Schüler schüler: schülerlist) {
//			System.out.println(schüler.getVorname()+" "+schüler.getNachname());
//			
//		}
	}

	public String getStundenpläneAsHtmlTable() {

		Query q1 = em.createQuery("Select klasse from Klasse klasse");
		List<Klasse> klassen = q1.getResultList();
		
		Query q2 = em.createQuery("Select stundeneinteilung from Stundeneinteilung stundeneinteilung");
		List<Stundeneinteilung> selist = q2.getResultList();
		
		StringBuffer buffer = new StringBuffer();
		for (Klasse klasse : klassen) {
			Map<String, Map<Integer, String>> map = new TreeMap<String, Map<Integer, String>>();
			List<Stunde> stunden = klasse.getStundes();
			Collections.sort(stunden);
			for (Stunde stunde : stunden) {
				Time begin = stunde.getStundeneinteilung().getBeginn();
				Time end = stunde.getStundeneinteilung().getEnde();
				String key = begin.toString() + " - "+end.toString();
				if (!map.containsKey(key))
					map.put(key, new TreeMap<Integer, String>());
				Integer wt = new Integer(stunde.getStundeneinteilung().getWochentag());
				String tmp = map.get(key).get(wt);
				// prüfe ob es die Stunde schon gibt, ist wichtig für die Labor-Stunden, da diese doppelt belegt sind.
				if (tmp!=null) tmp=tmp+ " / " + stunde.getFach().getName();
				else tmp=stunde.getFach().getName();
				map.get(key).put(wt,tmp);
			}
			for (Stundeneinteilung se: selist) {
				if (se.getPause().byteValue()==1) {
					String key = se.getBeginn().toString() + " - "+se.getEnde().toString();
					//System.out.println(se.getWochentag().getName()+": "+se.getBeginn()+" - "+se.getEnde());
					if (!map.containsKey(key))
						map.put(key, new TreeMap<Integer, String>());
					map.get(key).put(new Integer(se.getWochentag()),
							null);
				}
			}
			
			buffer.append("<h3>"+klasse.getName()+"</h3><div id='"+klasse.getName()+"'>");
			buffer.append("<table class=\"stundenplan\" border=\"1\">\n<tr><th>&nbsp;</th>");
			for (int i=1;i<=5;i++) {
				buffer.append("<th>" + Wochentag[i] + "</th>");
			}
			buffer.append("</tr>\n");
			int count=1;
			for (String time : map.keySet()) {
				buffer.append("<tr>");
				buffer.append("<td class=\"stundenplan\">" + (count) + ". Stunde "+ time + "</td>");
				count++;
				for (int i=1;i<=5;i++) {
					String fach = map.get(time).get(i);
					if ((fach!=null)&&(!fach.equals("")))
						buffer.append("<td>" + map.get(time).get(i) + "</td>");
					else
						buffer.append("<td>&nbsp;</td>");
				}
				buffer.append("</tr>\n");
			}
			buffer.append("</table></div>");
		}
		return buffer.toString();
	}

	static String Wochentag[] = {"Sonntag","Montag","Dienstag","Mittwoch", "Donnerstag", "Freitag", "Samstag"};
	
}
