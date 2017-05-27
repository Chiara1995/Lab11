package it.polito.bar.model;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.bar.model.Event.EventType;

public class Simulator {
	
	//Parametri di simulazione
	private List<Tavolo> tavoli;
	private int DURATA_MIN_SERVIZIO=60;
	private int DURATA_MAX_SERVIZIO=120;
	
	//Stato del mondo
	
	//Variabili d'interesse
	private int numero_totale_clienti=0;
	private int numero_clienti_soddisfatti=0;
	private int numero_clienti_insoddisfatti=0;
	
	//Lista degli eventi
	private PriorityQueue<Event> queue;
	
	private Simulator(List<Tavolo> tavoli){
		this.tavoli=tavoli;
		this.queue=new PriorityQueue<>();
	}
	
	public void addGruppo(int time, Gruppo g){
		queue.add(new Event(time, g, EventType.ARRIVO_GRUPPO_CLIENTE));
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}

	public int getDURATA_MIN_SERVIZIO() {
		return DURATA_MIN_SERVIZIO;
	}

	public void setDURATA_MIN_SERVIZIO(int dURATA_MIN_SERVIZIO) {
		DURATA_MIN_SERVIZIO = dURATA_MIN_SERVIZIO;
	}

	public int getDURATA_MAX_SERVIZIO() {
		return DURATA_MAX_SERVIZIO;
	}

	public void setDURATA_MAX_SERVIZIO(int dURATA_MAX_SERVIZIO) {
		DURATA_MAX_SERVIZIO = dURATA_MAX_SERVIZIO;
	}

	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}

	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}

	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}
	
	public void run(){
		while(!queue.isEmpty()){
			Event e=queue.poll();
			switch(e.getType()){
			case ARRIVO_GRUPPO_CLIENTE:
				boolean assegnato=false;
				for(Tavolo t : this.tavoli){
					if(t.getOccupato()==false && t.getNumeroPosti()>=e.getGruppo().getNumero_persone() && e.getGruppo().getNumero_persone()>=0.5*t.getNumeroPosti()){
						//tavolo vuoto
						t.setGruppo(e.getGruppo());
						t.setOccupato(true);
						this.numero_totale_clienti+=e.getGruppo().getNumero_persone();
						this.numero_clienti_soddisfatti+=e.getGruppo().getNumero_persone();
						assegnato=true;
						int durata=this.DURATA_MIN_SERVIZIO+(int)(Math.random()*(this.DURATA_MAX_SERVIZIO-this.DURATA_MIN_SERVIZIO));
						queue.add(new Event(e.getTime()+durata, e.getGruppo(), EventType.USCITA_GRUPPO_CLIENTE));
					}
				}
				if(assegnato==false){
					//non assegno tavolo
					if(e.getGruppo().getTolleranza()<=0.5){
						//non occupano bancone ed escono
						this.numero_totale_clienti+=e.getGruppo().getNumero_persone();
						this.numero_clienti_insoddisfatti+=e.getGruppo().getNumero_persone();
					}
					else{
						//occupano bancone
						this.numero_totale_clienti+=e.getGruppo().getNumero_persone();
						this.numero_clienti_soddisfatti+=e.getGruppo().getNumero_persone();	
					}
				}
				break;
			case USCITA_GRUPPO_CLIENTE:
				for(Tavolo t : this.tavoli){
					if(t.getGruppo().equals(e.getGruppo())){
						t.setGruppo(null);
						t.setOccupato(false);
					}
				}
				break;
			}
		}
	}

}
