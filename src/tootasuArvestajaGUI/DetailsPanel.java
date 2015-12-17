package tootasuArvestajaGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import tootasuArvestaja.Tootaja;

public class DetailsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 400;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Arvestaja"));
		
		JLabel nameLabel = new JLabel("Eesnimi: ");
		JLabel pknimiLabel = new JLabel("Perekonnanimi: ");
		JLabel tunnipalkLabel = new JLabel("Tunnipalk: ");
		JLabel mvmLabel = new JLabel("Maksuvaba miinimumi arvestamine: ");
		JLabel kPLabel = new JLabel("Kogumispension: ");
		
		JTextField nameField = new JTextField(10);
		JTextField pknimiField = new JTextField(10);
		JTextField tunnipalkField = new JTextField(10);
		JTextField mvmField = new JTextField(10);
		JTextField kPField = new JTextField(10);
		
		
		JButton addBtn = new JButton("Add");
		
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					String eesnimi = nameField.getText();
					String perenimi = pknimiField.getText();
					Double tunnipalk = Double.parseDouble(tunnipalkField.getText());
					Double mvm = Double.parseDouble(mvmField.getText());
					Double kogumisP = Double.parseDouble(kPField.getText());
					
					Tootaja tootaja1 = new Tootaja(eesnimi, perenimi, tunnipalk, mvm, kogumisP);
					
					String text = tootaja1 + "\n";
					
					fireDetailEvent(new DetailEvent(this, text));
			}
			
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// COL1
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(pknimiLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(tunnipalkLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(mvmLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(kPLabel, gc);
		
		// COL2
		gc.gridx = 1;
		gc.gridy = 0;
		add(nameField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(pknimiField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(tunnipalkField, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(mvmField, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(kPField, gc);
		
		//Final row
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 5;
		add(addBtn, gc);
	
	}
	
	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for (int i = 0; i < listeners.length; i += 2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener)listeners[i + 1]).detailEventOccurred(event);
			}
		}
	}
	
	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}
	
	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);	
	}

}
