package at.ac.univie.swe2016.fm;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;
/**
 * Steuerung von Funktionen des Programms. Die Grundlage fuer das Frontend.  
 * @author Vitalii Romanov
 *
 */
public class FahrzeugManagement {
private FahrzeugDAO fahrzeugDAO;
private String basePath;
private ArrayList<Fahrzeug> showFahrzeug=new ArrayList<Fahrzeug>();
private ArrayList<Fahrzeug> old=new ArrayList<Fahrzeug>();

/**
 * Konstruktor der Klasse.
 * @param basePath - Pfad zur Datei, die Information fuer das Profgramm hat.
 */
public FahrzeugManagement(String basePath){
	setBasepath(basePath);	
	this.basePath=basePath;
}

/**
 * 
 * @return retouniert interface FahrzeugDAO.
 */
public FahrzeugDAO getFahrzeugDAO(){
	return this.fahrzeugDAO;
}

/**
 * SetMethode fuer den Pfad zur Datei, die Information fuer das Programm enthält.
 * @param basePath - Pfad zur Datei.
 */
public void setBasepath(String basePath){
this.fahrzeugDAO = new SerializedFahrzeugDAO(basePath);

}

/**
 * 
 * @return retuniert eine ArrayListe mit allen Fahrzeugen.
 */
public ArrayList<Fahrzeug> show(){
	if(Files.exists(Paths.get(basePath+".ser")))
	fahrzeugDAO.ladenFahrzeug();
	else{
		System.out.println("Die Datei existiert nicht");
		System.exit(1);
	}
	showFahrzeug=fahrzeugDAO.getFahrzeugList();
return showFahrzeug;
}

/**
 * Fuegt ein neues Fahrzeug hinzu.
 * @param name - irgendein Fahrzeugobjekt.
 */
public void add(Fahrzeug name){
	if(Files.exists(Paths.get(basePath+".ser"))){
	fahrzeugDAO.ladenFahrzeug();
	fahrzeugDAO.speichereFahrzeug(name);
	}else fahrzeugDAO.speichereFahrzeug(name);

}

/**
 * Loescht das Fahrzeug mit einem bestimmten ID.
 * @param name2 - irgendein Fahrzeugobjekt.
 */
public void del(Fahrzeug name2){
	fahrzeugDAO.ladenFahrzeug();
	fahrzeugDAO.loescheFahrzeug(name2);
}

/**
 * 
 * @param id - id eines Fahrzeug
 * @return retuniert ein Objekt mit einem bestimmten ID.
 */
public Fahrzeug show(int id){
	fahrzeugDAO.ladenFahrzeug();
	Fahrzeug iD=fahrzeugDAO.getFahrzeugbyId(id);
	return iD;
}

/**
 * Zaehlt die Anzahl der Fahrzeuge.
 * @return retuniert die Anzahl der Fahrzeuge.
 */
public int count(){
	fahrzeugDAO.ladenFahrzeug();
	int counter=(fahrzeugDAO.getFahrzeugList()).size();
	return counter;
}

/**
 * Zaehlt die Anzahl der PKWs.
 * @return retuniert die Anzahl der PKWs.
 */
public int countPKW(){
	fahrzeugDAO.ladenFahrzeug();
	int pkw=0;
	for(Fahrzeug p:fahrzeugDAO.getFahrzeugList()){
		if(p.getTyp()=="PKW"){
		pkw++;
		}
	}
	return pkw;
}

/**
 * Zaehlt die Anzahl der LKWs.
 * @return retuniert die Anzahl der LKWs.
 */
public int countLKW(){
	fahrzeugDAO.ladenFahrzeug();
	int lkw=0;
	for(Fahrzeug p:fahrzeugDAO.getFahrzeugList()){
	if(p.getTyp()=="LKW"){
		lkw++;
		}
	}
	return lkw;
}

/**
 * Berechnet den Durchschnittspreis aller Fahrzeuge. 
 * @return retuniert den Durschscnittspreis aller Fahrzeuge. 
 */
public double meanprice(){
	fahrzeugDAO.ladenFahrzeug();
	double durchPreis=0;
	for(Fahrzeug p:fahrzeugDAO.getFahrzeugList()){
		durchPreis=durchPreis+p.getPreis();
	}
	
	durchPreis=durchPreis/(fahrzeugDAO.getFahrzeugList()).size();
	
	return durchPreis;
}

/**
 * Berechnet den Durchschnittspreis aller PKW.
 * @return retuniert den Durchschnittspreis aller PKW.
 */
public double meanpricePKW(){
	fahrzeugDAO.ladenFahrzeug();
	double durchPreis=0;
	int count=0;
	for(Fahrzeug p:fahrzeugDAO.getFahrzeugList()){
		if(p.getTyp()=="PKW"){
		count++;
		durchPreis=durchPreis+p.getPreis();
		}
	}
	durchPreis=durchPreis/count;
	
	return durchPreis;
}

/**
 * Berechnet den Durchschnittspreis aller LKW.
 * @return retuniert den Durchschnittspreis allaer LKW.
 */
public double meanpriceLKW(){
	fahrzeugDAO.ladenFahrzeug();
	double durchPreis=0;
	int count=0;
	for(Fahrzeug p:fahrzeugDAO.getFahrzeugList()){
		if(p.getTyp()=="LKW"){
		count++;
		durchPreis=durchPreis+p.getPreis();
		}
	}
	durchPreis=durchPreis/count;
	
	return durchPreis;
}

/**
 * Berechnet das Durchschnittsalter aller Fahrzeuge.
 * @return retuniert das Durchschnittsalter aller Fahrzeuge.
 */
public double meanage(){
	fahrzeugDAO.ladenFahrzeug();
	double durchAlter=0;
	for (Fahrzeug k: fahrzeugDAO.getFahrzeugList()){
		durchAlter=durchAlter+k.getAlter();
	}
	
	durchAlter=durchAlter/(fahrzeugDAO.getFahrzeugList()).size();
	return durchAlter;
	
}

/**
 * Sucht die aeltesten Fahrzeuge in einer ArrayListe.
 * @return retuniert die ArrayLisste der aeltesten Fahrzeuge.
 */
public ArrayList<Fahrzeug> oldest(){
	fahrzeugDAO.ladenFahrzeug();
	int oldest=0;
	int altid=0;
	for(Fahrzeug c:fahrzeugDAO.getFahrzeugList()){
		if(c.getAlter()>oldest)
			oldest=c.getAlter();
	}
	
	for(Fahrzeug c:fahrzeugDAO.getFahrzeugList()){
		if(c.getAlter()==oldest){
			old.add(c);
	
		}
	}
      	return old;
}

public int deletesince(int year){
	fahrzeugDAO.ladenFahrzeug();
	ArrayList<Fahrzeug> list=new ArrayList<Fahrzeug>();
	for(Fahrzeug p: fahrzeugDAO.getFahrzeugList()){
		list.add(p);
	}
	
	int s=0;
	for(Fahrzeug p: list){
		if(year<=(p.getBaujahr()))
			s=1;
	}
	int zaehler=0;	
	if(s!=1){
		System.out.println("Keine Fahrzeuge aelter");
		System.exit(1);
	}
	for(Fahrzeug p: fahrzeugDAO.getFahrzeugList()){
		if(year<=(p.getBaujahr())){
			list.remove(p);
			zaehler++;
		
		}
		fahrzeugDAO.neuliste(list);
		
	}
	return zaehler;
}

}
	

