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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import wageCalculator.Calculator;

public class DetailsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	Double workedHours;
	Double hourlyPay;
	Double taxFreeMin;
	Double fundedPension;
	Double grossPay;
	Double unempTaxEmply;
	Double fundedPensionTax;
	Double incomeTax;
	Double netPay;
	Double socialTax;
	Double unempTaxEmplyr;

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 400;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Arvestaja"));
		
		JLabel wHLabel = new JLabel("Töötatud tunnid: ");
		JLabel hPLabel = new JLabel("Tunnipalk: ");
		JLabel tFMLabel = new JLabel("Maksuvaba miinimum: ");
		JLabel fPLabel = new JLabel("Kogumispension: ");
		
		JTextField wHField = new JTextField(10);
		JTextField hPField = new JTextField(10);
		JTextField tFMField = new JTextField(10);
		JTextField fPField = new JTextField(10);
		JTextArea textArea1 = new JTextArea(10, 15);
		JTextArea textArea2 = new JTextArea(10, 15);
		
		JButton calculateBtn = new JButton("Arvesta");
		
		calculateBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					
				workedHours = Double.parseDouble(wHField.getText());
				hourlyPay = Double.parseDouble(hPField.getText());
				taxFreeMin = Double.parseDouble(tFMField.getText());
				fundedPension = Double.parseDouble(fPField.getText());
				
				grossPay = wageCalculator.Calculator.GrossPay(hourlyPay, workedHours);
				String gPString = grossPay.toString();	
				textArea1.setText(gPString);
				
				unempTaxEmply = wageCalculator.Calculator.UnempTaxEmply(grossPay);
				fundedPensionTax = wageCalculator.Calculator.FundedPensionTax(grossPay, fundedPension);
				incomeTax = wageCalculator.Calculator.IncomeTax(grossPay, fundedPension, fundedPension, fundedPension);
				netPay = wageCalculator.Calculator.NetPay(grossPay, unempTaxEmply, fundedPension, taxFreeMin);
				socialTax = wageCalculator.Calculator.SocialTax(grossPay);
				unempTaxEmplyr = wageCalculator.Calculator.UnempTaxEmplyr(grossPay);

				
				
				
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
		add(wHLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(hPLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(tFMLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(fPLabel, gc);
		
		// COL2
		gc.gridx = 1;
		gc.gridy = 0;
		add(wHField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(hPField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(tFMField, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(fPField, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(calculateBtn, gc);
		
		//Final row
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		gc.gridy = 5;
		add(textArea1, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(textArea2, gc);
	
	}

}
