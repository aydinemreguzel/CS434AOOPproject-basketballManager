package gui;

import gameengine.Time;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controllers.MainController;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StringBuilder logger;

	JLabel eventLabel;
	JLabel nextMatchTimeLabel;
	JLabel currentTimeLabel;
	JButton nextDayButton;
	JButton transferButton;
	JButton scheduleButton;
	JButton standingsButton;
	MainController mainController;

	public MainPanel(final MainController mainController, StringBuilder logger) {
		this.mainController = mainController;
		eventLabel = new JLabel("Welcome to BM 2014");
		nextMatchTimeLabel = new JLabel("");
		currentTimeLabel = new JLabel("");
		this.setLayout(new GridLayout());
		this.add(eventLabel);
		this.add(nextMatchTimeLabel);
		this.add(currentTimeLabel);
		addButtons(mainController);
		
		this.logger = logger;
	}

	private void addButtons(final MainController mainController) {
		this.nextDayButton = new JButton(new AbstractAction("Next Day") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.transferButton = new JButton(
				new AbstractAction("Transfer Market") {
					public void actionPerformed(ActionEvent e) {
						mainController.nextDay();
					}
				});
	
		this.scheduleButton = new JButton(new AbstractAction("Fixture") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.standingsButton = new JButton(new AbstractAction("Standings") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});

		this.add(nextDayButton);
		this.add(transferButton);
		this.add(scheduleButton);
		this.add(standingsButton);
	}

	public void update() {
		eventLabel.setText(logger.toString());
		logger.delete(0, logger.length() - 1);
		Time currentTime = mainController.getGame().getCurrentTime();
		Time nextMatchTime =  mainController.getGame().getLeague().getFixture()
				.getNextMatchDateAfter(currentTime);
		currentTimeLabel.setText("Now: " + currentTime.toString());
		nextMatchTimeLabel.setText("Next Match Date: " + nextMatchTime.toString());
	}
}
