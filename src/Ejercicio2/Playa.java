package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Playa {
	
	private int soldados;
	private static int soldadosRescatados;
	private Semaphore semaforo;
	
	public Playa(Semaphore semaforo) {
		soldados=400000;
		this.semaforo=semaforo;
	}
	
	public static int getSoldadosRescatados() {
		return soldadosRescatados;
	}

	public static void setSoldadosRescatados(int soldadosRescatados) {
		Playa.soldadosRescatados = soldadosRescatados;
	}
	
	public int getSoldados() {
		return soldados;
	}

	public void setSoldados(int soldados) {
		this.soldados = soldados;
	}
	
	public synchronized void restoSoldados(int cantidad) {
		this.soldados-=cantidad;
	}
	
	public synchronized void añadirSoldadosRescatados(int cantidad) {
		Playa.soldadosRescatados+=cantidad;
	}




	public void rescatarSoldados(String nombre,int cantidad) {
		
		embarcarSoldados(nombre,cantidad);
		desembarcarSoldados(nombre,cantidad);

	}
	
	
	
	public void embarcarSoldados(String nombre,int cantidad) {
		try {
				semaforo.acquire();
				restoSoldados(cantidad);
				añadirSoldadosRescatados(cantidad);
				System.out.println("1 - Han embarcado " + cantidad + " soldados en " + nombre);
				Thread.sleep(400);
				semaforo.release();
		}catch(InterruptedException e) {
			System.out.println(e.getStackTrace());
		}	
	}
	
	public void  desembarcarSoldados(String nombre,int cantidad) {
		
		try {
				System.out.println("3 - Han desembarcado en los barcos de alta mar los " + cantidad + " soldados desde " + nombre);
				Thread.sleep(500);
				
			
	}catch(InterruptedException e) {
		System.out.println(e.getStackTrace());
	}
		
		
	}

}
