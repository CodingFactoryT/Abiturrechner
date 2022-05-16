package main.java;

import javax.swing.JPanel;

public class SideBar extends JPanel{
	public static ResultPanel resultPanel = new ResultPanel();

	public SideBar() {
		this.setLayout(null);
		this.add(resultPanel);
	}
}
