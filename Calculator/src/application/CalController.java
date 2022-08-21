package application;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalController implements Initializable{
	
	@FXML TextArea textArea;
	@FXML TextField textField;
	@FXML private Button one;
	@FXML private Button two;
	@FXML private Button three;
	@FXML private Button four;
	@FXML private Button five;
	@FXML private Button six;
	@FXML private Button seven;
	@FXML private Button eight;
	@FXML private Button nine;
	@FXML private Button zero;
	@FXML private Button del;
	@FXML private Button mul;
	@FXML private Button div;
	@FXML private Button minus;
	@FXML private Button plus;
	@FXML private Button answer;
	@FXML private Button clear;
	@FXML private Button dot;
	@FXML private Button rring;
	@FXML private Button lring;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//���� ����� ���� stack����
//		Stack<String> stack = new Stack<String>();
//		Queue<String> queue = new LinkedList<>();
		
		//textArea�� textField�� �ۼ��� ���� ȭ�鿡�� �������� ���ϵ���
		//textArea.setEditable(false);
		textField.setEditable(false);
		
		//�� ������ �κ� ������ ����
		textField.setAlignment(Pos.CENTER_RIGHT);
		
		//Font font = new Font(null, 0);
		//textArea.setFont(font);
		
		
		//��ư ��� �����ϱ�
		zero.setOnAction(e -> textArea.appendText("0"));
		one.setOnAction(e -> textArea.appendText("1"));
		two.setOnAction(e -> textArea.appendText("2"));
		three.setOnAction(e -> textArea.appendText("3"));
		four.setOnAction(e -> textArea.appendText("4"));
		five.setOnAction(e -> textArea.appendText("5"));
		six.setOnAction(e -> textArea.appendText("6"));
		seven.setOnAction(e -> textArea.appendText("7"));
		eight.setOnAction(e -> textArea.appendText("8"));
		nine.setOnAction(e -> textArea.appendText("9"));
		dot.setOnAction(e -> textArea.appendText(".")); // ���߿� ���ο� �˰��� �ʿ�
		
		//split �ؾ���.
		plus.setOnAction(e -> textArea.appendText(" + "));
		minus.setOnAction(e -> textArea.appendText(" - "));
		mul.setOnAction(e -> textArea.appendText(" �� "));
		div.setOnAction(e -> textArea.appendText(" / "));
		lring.setOnAction(e -> textArea.appendText("( "));
		rring.setOnAction(e -> textArea.appendText(" )"));
		
		
		del.setOnAction(e -> {
			
		});
		clear.setOnAction(e -> {
			textArea.setText("");
			textField.setText("");
		});
		//'='�� �ۼ��ϸ� ������� ��µǵ��� �ؾ� �ϴµ�...
		answer.setOnAction(e -> {
			
			//������ ���� , ������ ���� ǥ������� ��ȯ
			Runnable before = new BeforeCal(textArea, textField);
			Thread thread = new Thread(before);
			thread.start();
			
			
			
		});

		
		
		
		
	}
	
	
	
	
}
