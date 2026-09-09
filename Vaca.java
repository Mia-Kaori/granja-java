package paq1;
import java.util.*;
public class Vaca extends Animal implements LecheProducida {

	private String uso;

	public Vaca(String nombre, double peso, int edad, String uso) {
		super(nombre, peso, edad);
		this.uso = uso;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	@Override
	public void tipoAnimal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double ordenyar() {
		// TODO Auto-generated method stub
		Random r = new Random();
		double numero = r.nextDouble(3,8);
		numero = Math.round(numero*10.0)/10.0;
		return numero;
	} 
	
	
	
}
