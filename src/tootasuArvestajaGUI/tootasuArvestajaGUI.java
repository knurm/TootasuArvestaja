package tootasuArvestajaGUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class tootasuArvestajaGUI {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame aken = new MainFrame("Töötasuarvestaja");
				
				aken.setSize(700, 500);
				aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				aken.setVisible(true);
			}

		});
		
		
	}

}
