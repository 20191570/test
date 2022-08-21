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
			System.out.println("ch : " + ch);
			if(ch.equals("(")) {
				stack.push(ch); //)�� ������ �������� ��� push�ؾ� �ϹǷ�
				System.out.println("stack�� " + ch + " push");
				stack_first = 0;
			}
			else if(ch.equals("��") || ch.equals("/")) {
				stack.push(ch);
				System.out.println("stack�� " + ch + " push");
				stack_first = 2;
				
			}
			else if(ch.equals("+") || ch.equals("-")) {
				if(stack_first <= 1) {
					stack.push(ch);
					System.out.println("stack�� " + ch + " push");
					stack_first = 1;
				}
				else { //���� stack�ֽſ� *�� /�� �ִٴ� ���̹Ƿ�
					String pop = "";
					while(!stack.empty()) {//stack�� ������� �ʴٸ�
						if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("(") ) {
							stack.push(ch);
							stack_first = 1;
							System.out.println("stack�� " + ch + " push");
							break;
						}
						else {
							pop = stack.pop();
							System.out.println("stack���� " + pop + "�� pop");
							queue.add(pop);
						}
	
					}

				}
			}
			else if(ch.equals(")")){
				String pop = "";
				System.out.println("�����1");
				while(true) {//(�� pop���� �ʴ� �ٸ� stack�� ������� ��찡 ����. 
					pop = stack.pop();
					System.out.println("�����2");
					System.out.println("stack���� " + pop + "�� pop");
					System.out.println("�����3");
					queue.add(pop);
					System.out.println("�����4");
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
				}
				
			}
			else { //ch�� �����϶�
				queue.add(ch);
				//System.out.println("queue�� "+ch +"����");
			}
		}
		//stack�� ���� ������ ���� queue�� ������
		String pop = "";
		while(!stack.empty()) {//stack�� ������� �ʴٸ�
			pop = stack.pop();
			System.out.println("stack���� " + pop + "�� pop");
			queue.add(pop);
		}
		System.out.println("--------------------------------");
		
		for(String p : queue) {
			System.out.println(p);
		}
		
		
		System.out.println("�����尡 ����Ǿ����ϴ�.");
	}
	
}
