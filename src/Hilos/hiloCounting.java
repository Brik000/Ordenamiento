package Hilos;

import javax.swing.JOptionPane;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloCounting extends Thread{

	
	private InterfazOrdenamiento inter;
	private Ordenador mundo;

	public final static long SLEEP=5;
	public final static int MAX_VALUE=100;
	
	public hiloCounting(InterfazOrdenamiento inter, Ordenador mundo) {
		super();
		this.inter = inter;
		this.mundo = mundo;
		
	}
	
	
	@Override
	public void run() {
		Linea [] a=mundo.getLineas();
		
		Linea b[] =new Linea[a.length];
		
		int[] frec=new int[MAX_VALUE+1];
		while(!inter.getEstado()) {
		
		for (int i = 0; i < frec.length; i++) {
			frec[i]=0;
		}
		
		for (int i = 0; i < a.length; i++) {
			frec[a[i].getHeihgt()]=frec[a[i].getHeihgt()]+1;
			
			inter.setActual(a[i]);
	        inter.repintarRayas();
	        try {
				sleep(SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i=1; i<MAX_VALUE+1; i++) {
	        frec[i] = frec[i] + frec[i-1];
	        
	        }
		
		for (int j=a.length-1; j>=0; j--)
	    {
	        b[frec[a[j].getHeihgt()]-1] = a[j];
	        
	        frec[a[j].getHeihgt()] = frec[a[j].getHeihgt()] - 1;
	        
	        //mundo.setLineas(b);
	        inter.setActual(a[j]);
	        inter.repintarConGuia(b);
	        try {
				sleep(SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
		
		try {
			sleep(SLEEP);
			inter.setEstado(true);
//			inter.repintarConGuia(b);
//			inter.repintarConGuia(b);
//			inter.revalidate();
//			inter.repaint();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		}  
		
		
		
	}

		
		}	