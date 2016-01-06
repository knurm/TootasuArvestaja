package tootasuArvestajaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class AddEmpDialog extends JDialog implements ActionListener {
	
    private JPanel myPanel = null;
    private JButton saveBtn = null;
    private JButton cancelBtn = null;
    private boolean answer = false;
    public boolean getAnswer() { return answer; }

    public AddEmpDialog(Object frame, boolean modal, String myMessage) {
    	super();
        myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension (500,300));
        
        JLabel fNLabel = new JLabel();
        JLabel sNLabel = new JLabel();
        JLabel pCLabel = new JLabel();
        JLabel hPLabel = new JLabel();
        
        JTextField fNField = new JTextField(20);
        JTextField sNField = new JTextField(20);
        JTextField pCField = new JTextField(20);
        JTextField hPField = new JTextField(20);

        getContentPane().add(myPanel);
        //myPanel.add(new JLabel(myMessage));
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
        //setLocationRelativeTo((Component) frame);
        setVisible(true);
        
        setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// COL1
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(fNLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(sNLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(pCLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(hPLabel, gc);
		
		// COL2
		gc.gridx = 1;
		gc.gridy = 0;
		add(fNField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(sNField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(pCField, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(hPField, gc);
		
		//Final row
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 0;
		gc.gridy = 6;
		add(saveBtn, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(cancelBtn, gc);
        
	}

	public void actionPerformed(ActionEvent e) {
        if(saveBtn == e.getSource()) {
            System.err.println("User chose yes.");
            answer = true;
            setVisible(false);
        }
        else if(cancelBtn == e.getSource()) {
            System.err.println("User chose no.");
            answer = false;
            setVisible(false);
        }
        
    }
    
}


