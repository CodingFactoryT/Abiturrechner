package main.java;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.JPanel;

import java.awt.GridLayout;

public class OverlayPanel extends JPanel{
	static MarkSelectComboBox[] pruefungsfaecher_GK;
	static MarkSelectComboBox[] weitereKurse;
	static MarkSelectComboBox[] pruefungsfaecher_LK;
	static MarkSelectComboBox[] pruefungen_GK;
	static MarkSelectComboBox[] pruefungen_LK;
	
	public static Marks marks;
	public OverlayPanel() throws ClassNotFoundException, IOException {
		marks = new Marks();
		this.setOpaque(false);
		this.setLayout(null);

		pruefungsfaecher_GK = initComboboxPanel(248, 143, 3, 4, 65, 64);
		weitereKurse = initComboboxPanel(29, 439, 2, 6, 65, 46);
		pruefungsfaecher_LK = initComboboxPanel(249, 645, 2, 4, 65, 67);
		pruefungen_GK = initComboboxPanel(738, 143, 3, 1, 65, 64);
		pruefungen_LK = initComboboxPanel(738, 645, 2, 1, 65, 67);	
		synchronizeGUIWithSavedMarks();
		
	}
	
	private void synchronizeGUIWithSavedMarks() {
		for(int i = 0; i < pruefungsfaecher_GK.length; i++) {
			pruefungsfaecher_GK[i].setSelectedIndex(marks.pruefungsfaecher_GK_Indexes[i]);
		}
		
		for(int i = 0; i < weitereKurse.length; i++) {
			weitereKurse[i].setSelectedIndex(marks.weitereKurse_Indexes[i]);
		}
		
		for(int i = 0; i < pruefungsfaecher_LK.length; i++) {
			pruefungsfaecher_LK[i].setSelectedIndex(marks.pruefungsfaecher_LK_Indexes[i]);
		}
		
		for(int i = 0; i < pruefungen_GK.length; i++) {
			pruefungen_GK[i].setSelectedIndex(marks.pruefungen_GK_Indexes[i]);
		}
		
		for(int i = 0; i < pruefungen_LK.length; i++) {
			pruefungen_LK[i].setSelectedIndex(marks.pruefungen_LK_Indexes[i]);
		}
		
	}
	
	public static void updateMarksInClass() {
		for(int i = 0; i < pruefungsfaecher_GK.length; i++) {
			marks.pruefungsfaecher_GK_Indexes[i] = pruefungsfaecher_GK[i].getSelectedIndex();
		}

		for(int i = 0; i < weitereKurse.length; i++) {
			marks.weitereKurse_Indexes[i] = weitereKurse[i].getSelectedIndex();
		}
		
		for(int i = 0; i < pruefungsfaecher_LK.length; i++) {
			marks.pruefungsfaecher_LK_Indexes[i] = pruefungsfaecher_LK[i].getSelectedIndex();
		}
		
		for(int i = 0; i < pruefungen_GK.length; i++) {
			marks.pruefungen_GK_Indexes[i] = pruefungen_GK[i].getSelectedIndex();
		}
		
		for(int i = 0; i < pruefungen_LK.length; i++) {
			marks.pruefungen_LK_Indexes[i] = pruefungen_LK[i].getSelectedIndex();
		}
	}

	private MarkSelectComboBox[] initComboboxPanel(int x, int y, int rows, int cols, int hgap, int vgap){
		JPanel cbPanel = new JPanel();
		
		cbPanel.setLayout(new GridLayout(rows,cols,hgap,vgap));
		cbPanel.setOpaque(false);
		cbPanel.setBounds(x,y,MarkSelectComboBox.WIDTH*cols + hgap*(cols-1),MarkSelectComboBox.HEIGHT*rows + vgap*(rows-1));
		MarkSelectComboBox[] cb = new MarkSelectComboBox[rows*cols];
		
		for(int i = 0; i < cb.length; i++) {
			cb[i] = new MarkSelectComboBox<>();
			cb[i].addActionListener(ScrollPane.resultPanel);
			cbPanel.add(cb[i]);
		}
		this.add(cbPanel);
		return cb;
	}
}
