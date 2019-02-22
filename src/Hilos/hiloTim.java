package Hilos;

import Interfaz.InterfazOrdenamiento;
import Mundo.Linea;
import Mundo.Ordenador;

public class hiloTim extends Thread{
	
	private InterfazOrdenamiento inter;
	private Ordenador mundo;
	private Linea[] a;
	public final static long SLEEP=5;
	public  int ancho;
	public final static int RUN = 32;
	
	public hiloTim(InterfazOrdenamiento inter, Ordenador mundo) {
		Linea[] a=mundo.getLineas();
		this.inter = inter;
		this.mundo = mundo;
	}
	
	@Override
	public void run(){
		a=mundo.getLineas();
		
		timSort(a,  a.length);
		
		
		
			
	}
	void insertionSort( int left, int right)
	{
	    for (int i = left + 1; i <= right; i++)
	    {
	        int temp = a[i].getHeihgt();
	       
	        int j = i - 1;
	        while(i>0 && a[j].getHeihgt() > a[i].getHeihgt())
	        {
	            a[j+1] = a[j];
	          //actualizo
	            inter.setActual(a[j]);
				inter.repintarRayas();
	            j--;
	        }
	        temp= a[j+1].getHeihgt() ;
	    }
	}
	 
	// merge function merges the sorted runs
	public void merge(int i, int m, int j) {
		
		
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
	 
	// iterative Timsort function to sort the
	// array[0...n-1] (similar to merge sort)
	void timSort(Linea arr[], int n)
	{
	    // Sort individual subarrays of size RUN
	    for (int i = 0; i < n; i+=RUN)
	        insertionSort(i, Math.min((i+31), (n-1)));
	 
	    // start merging from size RUN (or 32). It will merge
	    // to form size 64, then 128, 256 and so on ....
	    for (int size = RUN; size < n; size = 2*size)
	    {
	        // pick starting point of left sub array. We
	        // are going to merge arr[left..left+size-1]
	        // and arr[left+size, left+2*size-1]
	        // After every merge, we increase left by 2*size
	        for (int left = 0; left < n; left += 2*size)
	        {
	            // find ending point of left sub array
	            // mid+1 is starting point of right sub array
	            int mid = left + size - 1;
	            int right = Math.min((left + 2*size - 1), (n-1));
	 
	            // merge sub array arr[left.....mid] &
	            // arr[mid+1....right]
	            merge(left, mid, right);
	          //actualizo
	    		inter.setActual(a[mid]);
	    		inter.repintarRayas();
	        }
	    }
	}

	
	
	
}
