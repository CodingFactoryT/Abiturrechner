package main.java;

import java.awt.Color;
import java.awt.Font;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;

public class ResultPanel extends JPanel implements ActionListener{
	
	private static JTextArea resultText = new JTextArea();
	public static int optionalMark = 11;
	private Font standartFont = new Font("Arial", Font.PLAIN, 50);
	public ResultPanel() {
		this.setLayout(new GridBagLayout());
		Color backgroundColor = new Color(136, 211, 103);
		Color fontColor = Color.white;
		int space = 7;
		int width = MainFrame.ADDITIONAL_WIDTH - 2*space;
		int height = 200;
		this.setBounds(7, BackgroundPanel.imageHeight-height, width, height);
		this.setBackground(backgroundColor);

		
		resultText.setFont(standartFont);
		resultText.setForeground(fontColor);
		resultText.setBackground(backgroundColor);
		resultText.setEditable(false);
		this.add(resultText);
	}
	
	public static void updateTotal(int totalPoints) {
		resultText.setText("\u2211 = " + String.valueOf(totalPoints) + "\n\n\u00D8 = " + calculateTotalAverage(totalPoints));
	}
	
	private static String calculateTotalAverage(int totalPoints) {
		double result = 17.0/3.0 - totalPoints/180.0;
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(result);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(OverlayPanel.pruefungen_LK != null) {	//if all arrays have been initialized
			int points = OverlayPanel.calculateTotalPoints(optionalMark);
			updateTotal(points);
		}
	}	
	
}
