package gui;

import gameengine.Time;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.MainController;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StringBuilder logger;

	JLabel label;
	JLabel label2;
	JLabel label3;
	JButton nextDayButton;
	JButton transferButton;
	JButton trainingButton;
	JButton SchuladeButton;
	JButton StandingsButton;
	JButton FirendlyMatchButton;
	MainController mainController;

	public MainPanel(final MainController mainController, StringBuilder logger) {
		this.mainController = mainController;
		label = new JLabel("Welcome to BM 2014");
		label2 = new JLabel("");
		label3 = new JLabel("");
		this.add(label);
		this.add(label2);
		this.add(label3);
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
		this.trainingButton = new JButton(new AbstractAction(
				"Set Training Program") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.SchuladeButton = new JButton(new AbstractAction("Fixture") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.StandingsButton = new JButton(new AbstractAction("Standings") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.FirendlyMatchButton = new JButton(new AbstractAction(
				"Arrange Friendly Match") {
			public void actionPerformed(ActionEvent e) {
				mainController.nextDay();
			}
		});
		this.add(nextDayButton);
		this.add(transferButton);
		this.add(trainingButton);
		this.add(SchuladeButton);
		this.add(StandingsButton);
		this.add(FirendlyMatchButton);
	}

	public void update() {
		label.setText(logger.toString());
		logger.delete(0, logger.length() - 1);
		Time currentTime = mainController.getGame().getCurrentTime();
		Time nextMatchTime =  mainController.getGame().getLeague().getFixture()
				.getNextMatchDateAfter(currentTime);
		label3.setText("Now: " + currentTime.toString());
		label2.setText("Next Match Date: " + nextMatchTime.toString());
	}
}
