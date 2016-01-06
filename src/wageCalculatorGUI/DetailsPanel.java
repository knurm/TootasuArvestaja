package wageCalculatorGUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import wageCalculator.Calculator;
import wageCalculator.Employee;

public class DetailsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 400;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Arvestaja"));
		
		JLabel choosEmpLabel = new JLabel("Vali töötaja: ");
		JLabel wHLabel = new JLabel("Töötatud tunnid: ");
		
		String[] empList = {"Töötaja1", "Töötaja1", "Töötaja3"};
		JComboBox chooseEmpCombo = new JComboBox(empList);
		JTextField wHField = new JTextField();
		
		JButton addEmpBtn = new JButton("Lisa töötaja");
		JButton addBtn = new JButton("Add");
		
		addEmpBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new AddEmpDialog(null, isEnabled(), "Lisa töötaja");
				
			}

		});
		
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					String employee = (String)chooseEmpCombo.getSelectedItem();
					Double workedHours = Double.parseDouble(wHField.getText());
					
					//String text = Arvestaja.bruto(tunnipalk, mvm) + "\n";
					
					//fireDetailEvent(new DetailEvent(this, text));
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
		add(choosEmpLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(wHLabel, gc);
		
		// COL2
		gc.gridx = 1;
		gc.gridy = 0;
		add(chooseEmpCombo, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(wHField, gc);
		
		//Final row
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		add(addBtn, gc);
	
	}
	
	protected void call() {
		// TODO Auto-generated method stub
		
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
