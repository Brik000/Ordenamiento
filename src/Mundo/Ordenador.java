package Mundo;

public class Ordenador {
	
	public Linea[] lineas;
	private int anchoLienas;
	
	

	public Ordenador(int x) {
		super();
		
		lineas=new Linea[x]; 
		
		anchoLienas= 1000/x;
		
		for (int i = 0; i < lineas.length; i++) {
			lineas[i]=new Linea(anchoLienas);
		}
		
	}
	


	public Linea[] getLineas() {
		return lineas;
	}
	
	public int getAncho(){
		return this.anchoLienas;
	}
	                      


	public void setLineas(Linea[] lineas) {
		this.lineas = lineas;
	}




}
