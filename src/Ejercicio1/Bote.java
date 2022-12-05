package Ejercicio1;

public class Bote extends Thread {
	
	private String nombre;
	private Playa p;
	
	public Bote(String nombre,Playa p) {
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
				cantidad=(int)(Math.random()*(2000-1500+1)+1500);
				p.embarcarSoldados(this.nombre,cantidad);
				Thread.sleep(1);
				p.desembarcarSoldados(this.nombre, cantidad);
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
			
			
		}while(!p.isFinalizado());
		
	}
	
	

}
