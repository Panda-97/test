package jmybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();

		my.init();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 로그인 ===");
		sc.nextLine();
		System.out.print("아이디 : ");
		String user_id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String user_pw = sc.nextLine();

		my.login(user_id, user_pw);
		
		
		
		while (true) {
			System.out.println("===== USER =====");
			System.out.println("[1]추가 [2] 조회 [3] 삭제 [4] 수정 [5] 로그인 [6] 종료 ");

			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("==== 추가 ====");
				sc.nextLine();
				System.out.print("아이디 입력 : ");
				String user_id = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				String user_pw = sc.nextLine();
				System.out.print("이름 입력 : ");
				String name = sc.nextLine();
				System.out.print("전화번호 입력 : ");
				String phone = sc.nextLine();
				System.out.print("등급 입력 : ");
				String grade = sc.nextLine();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();

				my.insertUser(user_id, user_pw, name, phone, grade, age);

			} else if (choice == 2) {
				System.out.println("==== 조회 ====");

				ArrayList<UserDTO> list = my.getUser();

				System.out.println(list);

			} else if (choice == 3) {
				System.out.println("==== 삭제 ====");
				ArrayList<UserDTO> list = my.getUser();
				System.out.println(list);
				sc.nextLine();
				System.out.print("삭제할 아이디 입력 : ");
				String id = sc.nextLine();
				my.deleteUser(id);

			} else if (choice == 4) {
				System.out.println("==== 수정 ====");
				sc.nextLine();
				System.out.print("새로운 이름 입력 : ");
				String name = sc.nextLine();
				System.out.println("바꿀 이름의 아이디 입력 : ");
				String user_id = sc.nextLine();
				my.updateUser(name, user_id);
				ArrayList<UserDTO> list = my.getUser();
				System.out.println(list);

			} else if (choice == 5) {


				
//				  ArrayList<UserDTO> list = my.getUser(); sc.nextLine();
//				  System.out.print("아이디 : "); String user_id = sc.nextLine();
//				  System.out.print("패스워드 : "); String user_pw = sc.nextLine();
//				  
//				  boolean isLogin = false;
//				  
//				 
//				  for (int i = 0; i < list.size(); i++) { if
//				 (user_id.equals(list.get(i).getUser_id()) &&
//				  user_pw.equals(list.get(i).getUser_pw())) { System.out.println("로그인 성공");
//				  isLogin = true; } // if } // for if (!isLogin) {
//				  System.out.println("로그인 실패"); }
				 

			} else if (choice == 6) {
				System.out.println("=== 종료 ===");
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요.");
			}

		} // while 로그인 성공 후

	} // main

} // class
