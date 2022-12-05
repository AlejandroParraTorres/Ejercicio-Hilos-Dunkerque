package Ejercicio1;

public class Playa {
	
	private static int soldados;
	private boolean finalizado;
	private static int soldadosRescatados;
	private static int contadorHoras;
	
	public Playa() {
		soldados=400000;
		finalizado=false;
	}
	
	
	public boolean isFinalizado() {
		return finalizado;
	}


	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}


	public static int getSoldados() {
		return soldados;
	}
	public static void setSoldados(int soldados) {
		Playa.soldados = soldados;
	}
	
	public void rescatarSoldados(int cantidad) {
		Playa.soldados-=cantidad;
	}
	
	public void comprobarDias() {
		if(contadorHoras==24) {
			System.out.println("5 - HAN PASADO 1 DIA DE COMBATE");
		}else if(contadorHoras==48) {
			System.out.println("5 - HAN PASADO 2 DIAS DE COMBATE");
		}else if(contadorHoras==72) {
			System.out.println("5 - HAN PASADO 3 DIAS DE COMBATE");
		}else if(contadorHoras==96) {
			System.out.println("5 - HAN PASADO 4 DIAS DE COMBATE");
		}else if(contadorHoras==120) {
			System.out.println("5 - HAN PASADO 5 DIAS DE COMBATE");
			
		}else if(contadorHoras==144) {
			System.out.println("5 - HAN PASADO 6 DIAS DE COMBATE");
			this.finalizado=true;
			
				System.out.println("6 - " + Playa.getSoldados() + " soldados han tenido que rendirse ante el ejército alemán");
				System.out.println("--------------------FIN DEL PROGRAMA------------------------------");
			
		}
	}
	
	public synchronized void embarcarSoldados(String nombre,int cantidad) {
		try {
				
				System.out.println("1 - Han embarcado " + cantidad + " soldados en " + nombre);
				Thread.sleep(500);
				rescatarSoldados(cantidad);
				System.out.println("2 - Quedan " + getSoldados() + " en la playa");
				
		}catch(InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
			
	}
	
	public synchronized void  desembarcarSoldados(String nombre, int cantidad) {
		
		try {
			
				System.out.println("3 - Han desembarcado en los barcos de alta mar los " + cantidad + " soldados desde " + nombre);
				Thread.sleep(500);
				contadorHoras++;
				soldadosRescatados+=cantidad;
				System.out.println("4 - Han embarcado " + soldadosRescatados + " soldados en total");
				comprobarDias();
			
			
			
	}catch(InterruptedException e) {
		System.out.println(e.getStackTrace());
	}
		
		
	}

}
