package it.polito.bar.model;

public class Gruppo {
	
	private String nome;
	private int numero_persone;
	private float tolleranza;
	
	public Gruppo(String nome,int numero_persone, float tolleranza) {
		super();
		this.nome=nome;
		this.numero_persone = numero_persone;
		this.tolleranza = tolleranza;
	}

	public int getNumero_persone() {
		return numero_persone;
	}

	public void setNumero_persone(int numero_persone) {
		this.numero_persone = numero_persone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public String toString() {
		return nome+" "+numero_persone+" "+tolleranza;
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
		Gruppo other = (Gruppo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
