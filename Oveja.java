package paq1;

public class Oveja extends Animal {

	private String tipoDePelo;

	public Oveja(String nombre, double peso, int edad, String tipoDePelo) {
		super(nombre, peso, edad);
		this.tipoDePelo = tipoDePelo;
	}

	public String getTipoDePelo() {
		return tipoDePelo;
	}

	public void setTipoDePelo(String tipoDePelo) {
		this.tipoDePelo = tipoDePelo;
	}

	@Override
	public void tipoAnimal() {
		// TODO Auto-generated method stub
		
	}
	
	
}
