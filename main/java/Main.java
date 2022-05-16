package main.java;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		new MainFrame();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() { 	//serialize Marks after window is closed
			@Override
			public void run() {
				OverlayPanel.updateMarksInClass();
				Marks.writeToFile();
			}
		}, "Shutdown-thread"));
	}

}
