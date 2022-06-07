package kgboostcamp_04_25_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// �Էµ� File�� ������ ���
	// ���� ���� ���
	public static void printFileInfo(File f) {
		if(f.isFile()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("���� ũ�� : " + f.length());
			System.out.println("������ ���� ���� : " + sdf.format(f.lastModified()));
			System.out.println("��������? : " + f.canExecute());	
			System.out.println("�Ϲ�����? : " + f.isFile());	
			System.out.println("��������? : " + f.isHidden());	
			System.out.println("�бⰡ��? : " + f.canRead());
			System.out.println("���Ⱑ��? : " + f.canRead());
		}
	}
	// �Էµ� File�� ���͸��� ���
	// �ش� ���͸��� ���͸��� ���� �з�
	public static ArrayList<ArrayList<File>> fileClassification(File[] flist) {
		ArrayList<ArrayList<File>> result = new ArrayList<>();
		result.add(new ArrayList<File>()); // dir -> index 0
		result.add(new ArrayList<File>()); // file -> index 1
		for(File f : flist) {
			if(f.isDirectory()) {
				result.get(0).add(f);
			}
			else {
				result.get(1).add(f);
			}
		}
		return result;
	}
	// �Էµ� ���͸��� �ڽ� ���͸� ���� ���
	public static String getDirInfoString(ArrayList<File> flist) {
		StringBuilder result = new StringBuilder();
		for(File dir : flist) {
			result.append(dir.toString()+"\n");
		}
		return result.toString().trim();
	}
	// �Էµ� ���͸��� �ڽ� ���� ���� ���
	public static String getDirFileInfoString(ArrayList<File> flist) {
		StringBuilder result = new StringBuilder();
		for(File file : flist) {
			result.append(file.toString()+"\n");
		}
		return result.toString().trim();
	}
	// Main
	public static void main(String[] args) {
		try {
			String path = br.readLine();
			File f = new File(path);
			if(f.exists()) {
				if(f.isFile()) {
					printFileInfo(f);
				}
				if(f.isDirectory()){
					File[] flist = f.listFiles();
					ArrayList<ArrayList<File>> fclassification = fileClassification(flist);
					System.out.println("���͸� �� : " + fclassification.get(0).size());
					System.out.println(getDirInfoString(fclassification.get(0)));
					System.out.println("���� �� : " + fclassification.get(1).size());
					System.out.println(getDirFileInfoString(fclassification.get(1)));
				}
			}
			else {
				System.out.println("������ ������ �������� �ʽ��ϴ�.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}