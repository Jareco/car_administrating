import java.text.DecimalFormat;
import java.util.ArrayList;

import at.ac.univie.swe2016.fm.*;
import at.ac.univie.swe2016.fm.fahrzeuge.*;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
/**
 * Frontend. Ermoeglicht die Eingabe und die Ausgabe von Werten. 
 * @author Vitalii Romanov. 
 *
 */
public class FahrzeugClient {
	/**
	 * 
	 * @param args - Die Parameter werden von der Konsole gelesen. 
	 */
	public static void main(String[] args) {
		FahrzeugManagement fm=new FahrzeugManagement(args[0]);
		DecimalFormat df = new DecimalFormat("#.00");
		if(args.length==0){
			System.out.println("Es wurden keine Parameter Uebergeben!");
			System.exit(1);
		} else if (args.length == 1){
			System.out.println("Es fehlt ein zweiter Parameter.");
			System.exit(1);
		}else if (args[1].equals("show")&&args.length==2){
				if(fm.show().size()>0){
				for(Fahrzeug p:fm.show()){
					System.out.println(p.toString()+"\n");
				}
				}else{
					System.out.println("Es gibt keine Autos in der Liste");
					System.exit(1);
				}
			}else if(args[1].equals("show")&&args.length==3){
				try{
					System.out.println((fm.show(Integer.parseInt(args[2])).toString()));
		
				}catch(NullPointerException e){
					System.out.println("Dieses Auto existiert nicht");
					System.exit(1);
				}
			}else if(args[1].equals("add")&&args[2].equals("lkw")&&args.length==8){
				Fahrzeug neuLkw=new LKW(args[4],args[5],Integer.parseInt(args[6]),Double.parseDouble(args[7]),Integer.parseInt(args[3]));
				fm.add(neuLkw);
				System.out.println("LKW wurde hinzugefuegt!");
				
			}else if(args[1].equals("add")&&args[2].equals("pkw")&&args.length==9){
				Fahrzeug neuPkw=new PKW(args[4],args[5],Integer.parseInt(args[6]),Double.parseDouble(args[7]),Integer.parseInt(args[3]), args[8]);
				fm.add(neuPkw);
				System.out.println("PKW wurde hinzugefuegt!");
				
			}else if(args[1].equals("oldest")&&args.length==2){
				
				for(Fahrzeug p:fm.oldest()){
					System.out.println("Id:" +p.getId());
				}
			}else if(args[1].equals("del")&&args.length==3){
				try{
				fm.del(fm.show(Integer.parseInt(args[2])));
				System.out.println("Das Fahrzeug wurde geloescht");
			
				}catch(NullPointerException e){
					System.out.println("Dieses Auto existiert nicht");
					System.exit(1);
				}
					
				
			}else if(args[1].equals("count")&&args.length==2){
				System.out.println(fm.count());
			}else if(args[1].equals("count")&&args[2].equals("lkw")&&args.length==3){
				System.out.println(fm.countLKW());
			}else if(args[1].equals("count")&&args[2].equals("pkw")&&args.length==3){
				System.out.println(fm.countPKW());
			}else if(args[1].equals("meanage")&&args.length==2){
				String meanage=new String(df.format(fm.meanage()));
				meanage=meanage.replace(',', '.');
				System.out.println(meanage);
			}else if(args[1].equals("meanprice")&&args.length==2){
				String meanprice=new String(df.format(fm.meanprice()));
				meanprice=meanprice.replace(',', '.');
				System.out.println(meanprice);
			}else if(args[1].equals("meanprice")&&args[2].equals("lkw")&&args.length==3){
				String meanpricelkw=new String(df.format(fm.meanpriceLKW()));
				meanpricelkw=meanpricelkw.replace(',', '.');
				System.out.println(meanpricelkw);
			}else if(args[1].equals("meanprice")&&args[2].equals("pkw")&&args.length==3){
				String meanpricepkw=new String(df.format(fm.meanpricePKW()));
				meanpricepkw=meanpricepkw.replace(',', '.');
				System.out.println(meanpricepkw);
				
			}else if((args[1].equals("del")&&args[2].equals("since")&&args.length==4)){
				int auto=fm.deletesince(Integer.parseInt(args[3]));
				System.out.println(auto+ " Fahrzeuge entfernt");
			
			
			
			}else{
				System.out.println("Eingabefehler! Entweder falsche Anzahl an parameter oder falsche Parameter");
				System.exit(1);
		}
		
		
	}
	
	
	}
	
	
	
	


