package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		boolean isStop=false;
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<Student>();
		
		do {
		System.out.println("-----<학생 정보 관리 프로그램>-----");
		System.out.println("1.학생정보 입력");
		System.out.println("2.학생정보 전체 조회");
		System.out.println("3.학생정보 개별 조회");
		System.out.println("4.프로그램 종료");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.println("----새로운 학생 정보 입력----");
			System.out.print("학  번 : ");
			int no = sc.nextInt();			
			System.out.print("이  름 :  ");
			String name = sc.next();
			System.out.print("학  년 : ");
			int grade = sc.nextInt();
			System.out.print("주  소 :  ");
			String addr = sc.next();
			System.out.print("생  일(예시: 05/11) :  ");
			String birthday = sc.next();
			
			Student std = new Student(no, name, grade, addr, birthday);
			list.add(std);
			System.out.println(std.getName() + "학생 정보가 입력되었습니다.");
			break;
		case 2:
			System.out.println("---- 학생 정보 보기 ----");
			System.out.println("학 번 \t 이 름 \t 학 년 \t");
			
			for(Student Student:list) {
				System.out.printf("%5d",Student.getNo());
				System.out.printf("%7s",Student.getName());
				System.out.printf("%8s",Student.getGrade());
				System.out.println();
			}
			break;
		case 3:
			System.out.println("---- 검색하고자 하는 학생의 학번을 입력하세요----");
			int no1 = sc.nextInt();
			
			Student std1 = null; 
			for(int i=0;i<list.size();i++) { //list 사이즈만큼 반복
				std1 = list.get(i); //list에서 i번째 해당하는것 가져오기
				if(std1.getNo() == no1) { 
					System.out.println("---- 학생 개별 정보 보기 ----");
					System.out.println("이 름 : "+std1.getName());
					System.out.println("학 년 : "+std1.getGrade());
					System.out.println("주 소 : "+std1.getAddr());
					System.out.println("생 일 : "+std1.getBirthday());
				}
			}
			break;
		case 4:
			System.out.println("프로그램 종료");
			isStop = true;
			break;
		default:
			break;
		}

	}while(!isStop);

}
}
