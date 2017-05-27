package it.polito.bar.model;

public class Event implements Comparable<Event>{
	
	public enum EventType{ARRIVO_GRUPPO_CLIENTE, USCITA_GRUPPO_CLIENTE};

	private int time;
	private Gruppo gruppo;
	private EventType type;
	
	public Event(int time, Gruppo gruppo, EventType type) {
		super();
		this.time = time;
		this.gruppo = gruppo;
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Event [time=%s, gruppo=%s, type=%s]", time, gruppo, type);
	}

	@Override
	public int compareTo(Event other) {
		return this.time-other.time;
	}
	
	

}
