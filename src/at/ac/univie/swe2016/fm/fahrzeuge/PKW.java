package at.ac.univie.swe2016.fm.fahrzeuge;
import java.util.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
/**
 * 
 * @author Vitalii Romanov.
 *PKW ist eine public Klasse, die die Instanzvariablen und die Metoden von der abstrakten
 *Klasse "Fahrzeug" vererbt. Sie definiert die Eigenschaften eines PKW.
 */
public class PKW extends Fahrzeug implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int jahre;
    private String date;
   	
   	/**
   	 * Konstruktor der PKW-Klasse. 
   	 * @param marke - Marke des PKW wird definiert.
   	 * @param modell - Modell des PKW wird definiert.
   	 * @param baujahr - Baujahr des PKW wird definiert.
   	 * @param grundpreis - Grundpreis des PKW wird definiert.
   	 * @param id - ID des PKW wird definiert.
   	 * @param date - Ueberpruefungsdatum des PKW wird definiert.
   	 */
	public PKW(String marke, String modell, int baujahr,
				double grundpreis,int id, String date) {
	  super(marke, modell, baujahr, grundpreis, id);
	  setUebeprdatum(date);
	}
	
	/**
	 * Das Ueberpruefungsdatum wird Gesetz. Der Unterschied zwischen Uebuerpruefungsdatum
	 * und Heute wird berechnet.
	 * @param date -  Ueberpruefungsdatum.
	 * @param jahre - Jahredifferenz zwischen Ueberpruefungsdatum und Heute. 
	 */
	public void setUebeprdatum(String date){
		this.date=date;
		
		LocalDate frueher = LocalDate.parse(date);
		LocalDate jetzt = LocalDate.now();
		try{
			if(frueher.getYear()>jetzt.getYear()||((frueher.getYear()==jetzt.getYear()&&
					(frueher.getMonthValue()>jetzt.getMonthValue()))||
					((frueher.getYear()==jetzt.getYear())&& (frueher.getMonthValue()==jetzt.getMonthValue()))&&
					(frueher.getDayOfMonth()>jetzt.getDayOfMonth())) || frueher.getYear()<getBaujahr())
				throw new IllegalArgumentException();
			else {
				Period differenz = Period.between(frueher,jetzt);
				jahre = differenz.getYears();
			}
		
		}catch(IllegalArgumentException e){
			System.out.println("Unmoegliches Ueberpruefsdatum");
					System.exit(1);
		}
	}
	
	
	

	
	/**
	 * Berechen Rabatt des PKW.
	 * @param projahr - Prozentrabatt pro Jahr (abhaengig von der Ueberpruefungsdatum).
	 * @param proalter - Prozentrabatt pro Altersjahr.
	 * @param rabatt - Moegliches Rabatt. Abhaengig von der Bedingung.
	 * @param maxrabatt - Maximal moeglichens Rabatt.
	 * @param endrabatt - Rabatt wird anhand Bedingung berechnet. 
	 */
	@Override 
	public double getRabatt(){
		double projahr=2*jahre;
		double proalter=5*getAlter();
		double rabatt=projahr+proalter;
		double maxrabatt=getGrundpreis()*0.15;
	    double endrabatt;
		if(getGrundpreis()*(rabatt/100)>maxrabatt)
	    	endrabatt=maxrabatt;
		else endrabatt=getGrundpreis()*(rabatt/100);
        return endrabatt;
	}
	
	/**
	 * @return Retuniert den Typ des Fahrzeugs.
	 */
	public String getTyp(){
		String typ="PKW";
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
		return "Typ: PKW"+"\n"+"Id: "+getId()+"\n"+"Marke: "+getMarke()+"\n"+
				"Modell: "+ getModell()+"\n"+"Baujahr: "+getBaujahr()+"\n"+
				"Grundpreis: "+grundpreis+"\n"+"Ueberpruefungsdatum: "+date+
				"\n"+"Preis: "+preis;
		
	}
	


}
