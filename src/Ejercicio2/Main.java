package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo= new Semaphore(7);
		Playa p=new Playa(semaforo);
		Contador c= new Contador(Thread.MAX_PRIORITY);
		
		Bote [] b = new Bote[5];
		Lancha [] l = new Lancha[5];
		
		for(int i=0;i<5;i++) {
			b[i]= new Bote("BOTE SALVAVIDA " + (i+1),p,Thread.NORM_PRIORITY,c);
		}
		
		for(int i=0;i<5;i++) {
			l[i]= new Lancha("LANCHA " + (i+1),p,Thread.MIN_PRIORITY,c);
		}
		
		for(int i=0;i<5;i++) {
			b[i].start();
			l[i].start();
		}
		
		c.start();
		
		while (c.isAlive()) {
			try{
                Thread.sleep(900);
                System.out.println("2 - Quedan " + p.getSoldados() + " en la playa");
                System.out.println("4 - Han embarcado " + Playa.getSoldadosRescatados() + " soldados en total");
            }catch (InterruptedException exc){
                System.out.println("Hilo principal interrumpido.");
            }    
		}
		
		c.interrupt();
		
		
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i].getNombre() + " ha logrado rescatar a " + b[i].getSoldadosSalvados());
		}
		
		for(int i=0;i<l.length;i++) {
			System.out.println(l[i].getNombre() + " ha logrado rescatar a " + l[i].getSoldadosSalvados());
		}
		
		
		System.out.println("6 - " + p.getSoldados() + " soldados han tenido que rendirse ante el ejército alemán");
		System.out.println("--------------------FIN DEL PROGRAMA------------------------------");

		
		
		
	}

}
