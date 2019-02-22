package Mundo;

import java.util.concurrent.ThreadLocalRandom;

public class Linea {
	
	private int widht;
	
	private int heihgt;
	
	
	public Linea(int widht) {
		int rand = ThreadLocalRandom.current().nextInt(2,100);
		
		this.heihgt = rand;
		this.widht=widht;
	}
	
	
	public Linea(int  height, int width) {
		this.heihgt=height;
		this.widht=width;
	}

	public int getWidht() {
		return widht;
	}

	public void setWidht(int widht) {
		this.widht = widht;
	}

	public int getHeihgt() {
		return heihgt;
	}

	public void setHeihgt(int heihgt) {
		this.heihgt = heihgt;
	}
	
	

}
