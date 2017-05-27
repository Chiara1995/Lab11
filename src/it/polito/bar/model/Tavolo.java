package it.polito.bar.model;

public class Tavolo {
	
	private String nome;
	private int numeroPosti;
	private boolean occupato;
	private Gruppo gruppo;
	
	public Tavolo(String nome, int numeroPosti) {
		super();
		this.nome = nome;
		this.numeroPosti = numeroPosti;
		this.occupato=false;
		this.gruppo=null;
	}
	
	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato=occupato;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome+" "+numeroPosti+" "+occupato;
	}
	
}
