package wageCalculatorGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class AddEmpDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel = null;
    private JButton saveBtn = null;
    private JButton cancelBtn = null;
//    private boolean answer = false;
//    public boolean getAnswer() { return answer; }
    
    public JTextField fNField = null;
    public JTextField sNField = null;
    public JTextField pCField = null;
    public JComboBox tFMCombo = null;
    public JComboBox fPCombo = null;
    public JTextField hPField = null;

    public AddEmpDialog(Object frame, boolean modal, String title) {
    	super();
        myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension (500,300));
        
        getContentPane().add(myPanel);
        
        JLabel fNLabel = new JLabel("Eesnimi");
        JLabel sNLabel = new JLabel("Perekonnanimi");
        JLabel pCLabel = new JLabel("Isikukood");
        JLabel tFMLabel = new JLabel("Maksuvaba miinimum");
        JLabel fPLabel = new JLabel("Kogumispension");
        JLabel hPLabel = new JLabel("Tunnipalk");
        
        String[] tFMOptions = {"", "Jah", "Ei"};
        String[] fPOptions = {"", "-", "2%", "3%"};
        
        JTextField fNField = new JTextField(15);
        JTextField sNField = new JTextField(15);
        JTextField pCField = new JTextField(15);
        JComboBox tFMCombo = new JComboBox(tFMOptions);
        tFMCombo.setSelectedItem(0);
        JComboBox fPCombo = new JComboBox(fPOptions);
        fPCombo.setSelectedItem(0);
        JTextField hPField = new JTextField(15);
        
        myPanel.add(fNLabel);
        myPanel.add(sNLabel);
        myPanel.add(pCLabel);
        myPanel.add(hPLabel);
        
        myPanel.add(fNField);
        myPanel.add(sNField);
        myPanel.add(pCField);
        myPanel.add(hPField);
        
        saveBtn = new JButton("Salvest");
        saveBtn.addActionListener(this);
        myPanel.add(saveBtn); 
        cancelBtn = new JButton("Katkesta");
        cancelBtn.addActionListener(this);
        myPanel.add(cancelBtn);  
        pack();
        
        setLocationRelativeTo((Component) frame);
        setVisible(true);
        
        myPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// COL1
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		myPanel.add(fNLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		myPanel.add(sNLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		myPanel.add(pCLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		myPanel.add(tFMLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		myPanel.add(fPLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		myPanel.add(hPLabel, gc);
		
		// COL2
		gc.gridx = 1;
		gc.gridy = 0;
		myPanel.add(fNField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		myPanel.add(sNField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		myPanel.add(pCField, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		myPanel.add(tFMCombo, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		myPanel.add(fPCombo, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		myPanel.add(hPField, gc);
		
		//Final row
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 0;
		gc.gridy = 6;
		myPanel.add(saveBtn, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		myPanel.add(cancelBtn, gc);
        
}

	public void actionPerformed(ActionEvent e) {
//        if(saveBtn == e.getSource()) {
//            
//            answer = true;
//            setVisible(false);
//        }
//        else if(cancelBtn == e.getSource()) {
//            
//            answer = false;
//            setVisible(false);
//        }
		
		String firstName = fNField.getText();
		String surName = sNField.getText();
		String personalCode = pCField.getText();
		Double taxFreeMin = (Double)tFMCombo.getSelectedItem();
		Double fundedPension = (Double)fPCombo.getSelectedItem();
		Double hourlyPay = Double.parseDouble(hPField.getText());
        
    }
    
}


