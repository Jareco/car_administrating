package swe2016.fm.fahrzeuge.dao;
import java.util.ArrayList;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
/**
 * FahrzeugDAO ist eine abstrakte Klasse, die unterschiedliche Methoden deklariert.
 * Diese Methoden werden in den entsprechenden Klassen beruecksichtigt. 
 * @author Vitalii Romanov
 *
 */
public interface FahrzeugDAO {
	public ArrayList<Fahrzeug> getFahrzeugList();
	public Fahrzeug getFahrzeugbyId(int id);
	public void speichereFahrzeug(Fahrzeug name);
	public void loescheFahrzeug(Fahrzeug name2);
	public void ladenFahrzeug();
	public void neuliste(ArrayList<Fahrzeug> name3);
}
