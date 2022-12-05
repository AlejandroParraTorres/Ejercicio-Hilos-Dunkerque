package Ejercicio1;

public class Lancha extends Thread {
	
	private String nombre;
	private Playa p;
	
	public Lancha(String nombre,Playa p) {
		this.nombre=nombre;
		this.p=p;
	}
	


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public void run() {
		int cantidad;
		do {
			try {
				cantidad=(int)(Math.random()*(1000-500+1)+500);
				p.embarcarSoldados(this.nombre,cantidad);
				Thread.sleep(1);
				p.desembarcarSoldados(this.nombre, cantidad);
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
			
		}while(!p.isFinalizado());
		
	}
	
	

}
