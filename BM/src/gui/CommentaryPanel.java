package gui;

import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentaryPanel extends JPanel {
	StringBuilder logger;
	JTextArea textArea;
	JScrollPane scrollPane = new JScrollPane();

	public CommentaryPanel(StringBuilder logger) {
		this.logger = logger;

		textArea = new JTextArea();
		scrollPane=new JScrollPane(textArea);
		this.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(400, 250));
		

		textArea.setLineWrap(true);
		textArea.setEditable(false);


		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	}

	public void update() {
		add2TextBox(logger.toString());
	}

	private void add2TextBox(String log2) {
		textArea.append(log2);
	}

}
