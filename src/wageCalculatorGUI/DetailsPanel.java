package wageCalculatorGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DetailsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
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
				unempTaxEmply = wageCalculator.Calculator.UnempTaxEmply(grossPay);
				fundedPensionTax = wageCalculator.Calculator.FundedPensionTax(grossPay, fundedPension);
				incomeTax = wageCalculator.Calculator.IncomeTax(grossPay, unempTaxEmply, fundedPensionTax, taxFreeMin);
				netPay = wageCalculator.Calculator.NetPay(grossPay, incomeTax, unempTaxEmply, fundedPensionTax);
				socialTax = wageCalculator.Calculator.SocialTax(grossPay);
				unempTaxEmplyr = wageCalculator.Calculator.UnempTaxEmplyr(grossPay);
				
				String gPString = String.format("%1.2f", grossPay);	
				String uTEString = String.format("%1.2f", unempTaxEmply);
				String fPTString = String.format("%1.2f", fundedPensionTax);	
				String iTString = String.format("%1.2f", incomeTax);	
				String nPString = String.format("%1.2f", netPay);
				String sTString = String.format("%1.2f", socialTax);
				String uTrString = String.format("%1.2f", unempTaxEmplyr);
				
				textArea1.setText("Bruto töötasu: " + gPString + " €\n" +
								"Töötuskindlustus: " + uTEString + " €\n" + 
								"Kogumispension: " + fPTString + " €\n" +
								"Tulumaks: " + iTString + " €\n" +
								"Neto töötasu: " + nPString + " €\n");
				
				textArea2.setText("Sotsiaalmaks: " + sTString + " €\n" +
								"Töötuskindlustus: " + uTrString + " €\n");
				
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
