package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;



import Mundo.Linea;

public class PanelLineas extends JPanel{
	
	Linea[] arreglo;
	InterfazOrdenamiento inter;
	
	public final static int ANCHO_TOTAL = 1000;
	public final static int ALTO_TOTAL = 100;
	
	
	
	public PanelLineas(Linea[] arreglo,InterfazOrdenamiento inter) {
		super();
		this.arreglo = arreglo;
		this.setPreferredSize(new Dimension(100,120));
		this.inter=inter;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		removeAll();
		if(!inter.getEstado()&&!(inter.getActual()!=null)) {
			normal(g);
		}else {
			resaltarLiena(inter.getActual(),g);
		}
		
	
	}

	private void resaltarLiena(Linea a,Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		int x=0;
		int y=ALTO_TOTAL;
		
	//	g2d.drawLine(0, 0, 100, 100);
//		g2d.fillRect(x, y, 0, 100);
//		g2d.drawRect(0,100-20, 20, 20);
		
		for (int i = 0; i < arreglo.length; i++) {
			if(arreglo[i]!=null&&arreglo[i].equals(a)) {
				g2d.setColor(Color.yellow);
				g2d.fillRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
				g2d.setColor(Color.red);
				g2d.drawRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
				 x+=arreglo[i].getWidht();
				
			}else if(arreglo[i]!=null){
			
			g2d.setColor(Color.black);
			g2d.fillRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
			g2d.setColor(Color.WHITE);
			g2d.drawRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
			 x+=arreglo[i].getWidht();
			 }
			 
		}
		
		
	}
	
	private void normal(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		int x=0;
		int y=ALTO_TOTAL;
		
	//	g2d.drawLine(0, 0, 100, 100);
//		g2d.fillRect(x, y, 0, 100);
//		g2d.drawRect(0,100-20, 20, 20);
		for (int i = 0; i < arreglo.length; i++) {
			if(arreglo[i]!=null) {
			g2d.setColor(Color.black);
			g2d.fillRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
			g2d.setColor(Color.WHITE);
			g2d.drawRect(x, y-arreglo[i].getHeihgt(), arreglo[i].getWidht(), arreglo[i].getHeihgt());
			 x+=arreglo[i].getWidht();
			}
		}
		
		
	}
	
	
	


}
