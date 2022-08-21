package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BeforeCal implements Runnable{
	@FXML TextArea textArea;
	@FXML TextField textField;
	
	
	public BeforeCal(TextArea textArea, TextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}

	Stack<String> stack = new Stack<String>();
	Queue<String> queue = new LinkedList<>();
	
	@Override
	public void run() {
		String str = textArea.getText();
		str = str.trim(); //혹시 모를 앞뒤 공백 없애기
		String[] str_arr = str.split(" "); //공백을 기준으로 숫자와 연산자 분리
		
		//boolean push_go = false; // (가 push되면 )가 나오기 전까지는 계속 push해야 한다. 
		
		// 연산자 우선순위 : +,- = 1, *,/ = 2
		//stack 최신에 있는 연산자 우선순위
		int stack_first = 0; //stack에 아무 연산자도 없을 경우 or (가 push되었을 경우
		
		
		//queue에 후위 표기법으로 입력하기
		for(String ch : str_arr) {
			System.out.println("ch : " + ch);
			if(ch.equals("(")) {
				stack.push(ch); //)가 나오기 전까지는 계속 push해야 하므로
				System.out.println("stack에 " + ch + " push");
				stack_first = 0;
			}
			else if(ch.equals("×") || ch.equals("/")) {
				stack.push(ch);
				System.out.println("stack에 " + ch + " push");
				stack_first = 2;
				
			}
			else if(ch.equals("+") || ch.equals("-")) {
				if(stack_first <= 1) {
					stack.push(ch);
					System.out.println("stack에 " + ch + " push");
					stack_first = 1;
				}
				else { //현재 stack최신에 *나 /가 있다는 뜻이므로
					String pop = "";
					while(!stack.empty()) {//stack이 비어있지 않다면
						if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("(") ) {
							stack.push(ch);
							stack_first = 1;
							System.out.println("stack에 " + ch + " push");
							break;
						}
						else {
							pop = stack.pop();
							System.out.println("stack에서 " + pop + "을 pop");
							queue.add(pop);
						}
	
					}

				}
			}
			else if(ch.equals(")")){
				String pop = "";
				System.out.println("여기냐1");
				while(true) {//(가 pop되지 않는 다면 stack이 비어있을 경우가 없다. 
					pop = stack.pop();
					System.out.println("여기냐2");
					System.out.println("stack에서 " + pop + "을 pop");
					System.out.println("여기냐3");
					queue.add(pop);
					System.out.println("여기냐4");
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
				}
				
			}
			else { //ch가 숫자일때
				queue.add(ch);
				//System.out.println("queue에 "+ch +"저장");
			}
		}
		//stack에 남은 연산자 전부 queue로 보내기
		String pop = "";
		while(!stack.empty()) {//stack이 비어있지 않다면
			pop = stack.pop();
			System.out.println("stack에서 " + pop + "을 pop");
			queue.add(pop);
		}
		System.out.println("--------------------------------");
		
		for(String p : queue) {
			System.out.println(p);
		}
		
		
		System.out.println("스레드가 종료되었습니다.");
	}
	
}
