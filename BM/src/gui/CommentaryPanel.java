package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentaryPanel extends JPanel {
	String log;
	JTextArea textArea;

	public CommentaryPanel(String log) {
		this.log = log;
		textArea = new JTextArea();
		add(textArea);
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(250,100));
	}

	public void update() {
		System.out.println("log:" + log);
		add2TextBox(log);
	}

	private void add2TextBox(String log2) {
		textArea.setText(log2);
	}

}
