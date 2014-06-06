package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.MainController;

public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton nextDayButton;
	MainController mainController;
	public MainPanel(final MainController mainController) {
		this.mainController = mainController;
		this.nextDayButton=new JButton(new AbstractAction("Next Day") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		
	}
}
