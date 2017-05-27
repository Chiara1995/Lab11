package it.polito.bar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.polito.bar.model.*;

public class Model {

	public String simulazione(){
		Tavolo t1=new Tavolo("Tavolo1", 10);
		Tavolo t2=new Tavolo("Tavolo2",10);
		Tavolo t3=new Tavolo("Tavolo3",8);
		Tavolo t4=new Tavolo("Tavolo4",8);
		Tavolo t5=new Tavolo("Tavolo5",8);
		Tavolo t6=new Tavolo("Tavolo6",8);
		Tavolo t7=new Tavolo("Tavolo7",6);
		Tavolo t8=new Tavolo("Tavolo8",6);
		Tavolo t9=new Tavolo("Tavolo9",6);
		Tavolo t10=new Tavolo("Tavolo10",6);
		Tavolo t11=new Tavolo("Tavolo11",4);
		Tavolo t12=new Tavolo("Tavolo12",4);
		Tavolo t13=new Tavolo("Tavolo13",4);
		Tavolo t14=new Tavolo("Tavolo14",4);
		Tavolo t15=new Tavolo("Tavolo15",4);
		List<Tavolo> tavoli=new ArrayList<Tavolo>();
		tavoli.add(t1);
		tavoli.add(t2);
		tavoli.add(t3);
		tavoli.add(t4);
		tavoli.add(t5);
		tavoli.add(t6);
		tavoli.add(t7);
		tavoli.add(t8);
		tavoli.add(t9);
		tavoli.add(t10);
		tavoli.add(t11);
		tavoli.add(t12);
		tavoli.add(t13);
		tavoli.add(t14);
		tavoli.add(t15);
		Simulator simulator=new Simulator(tavoli);
		
		int time=8*60;
		Random r=new Random();
		int numero=0;
		
		for(int i=0; i<2000; i++){
			numero=(int)(Math.random()*10);
			if(numero==0)
				numero++;
			Gruppo g=new Gruppo("Gruppo"+String.valueOf(i), /*r.nextInt(/*10-1)+1*/numero, (float) Math.random());
			time+=r.nextInt(10-1)+1;
			simulator.addGruppo(time, g);
		}
		
		simulator.run();
		
		String result="Numero totale clienti "+simulator.getNumero_totale_clienti()+"\n";
		result+="Numero clienti soddisfatti "+simulator.getNumero_clienti_soddisfatti()+"\n";
		result+="Numero clienti insoddisfatti "+simulator.getNumero_clienti_insoddisfatti()+"\n";
		return result;
		
	}
	
	
	

}
