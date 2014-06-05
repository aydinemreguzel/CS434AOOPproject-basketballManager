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
	   scoreBoardTable=new JTable(scoreBoard.getStatsAsString(),scoreBoard.getNames());
		
		
	}
	private static void createAndShowGUI() {
      //Create and set up the window.
      JFrame frame = new JFrame("SimpleTableDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      ScoreBoardPanel newContentPane = new ScoreBoardPanel(new ScoreBoard(null));
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      //Display the window.static
      frame.pack();
      frame.setVisible(true);
  }
	
}
