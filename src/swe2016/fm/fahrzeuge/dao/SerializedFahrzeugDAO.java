package swe2016.fm.fahrzeuge.dao;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Diese Klasse implementiert FahrzeugDAO. 
 * Die Serialisierung (Speichern und Laden der Information aus einer Datei) wird realisirt.
 * @author Vitalii Romanov.
 *
 */
public class SerializedFahrzeugDAO implements FahrzeugDAO {
	private String basePath;
	private ArrayList<Fahrzeug> autos=new ArrayList<Fahrzeug>();
	
	/**
	 * Konstruktor der Klasse-
	 * @param basePath - Pfad zur Datei wird gesetzt. 
	 */
	public SerializedFahrzeugDAO(String basePath){
		this.basePath=basePath;
	}
	
	/**
	 * Die ArrayListe wird aus einer Datei geladen.
	 */
	public void ladenFahrzeug(){
	     
	      try {
	         FileInputStream fileIn = new FileInputStream(basePath+".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         autos = (ArrayList<Fahrzeug>)in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c) {
	         System.out.println("Fahrzeug class not found");
	         c.printStackTrace();
	      }
	      

	      
	      
		
	}
	
	
	/**
	 * @return Retuniert die ArrayListe.
	 */
	@Override
	public ArrayList<Fahrzeug> getFahrzeugList() {
		return autos;
		
	}

	/**
	 * @return Retuniert die ArraListe mit entsprechendem ID.
	 */
	public Fahrzeug getFahrzeugbyId(int id) {
		int uid=0;
		Fahrzeug back=null;
		for(Fahrzeug e:autos){
			if(e.getId()==id){
				back=e;
				uid=e.getId();
			}
		}
		
		if(back.getId()==uid)
		return back;
		else return null;
		
	}
	
		
	/**
	 * Bestimmtes Fahrzeug wird geloescht.
	 */
	@Override
	public void loescheFahrzeug(Fahrzeug name2) {
		int d=0;
		try{
		Fahrzeug loeschen=null;
		for(Fahrzeug p:autos){

			if(p.getId()==name2.getId()){
				loeschen=p;
				d=1;
			}
		}
		if(d==1)
			autos.remove(loeschen);
		else throw new IllegalArgumentException();
		}catch(IllegalArgumentException e){
			System.out.println("Diese Datei existiert nicht");
			System.exit(1);
		}
		
		
		try {
			FileOutputStream fileOut=new FileOutputStream(basePath+".ser");
	         try {
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(autos);
				out.close();
				fileOut.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
		
	}
		
		
	
			
   
		
	
	/**
	 * Neues Objekt (Fahrzeug) wird in die Liste und in die Datei gespreichert. 
	 */
	@Override
	public void speichereFahrzeug(Fahrzeug name) {		
		try{	
		int k=0;
			for(Fahrzeug p:autos){
				if(p.getId()==name.getId())
					k=1;
			}
	if(k==0){		
				autos.add(name);
		
		try {
			FileOutputStream fileOut=new FileOutputStream(basePath+".ser");
	         try {
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(autos);
				out.close();
				fileOut.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}else throw new IllegalArgumentException();
		}catch(IllegalArgumentException f){
		System.out.println("Dieses Id ist bereits vorhanden");
		System.exit(1);
	}

		
		
	}
	
	public void neuliste(ArrayList<Fahrzeug> name3){
		
		try {
			FileOutputStream fileOut=new FileOutputStream(basePath+".ser");
	         try {
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(name3);
				out.close();
				fileOut.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	
}