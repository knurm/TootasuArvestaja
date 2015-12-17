package tootasuArvestajaGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	
	private DetailsPanel detailsPanel;
	
	public MainFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JTextArea textArea= new JTextArea();
		
		JButton nupp = new JButton("Nupp");
		
		detailsPanel = new DetailsPanel();
		
		detailsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccurred(DetailEvent event) {
				String text = event.getText();
				
				textArea.append(text);
			}
		});
		
		Container aken = getContentPane();
		
		aken.add(textArea, BorderLayout.CENTER);
		aken.add(nupp, BorderLayout.SOUTH);
		aken.add(detailsPanel, BorderLayout.WEST);
		
		nupp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("I WANT TO SLEEP!!!\n");
				
			}
			
		});
	}

}
