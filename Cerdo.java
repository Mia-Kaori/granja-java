package paq1;

public class Cerdo extends Animal {

	private String color;

	public Cerdo(String nombre, double peso, int edad, String color) {
		super(nombre, peso, edad);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void tipoAnimal() {
		// TODO Auto-generated method stub
		
	}
	
	
}
