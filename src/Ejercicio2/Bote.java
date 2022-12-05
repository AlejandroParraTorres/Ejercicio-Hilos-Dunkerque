package Ejercicio2;

public class Bote extends Thread {
	
	private String nombre;
	private Playa p;
	private Contador c;
	private int soldadosSalvados;
	
	public Bote(String nombre,Playa p,int prioridad,Contador c) {
		this.nombre=nombre;
		this.p=p;
		this.c=c;
		this.setPriority(prioridad);
		soldadosSalvados=0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public int getSoldadosSalvados() {
		return soldadosSalvados;
	}

	public void aumentarSoldadosSalvados(int soldadosSalvados) {
		this.soldadosSalvados += soldadosSalvados;
	}


	@Override
	public void run() {
		int cantidad;
		int salvados;
		do {
				cantidad=(int)(Math.random()*(400-300+1)+300);
				
				if(p.getSoldados()-cantidad<=0) {
					salvados=p.getSoldados();
				}else{
					salvados=cantidad;
				}
				aumentarSoldadosSalvados(salvados);
				p.rescatarSoldados(this.nombre, salvados);
			
		}while(c.isAlive() &&  p.getSoldados()!=0);
		
	}
	
	

}
