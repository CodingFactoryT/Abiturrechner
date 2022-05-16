package main.java;

import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class ScrollPane extends JPanel{

	public ScrollPane() throws ClassNotFoundException, IOException {
		this.setLayout(new BorderLayout());
		this.setBorder(null);
		OverlayPanel overlayPanel = new OverlayPanel();

		this.add(overlayPanel, BorderLayout.WEST);
		this.add(new BackgroundPanel(), BorderLayout.WEST);
		this.add(new SideBar(), BorderLayout.CENTER);
		overlayPanel.setBounds(0,0,BackgroundPanel.imageWidth, BackgroundPanel.imageHeight);
		this.setBounds(0,0,BackgroundPanel.imageWidth + MainFrame.ADDITIONAL_WIDTH, BackgroundPanel.imageHeight);
	}
}
