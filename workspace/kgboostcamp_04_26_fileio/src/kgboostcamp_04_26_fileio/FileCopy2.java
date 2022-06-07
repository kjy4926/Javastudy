package kgboostcamp_04_26_fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileCopy2 {
	public static void fileRead(String path) {
		try(BufferedReader br = new BufferedReader(new FileReader(path));) {
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String path = "C:\\Users\\kim\\Desktop\\Javastudy\\input.txt";
		try(FileWriter fw = new FileWriter(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(fw);) {
			boolean flag = false;
			while(true) {
				String input = br.readLine();
				if(flag == true && input.length()==0) {
					break;
				}
				else if(input.length()==0) {
					flag = true;
					bw.write("\r\n");
				}
				else {
					flag = false;
					bw.write(input+"\r\n");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileRead(path);
	}
}