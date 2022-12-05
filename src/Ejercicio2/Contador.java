package Ejercicio2;


public class Contador extends Thread{
	
	public  Contador(int prioridad) {
		this.setPriority(prioridad);
		}
	
	
	public void comprobarDias(int horas) {
		if(horas==24) {
			System.out.println("5 - HAN PASADO 1 DIA DE COMBATE");
		}else if(horas==48) {
			System.out.println("5 - HAN PASADO 2 DIAS DE COMBATE");
		}else if(horas==72) {
			System.out.println("5 - HAN PASADO 3 DIAS DE COMBATE");
		}else if(horas==96) {
			System.out.println("5 - HAN PASADO 4 DIAS DE COMBATE");
		}else if(horas==120) {
			System.out.println("5 - HAN PASADO 5 DIAS DE COMBATE");
			
		}else if(horas==144) {
			
				System.out.println("5 - HAN PASADO 6 DIAS DE COMBATE");
			
		}
	}
		
	public void contador() {
		try {
				for(int i=0;i<=144;i++) {
					Thread.sleep(1000);
					comprobarDias(i);
				}
		}catch (InterruptedException e) {
			return;		
		}														
	}	
	@Override
	public void run() {
		this.contador();
	}
}	
