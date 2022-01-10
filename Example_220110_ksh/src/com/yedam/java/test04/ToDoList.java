package com.yedam.java.test04;

public class ToDoList {
	//필드
	private static int SERIALNUMBER = 0;
	private int ToDoNum;
	private String ToDo;
	private boolean isDone = false;
	
	//생성자
	ToDoList(String ToDo){
		this.ToDo = ToDo;
		SERIALNUMBER++;
		ToDoNum += SERIALNUMBER;
	}


	
	//메소드
	public int getToDoNum() {
		return ToDoNum;
	}
	public void setToDoNum(int toDoNum) {
		ToDoNum = toDoNum;
	}
	public String getToDo() {
		return ToDo;
	}
	public void setToDo(String toDo) {
		ToDo = toDo;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = !isDone;
	}
	
	

}
