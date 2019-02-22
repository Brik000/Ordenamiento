package Hilos;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloQuick extends Thread{
	
	private InterfazOrdenamiento inter;
	private Ordenador mundo;
	private Linea[] a;
	public final static long SLEEP=20;
	public  int ancho;
	
	public hiloQuick(InterfazOrdenamiento inter, Ordenador mundo) {
		
		this.inter = inter;
		this.mundo = mundo;
	}
	
	
	@Override
	public void run() {
		a=mundo.getLineas();
		
		ancho=a[0].getWidht();
		
		quickSort(0,a.length-1);		
	}
	
	private void quickSort(int lowerIndex, int higherIndex) {
		inter.repintarRayas();
        int i = lowerIndex;
        int j = higherIndex;
        try {
			Thread.currentThread().sleep(SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        int pivot = a[lowerIndex+(higherIndex-lowerIndex)/2].getHeihgt();
        inter.setActual(a[lowerIndex+(higherIndex-lowerIndex)/2]);
		inter.repintarRayas();
        
    	
        while (i <= j) {
          
            while (a[i].getHeihgt() < pivot) {
                i++;
            }
            while (a[j].getHeihgt() > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
               
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        inter.repintarRayas();
        if (i < higherIndex)
            quickSort(i, higherIndex);
        inter.repintarRayas();
    }
 
    private void exchangeNumbers(int i, int j) {
        Linea temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}