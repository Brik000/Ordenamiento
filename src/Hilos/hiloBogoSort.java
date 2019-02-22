package Hilos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloBogoSort extends Thread{
	
	private InterfazOrdenamiento inter;
	private Ordenador mundo;
	
	public final static long SLEEP=2;
	public final static int MAX_VALUE=100;
	
	
	public hiloBogoSort(InterfazOrdenamiento inter, Ordenador mundo) {
		super();
		this.inter = inter;
		this.mundo = mundo;
		
	}
	
	@Override
	public void run() {
		
		while(!isSorted(mundo.getLineas(),0)) {
			
			shuffleArray(mundo.getLineas());
			
	        inter.repintarRayas();
			
			try {
				sleep(SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public boolean isSorted(Linea[] ar,int act){
		
		if(act==ar.length-1) {
			return true;
			
		}else if(ar[act].getHeihgt()<ar[act+1].getHeihgt()){
			
			return isSorted(ar,act+1);
		}else {
			return false;
		}
			
		}
	
		
		
	
	
	
	public void shuffleArray(Linea[] ar){
		  
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--){
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Linea a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }

}
