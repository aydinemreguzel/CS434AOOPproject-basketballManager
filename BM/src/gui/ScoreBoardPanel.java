package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import teams.ScoreBoard;

public class ScoreBoardPanel extends JPanel {
	ScoreBoard scoreBoard;
	JTable scoreBoardTable;
	JScrollPane scrollPane;
	private int count;

	public ScoreBoardPanel(ScoreBoard scoreBoard) {
		super();
		this.scoreBoard = scoreBoard;
		scoreBoardTable = new JTable(scoreBoard.getStatsAsString(),
				scoreBoard.getStatNames());

		// scoreBoardTable.setCellSelectionEnabled(false);
		// scoreBoardTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(scoreBoardTable);
		this.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(1000, 150));

		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	}

	public void update() {
		count++;
		scoreBoardTable.setValueAt("hasss"+count,3,3);
		for (int i = 0; i < scoreBoard.getStatsAsString().length; i++) {
			for (int j = 0; j < scoreBoard.getStatsAsString()[i].length; j++) {
				System.out.println("data:"+i+","+j+": "+scoreBoard.getStatsAsString()[i][j]);
				scoreBoardTable.setValueAt(""+scoreBoard.getStatsAsString()[i][j],i,j);
			}
		}

		scoreBoardTable.revalidate();
	}
}
