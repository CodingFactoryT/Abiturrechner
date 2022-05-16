package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Marks {
	static int[] pruefungsfaecher_GK_Indexes = new int[12];
	static int[] weitereKurse_Indexes = new int[12];
	static int[] pruefungsfaecher_LK_Indexes = new int[8];
	static int[] pruefungen_GK_Indexes = new int[3];
	static int[] pruefungen_LK_Indexes = new int[2];
	
	public Marks() {
		readFromFile();
	}

	private void readFromFile() {
		try {
			File file = new File("data.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			if(file.length() != 0) {	
				String str = "";
				str = br.readLine();
				pruefungsfaecher_GK_Indexes = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
				str = br.readLine();
				weitereKurse_Indexes = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
				str = br.readLine();
				pruefungsfaecher_LK_Indexes = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
				str = br.readLine();
				pruefungen_GK_Indexes = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
				str = br.readLine();
				pruefungen_LK_Indexes = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeToFile() {
		try {
			PrintWriter pw = new PrintWriter("data.txt");
			pw.println(Arrays.toString(pruefungsfaecher_GK_Indexes));
			pw.println(Arrays.toString(weitereKurse_Indexes));
			pw.println(Arrays.toString(pruefungsfaecher_LK_Indexes));
			pw.println(Arrays.toString(pruefungen_GK_Indexes));
			pw.println(Arrays.toString(pruefungen_LK_Indexes));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
