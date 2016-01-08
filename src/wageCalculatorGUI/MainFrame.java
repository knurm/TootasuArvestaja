package wageCalculatorGUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private DetailsPanel detailsPanel;

	public MainFrame(String title) {

		super(title);

		setLayout(new BorderLayout());

		JTextArea textArea= new JTextArea();

		detailsPanel = new DetailsPanel();

		Container window = getContentPane();

		window.add(textArea, BorderLayout.CENTER);
		window.add(detailsPanel, BorderLayout.CENTER);

	}

}
