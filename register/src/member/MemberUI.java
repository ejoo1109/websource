package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Action;

public class MemberUI {

	public static void main(String[] args) {
		boolean isStop=false; //반복문을 종료할 예정
		
		Scanner sc = new Scanner(System.in); //키보드에서 입력받기 위해 사용
		MemberConsoleUtil Util = new MemberConsoleUtil();//메소드 작성해놓은거 불러다 써야하기때문에 객체생성
		List<Member> list = new ArrayList<Member>();//추가된 회원정보를 저장해야 하기 때문에 ArrayList사용
		
		do {//한번은 실행되야 하기 때문에 do while 구문 사용
			System.out.println("==== 회원관리 프로그램 ====");
			System.out.println("1. 회원등록");
			System.out.println("2. 회원목록보기");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt(); //사용자한테 번호 입력받기
		
			//메뉴 번호에 따라 출력문 제시
			switch (menu) {
			case 1://회원등록
				Member member= Util.getNewmember(sc);
				//추가된 회원정보를 저장해야 하기 때문에 ArrayList사용
				list.add(member);
				Util.printAddSuccesMessage(member);
				break;
			case 2://회원목록보기
				Util.printMemberList(list);
				break;
			case 3://회원정보수정
				member=Util.getUpdateMember(sc, list);
				if(member == null) {
					Util.printModifydFailMessage();
				}else {
					Util.printModifySuccessmessage(member);
				}				
				break;
			case 4://회원정보삭제
				member=Util.removeMember(sc, list);
				if(member == null) {
					Util.pirntRemoveFailMessage();
				}else {
					Util.printRemoveSuccessMessage();
				}
				break;
			case 5://프로그램 종료
				System.out.println("프로그램 종료");
				isStop = true;
				break;
			default:
				break;
			}
	}while(!isStop); //isStop이 true일때 종료
	}

}

	


