package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int num;
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		List<ToDoList> list = new ArrayList<ToDoList>();
		String todo = null;
		while(run) {
			System.out.println("=== 1.할일입력 | 2.전체조회 | 3.할일조회 | 4.할일완료 | 5.종료 ===");
			System.out.print("선택>");
			num = Integer.parseInt(scanner.nextLine());

			
			switch(num) {
			
			case 1:
				System.out.print("할 일> ");
				todo = scanner.nextLine();
				ToDoList todolist = new ToDoList(todo);
				list.add(todolist);
				break;
			
			case 2:
				for(int i=0; i<list.size();i++) {
					String getIsDone = (list.get(i).isDone())?"완료":"미완료";
					System.out.println(list.get(i).getToDoNum() + "번 " + list.get(i).getToDo() +" "+ getIsDone);
				}
				break;
			
			case 3:
				for(int i=0; i<list.size();i++) {
					String getIsDone = (list.get(i).isDone())?"완료":"미완료";
					if(getIsDone.equals("완료")) {
						continue;
					}
					System.out.println(list.get(i).getToDoNum() + "번 " + list.get(i).getToDo() +" "+ getIsDone);
				}
				break;
			
			case 4:
				System.out.print("완료할 할 일을 선택해주세요>");
				int number = Integer.parseInt(scanner.nextLine());
				if(list.get(number-1).isDone()==false) {
					list.get(number-1).setDone(list.get(number-1).isDone());
					System.out.println("해당 할 일을 완료처리하였습니다.");
				}
				else if(list.get(number-1).isDone()==true) {
					System.out.println("해당 할 일은 이미 완료되었습니다.");
				}

				
				break;
			
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
				
			}
			
		}
	}

}
