package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		Playa p=new Playa();
		
		Lancha l= new Lancha("LANCHAS",p);
		Bote b= new Bote("BOTES SALVAVIDAS",p);
	
		
		l.start();
		b.start();
		

		
		
		
	}

}
