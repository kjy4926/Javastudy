package kgboostcamp_04_26_fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		// try ~ catch with resources
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\kim\\Desktop\\Javastudy\\test.txt");
			FileInputStream	fis = new FileInputStream("C:\\Users\\kim\\Desktop\\Javastudy\\test.txt");
			FileOutputStream cfos = new FileOutputStream("C:\\Users\\kim\\Desktop\\Javastudy\\copy.txt");) {
			// 파일 생성
			String[] data = {"Hello, World!",
							"C", "C++", "C#", "Java",
							"Goodbye, World!"};
			for(String d : data) {
				fos.write((d+"\r\n").getBytes());
			}
			// 파일 복사
			int i;
			int count = 0;
			while((i = fis.read()) != -1) {
				cfos.write(i);
				System.out.print('!');
				count++;
			}
			System.out.printf("\n%d byte 복사 성공", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}