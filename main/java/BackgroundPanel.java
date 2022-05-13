package main.java;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundPanel extends JLabel{
	public static ImageIcon backgroundTable = null;
	public static int imageWidth = 0;
	public static int imageHeight = 0;
	
	public BackgroundPanel() {		
		InputStream background_table = new BufferedInputStream(getClass().getResourceAsStream("/main/resources/Background_Table.png"));
		try {
			backgroundTable = new ImageIcon(ImageIO.read(background_table));
			imageWidth = backgroundTable.getIconWidth();	//=830
			imageHeight = backgroundTable.getIconHeight();
			this.setIcon(backgroundTable);
			this.setBounds(0,0,imageWidth,imageHeight);
			System.out.println(imageHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
