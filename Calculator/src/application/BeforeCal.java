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
		str = str.trim(); //Ȥ�� �� �յ� ���� ���ֱ�
		String[] str_arr = str.split(" "); //������ �������� ���ڿ� ������ �и�
		
		//boolean push_go = false; // (�� push�Ǹ� )�� ������ �������� ��� push�ؾ� �Ѵ�. 
		
		// ������ �켱���� : +,- = 1, *,/ = 2
		//stack �ֽſ� �ִ� ������ �켱����
		int stack_first = 0; //stack�� �ƹ� �����ڵ� ���� ��� or (�� push�Ǿ��� ���
		
		
		//queue�� ���� ǥ������� �Է��ϱ�
		for(String ch : str_arr) {
			//System.out.println("ch : " + ch);
			if(ch.equals("(")) {
				stack.push(ch); //)�� ������ �������� ��� push�ؾ� �ϹǷ�
				//System.out.println("stack�� " + ch + " push");
				stack_first = 0;
			}
			else if(ch.equals("��") || ch.equals("/")) {
				if(stack_first <= 1) {
					stack.push(ch);
					//System.out.println("stack�� " + ch + " push");
					stack_first = 2;
				}
				else { //���� stack�� �ֽ� ��尡 *�Ǵ� /�̰� ��� �ǹ�
					String pop = "";
					while(true) {//stack�� �ϴܿ����ڰ� ��������.
						if(stack.peek().equals("��") || stack.peek().equals("/") ) {
							pop = stack.pop();
							//System.out.println("stack���� " + pop + "�� pop");
							queue.add(pop);
							
						}
						else { //stack�� peek�� "(,+,-"�� ���
							stack.push(ch);
							//System.out.println("stack�� " + ch + " push");
							stack_first = 2;
							break;
						}
						
						if(stack.empty()) {//stack�� ���� ���
							stack.push(ch);
							//System.out.println("stack�� " + ch + " push");
							stack_first = 2;
							break;
						}
						
					}

				}
				
			}
			else if(ch.equals("+") || ch.equals("-")) {
				if(stack_first == 0) { //stack�� ó�� �� �������϶� or ������ �ֽ� ��尡 "("�϶�
					stack.push(ch);
					//System.out.println("stack�� " + ch + " push");
					stack_first = 1;
				}
				else { 
					String pop = "";
					while(true) {//stack�� �ϴܿ����ڰ� ��������.
						if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("��") || stack.peek().equals("/") ) {
							pop = stack.pop();
							//System.out.println("stack���� " + pop + "�� pop");
							queue.add(pop);
							
						}
						else { //stack�� peek�� "("�� ���
							stack.push(ch);
							//System.out.println("stack�� " + ch + " push");
							stack_first = 1;
							break;
						}
						
						if(stack.empty()) {//stack�� ���� ���
							stack.push(ch);
							//System.out.println("stack�� " + ch + " push");
							stack_first = 1;
							break;
						}
						
					}

				}
			}
			else if(ch.equals(")")){
				String pop = "";
				while(true) {//(�� pop���� �ʴ� �ٸ� stack�� ������� ��찡 ����. 
					pop = stack.pop();
					//System.out.println("stack���� " + pop + "�� pop");
					queue.add(pop);
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
				}
				
			}
			else { //ch�� �����϶�
				queue.add(ch);
			}
		}
		//stack�� ���� ������ ���� queue�� ������
		String pop = "";
		while(!stack.empty()) {//stack�� ������� �ʴٸ�
			pop = stack.pop();
			//System.out.println("stack���� " + pop + "�� pop");
			queue.add(pop);
		}
		
		//������� stack�� ����ְ� queue�� ���� ǥ������� ������ ���� �Ϸ�
		// ���� ǥ��� ����ϱ� 
		
		for(String p : queue) {
			System.out.println(p);
			if(p.equals("��") || p.equals("+")) {//stack���� pop���� ��� ���� ���
				String str_a = stack.pop();
				String str_b = stack.pop();
				double a = Double.parseDouble(str_a);
				double b = Double.parseDouble(str_b);
				double c = 0;
				if(p.equals("��")) {
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
			else {//���ڴ� �׳� stack�� push
				stack.push(p);
				//System.out.println("stack�� " + p + "�� push");
			}		
		}
		
		String ans = stack.pop();
		textField.setText(ans);
		
		
		System.out.println("--------------------------------");
		
		// �������� X
		
		
		System.out.println("�����尡 ����Ǿ����ϴ�.");
	}
	
}
