package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import Hilos.hiloBogoSort;
import Hilos.hiloCounting;
import Hilos.hiloInsercion;
import Hilos.hiloMerge;
import Hilos.hiloQuick;
import Hilos.hiloTim;
import Mundo.Linea;
import Mundo.Ordenador;

public class InterfazOrdenamiento extends JFrame{
	
	private  Ordenador mundo;
	
	private PanelBotones buttons;
	
	private PanelLineas vainoQuePinta;
	
	int lineas;
	private Linea actual;
	
	private boolean ordenando;
	
	public final static int ANCHO_TOTAL = 1000;
	public final static int ALTO_TOTAL = 160;
	

	
	public InterfazOrdenamiento()throws HeadlessException {
		lineas=20;
		this.setLayout(new BorderLayout());
		 mundo=new Ordenador(lineas);
		 this.setSize(new Dimension(ANCHO_TOTAL,ALTO_TOTAL));
		
		buttons=new PanelBotones(this);
		
		vainoQuePinta=new PanelLineas(mundo.getLineas(),this);
		
		this.add(buttons,BorderLayout.SOUTH);
		this.add(vainoQuePinta, BorderLayout.CENTER);
		this.repaint();
		vainoQuePinta.repaint();
		vainoQuePinta.revalidate();
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	
	public void repintarRayas() {
		
		vainoQuePinta.repaint();
		
		
	}
	
	public void reinicia(int i){
		this.remove(vainoQuePinta);
		
		mundo=new Ordenador(i);
		vainoQuePinta=new PanelLineas(mundo.getLineas(),this);
		this.add(vainoQuePinta, BorderLayout.CENTER);
		this.repaint();
		vainoQuePinta.repaint();
		vainoQuePinta.revalidate();
		
	}
	
	public  void quick() {
		ordenando=true;
		hiloQuick hilo=new hiloQuick(this,mundo);
		hilo.start();
		
	}
	public  void tim() {
		ordenando=true;
		hiloTim hilo=new hiloTim(this,mundo);
		hilo.start();
		
	}
	
	
	public  void bogo() {
		ordenando=true;
		hiloBogoSort hilo=new hiloBogoSort(this,mundo);
		hilo.start();
		
	}
	

	public  void merge() {
		ordenando=true;
		hiloMerge hilo=new hiloMerge(this,mundo);
		hilo.start();
		
	}
	
	public void insertion() {
		ordenando=true;
		hiloInsercion hilo=new hiloInsercion(this,mundo);
		hilo.start();
	this.setActual(null);
	this.repintarRayas();
		
		
	}
	
	public void counting() {
		ordenando=false;
		hiloCounting hilo= new hiloCounting(this,mundo);
		hilo.start();
		this.setActual(null);
		this.repintarRayas();
      
	}
	
	public void  repintarConGuia(Linea[] a) {
		this.remove(vainoQuePinta);
		
		mundo=new Ordenador(lineas);
		mundo.setLineas(a);
		vainoQuePinta=new PanelLineas(mundo.getLineas(),this);
		this.add(vainoQuePinta, BorderLayout.CENTER);
		this.repaint();
		vainoQuePinta.repaint();
		vainoQuePinta.revalidate();

		
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		InterfazOrdenamiento hi=new InterfazOrdenamiento();
		
		hi.setVisible(true);
		

	}
	
	public boolean getEstado() {
		return this.ordenando;
	}
	public void setEstado(boolean estado) {
		this.ordenando=estado;
	}
	public Linea getActual() {
		return this.actual;
	}
	public void setActual(Linea a) {
		this.actual=a;
	}

}
