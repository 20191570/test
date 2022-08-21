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
		
		//수식 계산을 위한 stack생성
//		Stack<String> stack = new Stack<String>();
//		Queue<String> queue = new LinkedList<>();
		
		//textArea와 textField에 작성된 것을 화면에서 수정하지 못하도록
		//textArea.setEditable(false);
		textField.setEditable(false);
		
		//답 나오는 부분 오른쪽 정렬
		textField.setAlignment(Pos.CENTER_RIGHT);
		
		//Font font = new Font(null, 0);
		//textArea.setFont(font);
		
		
		//버튼 기능 설정하기
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
		dot.setOnAction(e -> textArea.appendText(".")); // 나중에 새로운 알고리즘 필요
		
		//split 해야함.
		plus.setOnAction(e -> textArea.appendText(" + "));
		minus.setOnAction(e -> textArea.appendText(" - "));
		mul.setOnAction(e -> textArea.appendText(" × "));
		div.setOnAction(e -> textArea.appendText(" / "));
		lring.setOnAction(e -> textArea.appendText("( "));
		rring.setOnAction(e -> textArea.appendText(" )"));
		
		
		del.setOnAction(e -> {
			
		});
		clear.setOnAction(e -> {
			textArea.setText("");
			textField.setText("");
		});
		//'='을 작성하면 계산결과가 출력되도록 해야 하는데...
		answer.setOnAction(e -> {
			
			//쓰레드 생성 , 수식을 후위 표기법으로 전환
			Runnable before = new BeforeCal(textArea, textField);
			Thread thread = new Thread(before);
			thread.start();
			
			
			
		});

		
		
		
		
	}
	
	
	
	
}
