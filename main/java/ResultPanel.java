package main.java;

import java.awt.Color;
import java.math.RoundingMode;
import java.nio.channels.CancelledKeyException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ResultPanel extends JPanel implements ActionListener{
	
	private JTextArea totalPointsText = new JTextArea();
	private JTextArea totalPointsValue = new JTextArea();
	private JTextArea totalAverageText = new JTextArea();
	private JTextArea totalAverageValue = new JTextArea();

	public ResultPanel() {
		this.setBounds(0, 0, 200, 200);
		this.setBackground(new Color(136, 211, 103));
		updateTotal(661);
	}
	
	private void updateTotal(int totalPoints) {
		totalPointsValue.setText(String.valueOf(totalPoints));
		totalAverageValue.setText(calculateTotalAverage(totalPoints));
		
		System.out.println(totalPointsValue.getText() + " , " + totalAverageValue.getText());
	}
	
	private String calculateTotalAverage(int totalPoints) {
		double result = 17.0/3.0 - totalPoints/180.0;
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(result);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}	
	
}
