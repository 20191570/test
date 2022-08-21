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
			//System.out.println("ch : " + ch);
			if(ch.equals("(")) {
				stack.push(ch); //)가 나오기 전까지는 계속 push해야 하므로
				//System.out.println("stack에 " + ch + " push");
				stack_first = 0;
			}
			else if(ch.equals("×") || ch.equals("/")) {
				if(stack_first <= 1) {
					stack.push(ch);
					//System.out.println("stack에 " + ch + " push");
					stack_first = 2;
				}
				else { //지금 stack의 최신 노드가 *또는 /이거 라는 의미
					String pop = "";
					while(true) {//stack에 일단연산자가 있을거임.
						if(stack.peek().equals("×") || stack.peek().equals("/") ) {
							pop = stack.pop();
							//System.out.println("stack에서 " + pop + "을 pop");
							queue.add(pop);
							
						}
						else { //stack의 peek이 "(,+,-"일 경우
							stack.push(ch);
							//System.out.println("stack에 " + ch + " push");
							stack_first = 2;
							break;
						}
						
						if(stack.empty()) {//stack이 없을 경우
							stack.push(ch);
							//System.out.println("stack에 " + ch + " push");
							stack_first = 2;
							break;
						}
						
					}

				}
				
			}
			else if(ch.equals("+") || ch.equals("-")) {
				if(stack_first == 0) { //stack의 처음 들어갈 연산자일때 or 스택의 최신 노드가 "("일때
					stack.push(ch);
					//System.out.println("stack에 " + ch + " push");
					stack_first = 1;
				}
				else { 
					String pop = "";
					while(true) {//stack에 일단연산자가 있을거임.
						if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("×") || stack.peek().equals("/") ) {
							pop = stack.pop();
							//System.out.println("stack에서 " + pop + "을 pop");
							queue.add(pop);
							
						}
						else { //stack의 peek이 "("일 경우
							stack.push(ch);
							//System.out.println("stack에 " + ch + " push");
							stack_first = 1;
							break;
						}
						
						if(stack.empty()) {//stack이 없을 경우
							stack.push(ch);
							//System.out.println("stack에 " + ch + " push");
							stack_first = 1;
							break;
						}
						
					}

				}
			}
			else if(ch.equals(")")){
				String pop = "";
				while(true) {//(가 pop되지 않는 다면 stack이 비어있을 경우가 없다. 
					pop = stack.pop();
					//System.out.println("stack에서 " + pop + "을 pop");
					queue.add(pop);
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
				}
				
			}
			else { //ch가 숫자일때
				queue.add(ch);
			}
		}
		//stack에 남은 연산자 전부 queue로 보내기
		String pop = "";
		while(!stack.empty()) {//stack이 비어있지 않다면
			pop = stack.pop();
			//System.out.println("stack에서 " + pop + "을 pop");
			queue.add(pop);
		}
		
		//여기까지 stack은 비어있고 queue에 후위 표기법으로 수식이 정되 완료
		// 후위 표기법 계산하기 
		
		for(String p : queue) {
			System.out.println(p);
			if(p.equals("×") || p.equals("+")) {//stack에서 pop순서 상관 없는 경우
				String str_a = stack.pop();
				String str_b = stack.pop();
				double a = Double.parseDouble(str_a);
				double b = Double.parseDouble(str_b);
				double c = 0;
				if(p.equals("×")) {
					c = a * b;
					stack.push(c+"");
				}
				else {
					c = a + b;
					stack.push(c+"");
				}	
			}
			else if(p.equals("/") || p.equals("-")) {
				String str_a = stack.pop();
				String str_b = stack.pop();
				double a = Double.parseDouble(str_a);
				double b = Double.parseDouble(str_b);
				double c = 0;
				if(p.equals("/")) {
					
					c = b / a;
					stack.push(c+"");
				}
				else {
					c = b - a;
					stack.push(c+"");
				}	
				
			}
			else {//숫자는 그냥 stack에 push
				stack.push(p);
				//System.out.println("stack에 " + p + "가 push");
			}		
		}
		
		String ans = stack.pop();
		textField.setText(ans);
		
		
		System.out.println("--------------------------------");
		
		// 음수구현 X
		
		
		System.out.println("스레드가 종료되었습니다.");
	}
	
}
