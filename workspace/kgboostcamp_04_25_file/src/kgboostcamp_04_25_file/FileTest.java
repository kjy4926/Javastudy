package kgboostcamp_04_25_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 입력된 File이 파일인 경우
	// 파일 정보 출력
	public static void printFileInfo(File f) {
		if(f.isFile()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("파일 크기 : " + f.length());
			System.out.println("마지막 수정 일자 : " + sdf.format(f.lastModified()));
			System.out.println("실행파일? : " + f.canExecute());	
			System.out.println("일반파일? : " + f.isFile());	
			System.out.println("숨김파일? : " + f.isHidden());	
			System.out.println("읽기가능? : " + f.canRead());
			System.out.println("쓰기가능? : " + f.canRead());
		}
	}
	// 입력된 File이 디렉터리인 경우
	// 해당 디렉터리의 디렉터리와 파일 분류
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
	// 입력된 디렉터리의 자식 디렉터리 정보 출력
	public static String getDirInfoString(ArrayList<File> flist) {
		StringBuilder result = new StringBuilder();
		for(File dir : flist) {
			result.append(dir.toString()+"\n");
		}
		return result.toString().trim();
	}
	// 입력된 디렉터리의 자식 파일 정보 출력
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
					System.out.println("디렉터리 수 : " + fclassification.get(0).size());
					System.out.println(getDirInfoString(fclassification.get(0)));
					System.out.println("파일 수 : " + fclassification.get(1).size());
					System.out.println(getDirFileInfoString(fclassification.get(1)));
				}
			}
			else {
				System.out.println("지정된 파일이 존재하지 않습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}