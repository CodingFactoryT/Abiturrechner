package main.java;

import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ScrollPane extends JPanel{
	static BackgroundPanel backgroundPanel = new BackgroundPanel();	//static beacause static classes are initialized first and SideBar needs a variable from BackgroundPanel
	static OverlayPanel overlayPanel = new OverlayPanel();;	//OverlayPanel has to be loaded before ResiltPanel
	
	public ScrollPane() throws ClassNotFoundException, IOException {
		this.setLayout(new BorderLayout());
		this.setBorder(null);

		this.add(overlayPanel, BorderLayout.WEST);
		this.add(backgroundPanel, BorderLayout.WEST);
		this.add(new SideBar(), BorderLayout.CENTER);
		overlayPanel.setBounds(0,0,BackgroundPanel.imageWidth, BackgroundPanel.imageHeight);
		this.setBounds(0,0,BackgroundPanel.imageWidth + MainFrame.ADDITIONAL_WIDTH, BackgroundPanel.imageHeight);
	}
}
