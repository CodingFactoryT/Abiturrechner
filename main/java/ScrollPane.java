package main.java;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

public class ScrollPane extends JPanel{
	public static ResultPanel resultPanel = new ResultPanel();
	public ScrollPane() throws ClassNotFoundException, IOException {
		this.setLayout(null);
		this.setBorder(null);
		OverlayPanel overlayPanel = new OverlayPanel();
		this.add(overlayPanel);
		this.add(new BackgroundPanel());
		this.add(resultPanel);
		overlayPanel.setBounds(0,0,BackgroundPanel.imageWidth, BackgroundPanel.imageHeight);
		this.setBounds(0,0,BackgroundPanel.imageWidth + MainFrame.ADDITIONAL_WIDTH, BackgroundPanel.imageHeight);
	}
}
