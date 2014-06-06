package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentaryPanel extends JPanel {
	String log;
	JTextArea textArea;

	public CommentaryPanel(String log) {
		this.log = log;
	}

	public void update() {
		add2TextBox(log);
	}

	private void add2TextBox(String log2) {
		textArea.setText(log2);
	}

	void createPanel() {
		panel1 = new JPanel();
		textArea = new JTextArea("", 10, 10);
		box.add(new JScrollPane(textArea));
		textArea.setEditable(false);
	}
}
