package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import teams.ScoreBoard;

public class ScoreBoardPanel extends JPanel {
	ScoreBoard scoreBoard;
	JTable scoreBoardTable;

	public ScoreBoardPanel(ScoreBoard scoreBoard) {
		super();
		this.scoreBoard = scoreBoard;
		this.setLayout(new GridLayout());
		
		scoreBoardTable = new JTable(scoreBoard.getStatsAsString(),
				scoreBoard.getNames());
		this.add(scoreBoardTable);
	}



	public void update() {
		//TODO update()
	}

}
