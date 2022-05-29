package main.java;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class OptionalMarkPanel extends JPanel  implements ActionListener{
	
	public static int optionalMark = 11;
	private Font standartFont = new Font("Arial", Font.PLAIN, 25);
	MarkSelectComboBox optionalMarkComboBox = new MarkSelectComboBox();
	
	public OptionalMarkPanel() {
		this.setLayout(new FlowLayout());
		Color backgroundColor = new Color(0xFFA65E);	//orange
		Color fontColor = Color.white;
		int space = 7;
		int width = MainFrame.ADDITIONAL_WIDTH - 2*space;
		int height = 40;
		this.setBounds(space, BackgroundPanel.imageHeight - (ResultPanel.height + height + space), width, height);
		this.setBackground(backgroundColor);

		JTextArea displayedText = new JTextArea("Ersatznote: ");
		displayedText.setFont(standartFont);
		displayedText.setForeground(fontColor);
		displayedText.setBackground(backgroundColor);
		displayedText.setEditable(false);
		this.add(displayedText);
		
		optionalMarkComboBox.removeItemAt(0);
		optionalMarkComboBox.setBackground(backgroundColor);
		optionalMarkComboBox.addActionListener(this);
		optionalMarkComboBox.setSelectedIndex(15-optionalMark);	//15-optionalMark converts the actual mark to the index
		optionalMarkComboBox.setForeground(fontColor);
		this.add(optionalMarkComboBox);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		optionalMark = 15 - optionalMarkComboBox.getSelectedIndex();
		ResultPanel.updateTotal(OverlayPanel.calculateTotalPoints(optionalMark));
	}	
	
}
