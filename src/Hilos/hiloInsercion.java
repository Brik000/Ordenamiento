package Hilos;

import java.util.Arrays;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloInsercion extends Thread{
	
	private InterfazOrdenamiento inter;
	private Ordenador mundo;
	public final static long SLEEP=5;
	
	public hiloInsercion(InterfazOrdenamiento inter, Ordenador mundo) {
		super();
		this.inter = inter;
		this.mundo = mundo;
	}
	
	
	@Override
	public void run() {
		Linea[] a=mundo.getLineas();
		
		int aux1=0;
		
		try {
			if(!inter.getEstado()) {
				inter.repintarRayas();
			}
			
			while(inter.getEstado()) {
			int i,j;
			Linea temp;
	        for(i=1;i<a.length;i++){
	            j = i-1; 
	            while(i>0 && a[j].getHeihgt() > a[i].getHeihgt()){
	                temp = a[i];
	                a[i] = a[j];
	                a[j] = temp;
	                //importante
	                inter.setActual(a[i]);
	                inter.repintarRayas();
	                
	            }
	            aux1++;
	            sleep(SLEEP); 
	            
	            
	        }
	        if(aux1==a.length) {
	        	inter.setEstado(false);
	        	
	        }
	        
			}

	        }catch (Exception e) {
			// TODO: handle exception
	        	e.printStackTrace();
		}
	}

}
