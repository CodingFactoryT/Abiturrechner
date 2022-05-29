package main.java;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class OverlayPanel extends JPanel{
	static MarkSelectComboBox[] pruefungsfaecher_GK;
	static MarkSelectComboBox[] weitereKurse;
	static MarkSelectComboBox[] pruefungsfaecher_LK;
	static MarkSelectComboBox[] pruefungen_GK;
	static MarkSelectComboBox[] pruefungen_LK;
	
	public static Marks marks;
	public OverlayPanel(){
		marks = new Marks();
		this.setOpaque(false);
		this.setLayout(null);
		pruefungsfaecher_GK = initComboboxPanel(248, 143, 3, 4, 65, 64, marks.pruefungsfaecher_GK_Indexes);
		weitereKurse = initComboboxPanel(29, 439, 2, 6, 65, 46, marks.weitereKurse_Indexes);
		pruefungsfaecher_LK = initComboboxPanel(249, 645, 2, 4, 65, 67, marks.pruefungsfaecher_LK_Indexes);
		pruefungen_GK = initComboboxPanel(738, 143, 3, 1, 65, 64, marks.pruefungen_GK_Indexes);
		pruefungen_LK = initComboboxPanel(738, 645, 2, 1, 65, 67, marks.pruefungen_LK_Indexes);	

		ResultPanel.updateTotal(calculateTotalPoints(OptionalMarkPanel.optionalMark));
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

	public static int calculateTotalPoints(int optionalMark) {	
		int result = 0;
		for(int i = 0; i < pruefungsfaecher_GK.length; i++) {
			int selectedIndex = pruefungsfaecher_GK[i].getSelectedIndex();
			if(selectedIndex != 0) result += (16-selectedIndex);
			else result += optionalMark;
		}

		for(int i = 0; i < weitereKurse.length; i++) {
			int selectedIndex = weitereKurse[i].getSelectedIndex();
			if(selectedIndex != 0) result += (16-selectedIndex);
			else result += optionalMark;
		}
		
		for(int i = 0; i < pruefungsfaecher_LK.length; i++) {
			int selectedIndex = pruefungsfaecher_LK[i].getSelectedIndex();
			if(selectedIndex != 0) result += (16-selectedIndex)*2;
			else result += optionalMark*2;
		}
		
		for(int i = 0; i < pruefungen_GK.length; i++) {
			int selectedIndex = pruefungen_GK[i].getSelectedIndex();
			if(selectedIndex != 0) result += (16-selectedIndex)*4;
			else result += optionalMark*4;
		}
		
		for(int i = 0; i < pruefungen_LK.length; i++) {
			int selectedIndex = pruefungen_LK[i].getSelectedIndex();
			if(selectedIndex != 0) result += (16-selectedIndex)*4;
			else result += optionalMark*4;
		}
		return result;
	}
	
	private MarkSelectComboBox[] initComboboxPanel(int x, int y, int rows, int cols, int hgap, int vgap, int[] markAr){
		JPanel cbPanel = new JPanel();
		
		cbPanel.setLayout(new GridLayout(rows,cols,hgap,vgap));
		cbPanel.setOpaque(false);
		cbPanel.setBounds(x,y,MarkSelectComboBox.WIDTH*cols + hgap*(cols-1),MarkSelectComboBox.HEIGHT*rows + vgap*(rows-1));
		MarkSelectComboBox[] cb = new MarkSelectComboBox[rows*cols];
		
		for(int i = 0; i < cb.length; i++) {
			cb[i] = new MarkSelectComboBox<>();
			cb[i].addActionListener(SideBar.resultPanel);
			cb[i].setSelectedIndex(markAr[i]);
			cbPanel.add(cb[i]);
		}
		this.add(cbPanel);
		return cb;
	}
}
