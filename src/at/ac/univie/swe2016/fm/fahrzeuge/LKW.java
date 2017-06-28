package at.ac.univie.swe2016.fm.fahrzeuge;
import java.text.DecimalFormat;
import java.util.*;
/**
 * LKW ist eine public Klasse, die die Instanzvariablen und die Methoden von der
 * abstrakten Klasse vererbt und die Eigenschaften eines LKW definiert.
 * @author Vitalii Romanov.
 *
 */
public class LKW extends Fahrzeug implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;


	/**
	 * Konstruktor der Klasse LKW. Er ruft den Suporkonstruktor von der Oberklasse.
	 * @param marke - Marke eines LKW wird definiert.
	 * @param modell - Modell eines LKW wird definiert.
	 * @param baujahr - Das Baujahr eines LKW wird definirt.
	 * @param grundpreis - Der Grundpreis eines LKW wird definiert.
	 * @param id - ID eines LKW wird definiert.
	 */
	public LKW(String marke, String modell, int baujahr,
			double grundpreis,int id) {
  super(marke, modell, baujahr, grundpreis, id);
}
	
	
	/**
	 * Berechnet und retuniert Rabatt von einem LKW.
	 * @param maxrabat - Maximal moegliches Rabatt wird berechnet.
	 * @param rabatt - Rabatt ohne Jahresbeschraenkung wird berechnet.
	 * @param endrabatt - Rabatt wird anhand Bedingung berechnet. 
	 */
	public double getRabatt(){
		double maxrabatt=(getGrundpreis())/5;
		double rabatt=getAlter()*5;
		double endrabatt=0;
		if(getGrundpreis()*(rabatt/100)>maxrabatt)
			endrabatt=maxrabatt;
		else endrabatt=getGrundpreis()*(rabatt/100);
		return endrabatt;
	}
	
	/**
	 * @return Der Typ des Fahrzeugs wird retuniert.
	 */
	public String getTyp(){
		String typ="LKW";
		return typ;
	}
	
	
	/**
	 * Ausgabemethode, die laut Bedingnung die Ausgabe ermoeglicht. 
	 * DecimalFormat wird beruecksichtigt. 
	 */
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		String preis=new String(df.format(getPreis()));
		preis=preis.replace(',', '.');
		String grundpreis=new String(df.format(getGrundpreis()));
		grundpreis=grundpreis.replace(',', '.');

		return "Typ: LKW"+"\n"+"Id: "+getId()+"\n"+"Marke: "+getMarke()+"\n"+
				"Modell: "+ getModell()+"\n"+"Baujahr: "+getBaujahr()+"\n"+
				"Grundpreis: "+grundpreis+"\n"+"Preis: "+preis;
		
	}



	
	

}
