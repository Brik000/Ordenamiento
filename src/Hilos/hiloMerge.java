package Hilos;

import java.util.Arrays;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloMerge extends Thread{
	private InterfazOrdenamiento inter;
	private Ordenador mundo;
	private Linea[] a;
	public final static long SLEEP=5;
	public  int ancho;
	
	public hiloMerge(InterfazOrdenamiento inter, Ordenador mundo) {
		super();
		
		this.inter = inter;
		this.mundo = mundo;
	}
	
	@Override
	public void run() {
		a=mundo.getLineas();
		
		ancho=a[0].getWidht();
		mergeSort(0,a.length-1);
			
	}
	
	public void mergeSort(int i, int j) {
		
		
		if (i!=j) {
			try {
				Thread.currentThread().sleep(SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int  m=(i+j)/2;
			
			inter.setActual(a[m]);
			inter.repintarRayas();
			
			mergeSort(i,m);
			inter.repintarRayas();
			mergeSort(m+1,j);
			inter.repintarRayas();
			merge(i,m,j);
			inter.repintarRayas();
		}
	}
	
	public void merge(int i, int m, int j) {
		inter.setActual(a[m]);
		int tamA = m - i + 1;
        int tamB = j - (m+1)+1;
        
        Linea[] aux = new Linea[j - i + 1];

        int aux1 = i;
        int aux2 = m+1;
        for (int k = 0; k < aux.length; k++)
        {

            if (aux1 > m)
            {
                for (int k1 = aux2; k1 <=j ; k1++)
                {
                    aux[k] = new Linea(a[k1].getHeihgt(),ancho);
                    k++;
                }
            }else if (aux2 > j)
            {
                for (int k1 = aux1; k1 <= m; k1++)
                {
                    aux[k] = new Linea(a[k1].getHeihgt(),ancho);
                    k++;
                }
            }else
            {
            if (a[aux1].getHeihgt() >= a[aux2].getHeihgt())
            {
                    aux[k] = new Linea(a[aux2].getHeihgt(),ancho);;
                    aux2++;
                }else
                {
                    aux[k] = new Linea(a[aux1].getHeihgt(),ancho);;
                    aux1++;
                }

            }


        }

        for (int ind = 0; ind < aux.length; ind++)
        {
            a[i + ind] = aux[ind];
        }
		
	}
	
	
	
	

}
