package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotones extends JPanel implements ActionListener{
	public final static String INSERTION="INSERTION";
	public final static String TIM="TIM";
	public final static String MERGE="merge";
	public final static String COUNTING="counting";
	public final static String BOGO="bogo";
	public final static String QUICK="QUICK";
	public final static String REINICIAR="NEPE";
	
	private JButton insertionSort;
	private JButton timsort;
	private JButton mergeSort;
	private JButton countingSort;
	private JButton BogoSort;
	private JButton QuickSort;
	private JButton reiniciar;
	private JTextField totalRayas;
	
	InterfazOrdenamiento inter;
	
	public PanelBotones(InterfazOrdenamiento inter) {
		
		this.inter=inter;
		
		insertionSort=new  JButton("insertion") ;
		insertionSort.addActionListener(this);
		insertionSort.setActionCommand(INSERTION);
		
		timsort=new  JButton("Tim") ;
		timsort.addActionListener(this);
		timsort.setActionCommand(TIM);
			
		QuickSort=new  JButton("Quick") ;
		QuickSort.addActionListener(this);
		QuickSort.setActionCommand(QUICK);
		
		
		
		mergeSort=new JButton("merge") ;
		mergeSort.addActionListener(this);
		mergeSort.setActionCommand(MERGE);
		
		countingSort=new JButton("counting") ;
		countingSort.addActionListener(this);
		countingSort.setActionCommand(COUNTING);
		
		BogoSort=new JButton("Bogo") ;
		BogoSort.addActionListener(this);
		BogoSort.setActionCommand(BOGO);
		
		reiniciar=new JButton("reinicia") ;
		reiniciar.addActionListener(this);
		reiniciar.setActionCommand(REINICIAR);
		
		totalRayas=new JTextField("Ingrese un numero");
		
		
		this.add(insertionSort);
		this.add(mergeSort);
		this.add(countingSort);
		this.add(BogoSort);
		this.add(QuickSort);
		this.add(timsort);
		this.add(reiniciar);
		this.add(totalRayas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(COUNTING)) {
			inter.counting();
			
		}else if(e.getActionCommand().equals(INSERTION)) {
			try {
				inter.insertion();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			
		}else if(e.getActionCommand().equals(QUICK)) {
			inter.quick();
		}else if(e.getActionCommand().equals(TIM)) {
			inter.tim();
		}
		else if(e.getActionCommand().equals(MERGE)) {
			inter.merge();
			
		}else if(e.getActionCommand().equals(BOGO)) {
			inter.bogo();
		}
		else if(e.getActionCommand().equals(REINICIAR)){
			try {
			inter.reinicia(Integer.parseInt(totalRayas.getText()));
			
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this,"ingrse solo numeros");
			}
			
		}
		
		
	}

}
