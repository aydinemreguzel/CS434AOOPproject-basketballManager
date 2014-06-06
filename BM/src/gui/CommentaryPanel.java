package gui;

import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentaryPanel extends JPanel {
	StringBuilder logger;
	JTextArea textArea;
	JScrollPane scrollPane;

	public CommentaryPanel(StringBuilder logger) {
		this.logger = logger;

		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(400, 300));

		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		textArea.setLineWrap(true);
		textArea.setEditable(false);

	}

	public void update() {
		System.out.println("log:" + logger);
		add2TextBox(logger.toString());

	}

	private void add2TextBox(String log2) {
		textArea.append(log2);

	}

}
