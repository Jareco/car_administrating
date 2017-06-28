package at.ac.univie.swe2016.fm.fahrzeuge;
import java.io.IOException;
import java.util.*;
/**
 * Fahrzeug ist eine abstrakte Klasse, die Marke, Modell, Baujahr, Grundpres, ID eines
 * Fahrezeugs definiert.  
 * @author Vitalii Romanov
 * @version 4.11.2016
 *
 */
public abstract class Fahrzeug implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String marke;
	private String modell;
	private int baujahr;
	private double grundpreis;
	private int id;
	
	/**
	 * Konstruktor der Klasse Fahrzeug.
	 * @param marke - Marke vom Auto wird gesetzt.
	 * @param modell - Modell vom Auto wird gesetzt.
	 * @param baujahr - Baujahr vom Auto wird gesetzt.
	 * @param grundpreis - Grundpreis von einem Auto wird gesetzt.
	 * @param id - ID von einem Auto wird gesetzt. 
	 */
	public Fahrzeug(String marke, String modell, int baujahr,
				double grundpreis, int id){
		Calendar now = Calendar.getInstance();
	try{
		int year = now.get(Calendar.YEAR); 
		if(baujahr<1863 || baujahr>year)
			throw new IllegalArgumentException();
	}catch(IllegalArgumentException e){
        	System.out.println("Unmoegliches Baujahr");
        	System.exit(1);
        }
	
		try{
		if(grundpreis<0)
			throw new IllegalArgumentException();
		}catch(IllegalArgumentException e){
			System.out.println("Unmoeglicher Grundpreis");
			System.exit(1);
		}
		
		setMarke(marke);
		setModell(modell);
		setBaujahr(baujahr);
		setGrundpreis(grundpreis);
		setId(id);
		
	}
	
	/**
	 * SetMethode fuer die Marke.
	 * @param marke - Marke eines Fahrzeugs.
	 */
	public void setMarke(String marke){
		this.marke=marke;
	}
	
	/**
	 * SetMethode fuer das Modell.
	 * @param modell - Modell eines Fahrzeugs.
	 */
	public void setModell(String modell){
		this.modell=modell;
	}
	
	/**
	 * SetMethode fuer das Baujah.
	 * @param baujahr - Das Baujahr eines Fahrzeugs.
	 */
	public void setBaujahr(int baujahr){
		this.baujahr=baujahr;
		
	}
	
	/**
	 * SetMethode fuer den Grundpreis eines Fahrzeugs.
	 * @param grundpreis - Der Preis eines Fahrzeugs.
	 */
	public void setGrundpreis(double grundpreis){
		this.grundpreis=grundpreis;
	}
	
	/**
	 * SetMethode fuer ID eines Fahrzeugs.
	 * @param id - id enses Fahrzeugs.
	 */
	public void setId(int id){
		this.id=id;
	}
	
	/**
	 * @return retuniert id eines Fahrzeugs.
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * @return retuniert das Baujahr eines Fahrzeugs.
	 */
	public int getBaujahr(){
		return baujahr;
	}
	
	/**
	 * @return returniert die Marke eines Fahrzeugs.
	 */
	public String getMarke(){
		return marke;
	}
	
	/**
	 * @return retuniert das Modell eines Fahrzeugs. 
	 */
	public String getModell(){
		return modell;
	}
	
	/**
	 * @return retuniert den Grundpreis eines Fahrzeugs.
	 */
	public double getGrundpreis(){
		return grundpreis;
	}
	
	/**
	 * @return retuniert das Alter eines Fahrzeugs.
	 */
	public int getAlter(){
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);    
		return year-baujahr;
	}
	
	/**
	 * Abstrakte Methode, die in den Entsprechenden Klassen implementiert wird.
	 * @return Es berechnet und retuniert Rabatt.
	 */
	public abstract double getRabatt();
	
	/**
	 * @return Berechnet und retouniert den Preis eines Fahrzeugs.
	 */
	public double getPreis(){
		
		return grundpreis-getRabatt();
	}
	
	/**
	 * Abstrakte Methode, die die in den entsprechenden Klasssen implementiert wird. 
	 * @return retuniert den Typ des Fahrzeugs.
	 */
	public abstract String getTyp();
	
	
}
