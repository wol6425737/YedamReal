package com.yedam.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		
		messageQueue.offer(new Message("sendMail", "홍길동")); //stack의 push랑 같은 기능
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "홍두께"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일을 보냈습니다.");
				break;
			case "sendSMS":
				System.out.println(message.to + "님에게 SMS를 보냈습니다.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "님에게 카카오톡을 보냈습니다.");
				break;
			}
			//들어온 순서랑 나온 순서랑 같음 Queue(Fifo)
		}
	}

}
