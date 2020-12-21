package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {
	public Member getNewmember(Scanner sc) {
		System.out.println("등록할 회원 정보를 입력하세요");
		Member member = new Member();
		System.out.println("아이디를 입력하세요");
		member.setId((sc.nextInt()));
		System.out.println("이름을 입력하세요");
		member.setName((sc.next()));
		System.out.println("주소를 입력하세요");
		member.setAddr((sc.next()));
		System.out.println("이메일을 입력하세요");
		member.setEmail((sc.next()));
		System.out.println("국가를 입력하세요");
		member.setNation((sc.next()));
		System.out.println("나이를 입력하세요");
		member.setAge((sc.nextInt()));
		//int age= sc.nextInt();
		return member;
	}//return new Member(id,name,addr,nation,email,age);
	
	public void printAddSuccesMessage(Member member) {
		 System.out.println(member.getName()+"회원 정보 추가 성공");
	}
	
	public void printMemberList(List<Member> list) {
		System.out.println("회원아이디\t  이름\t주소\t이메일\t\t\t국가\t나이");
	
		for(Member member:list) {
			System.out.printf("%5d",member.getId());
			System.out.printf("%7s",member.getName());
			System.out.printf("%8s",member.getAddr());
			System.out.printf("%18s",member.getEmail());
			System.out.printf("%6s",member.getNation());
			System.out.printf("%8d",member.getAge());
			System.out.println();
		}
	}
	
	public Member getUpdateMember(Scanner sc, List<Member> list) {
		System.out.println("수정할 회원의 아이디를 입력하세요 ");
		int id = sc.nextInt();

		//리스트에 아이디가 있다면 수정하기
		Member member = null;
		for(int i=0;i<list.size();i++) { //list 사이즈만큼 반복
			member = list.get(i); //list에서 i번째 해당하는것 가져오기
			if(member.getId() == id) { //id = 사용자가 입력한 아이디 getid=list에 있는 아이디
				System.out.print("수정할 주소를 입력하세요 ");
				String addr = sc.next();
				System.out.print("수정할 이메일을 입력하세요");
				String email = sc.next();
				
				//입력받은 값 객체에 변경한 후 리턴
				member.setAddr(addr);
				member.setEmail(email);
				return member;
			}
		}
		return null;		
	}
	public void printModifySuccessmessage(Member member) {
		System.out.println(member.getName()+"회원 정보 수정 성공");
	}
	public void printModifydFailMessage() {
		System.out.println("회원 정보 수정 실패");
	}
	
	
	public Member removeMember(Scanner sc,List<Member> list) {
		System.out.println("삭제할 회원의 아이디를 입력하세요");
		int id = sc.nextInt();
		
		Member member = null;
		for(int i=0;i<list.size();i++) { //list 사이즈만큼 반복
			member = list.get(i); //list에서 i번째 해당하는것 가져오기
			if(member.getId() == id) {
				System.out.print("정말로 삭제하시겠습니까? 예(1) 아니오(2) ");
				int no = sc.nextInt();	
				if(no==1) {
					list.remove(i);
					return member;
			}
		}	
	} return null;
	}
	public void pirntRemoveFailMessage() {
		System.out.println("회원 정보 삭제에 실패하였습니다.");
	}
	public void printRemoveSuccessMessage() {
		System.out.println("회원 정보 삭제에 성공하였습니다.");
	}


}

