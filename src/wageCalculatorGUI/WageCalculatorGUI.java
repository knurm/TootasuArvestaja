package wageCalculatorGUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class WageCalculatorGUI {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame window = new MainFrame("Töötasuarvestaja");
				
				window.setSize(600, 400);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
				
			}	

		});
		
		
	}

}
