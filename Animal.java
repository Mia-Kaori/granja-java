package paq1;

public abstract class Animal {

	protected String nombre;
	protected double peso;
	protected int edad; 
	
	
	
	public Animal(String nombre, double peso, int edad) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public abstract void tipoAnimal();
	
}
