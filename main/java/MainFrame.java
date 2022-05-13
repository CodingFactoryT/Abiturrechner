package main.java;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class MainFrame extends JFrame {
	public static final int ADDITIONAL_WIDTH = 250;
	public static Dimension contentPaneSize;
	public static int contentPaneWidth;
	public static int contentPaneHeight;
	public MainFrame() throws ClassNotFoundException, IOException {
		this.setTitle("Abiturrechner");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane(new ScrollPane() , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30); //Scroll sensitivity
        scrollPane.setViewportBorder(null);
		this.add(scrollPane);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		contentPaneWidth = (int) (screenSize.getWidth() - screenSize.getWidth()/4);
		contentPaneHeight = (int) (screenSize.getHeight() - screenSize.getHeight()/4);
		int maxContentPaneWidth = BackgroundPanel.imageWidth + ADDITIONAL_WIDTH;
		int maxContentPaneHeight = BackgroundPanel.imageHeight;
		
		if(contentPaneWidth > maxContentPaneWidth) contentPaneWidth = maxContentPaneWidth;
		if(contentPaneHeight > maxContentPaneHeight) contentPaneHeight = maxContentPaneHeight;
		
		this.getContentPane().setPreferredSize(new Dimension(contentPaneWidth, contentPaneHeight));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
