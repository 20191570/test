package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class CalController implements Initializable{
	
	@FXML private TextArea textArea;
	@FXML private TextField textField;
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
	@FXML private Button save;
	@FXML private Button del;
	@FXML private Button mul;
	@FXML private Button div;
	@FXML private Button minus;
	@FXML private Button plus;
	@FXML private Button answer;
	@FXML private Button clear;
	@FXML private Button dot;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//textArea와 textField에 바로 작성하지 못하게 하기
		textArea.setDisable(true);
		textField.setDisable(true);
		
		//Font font = new Font(null, 0);
		//textArea.setFont(font);
		
		//textArea.setVisible(true); -> 글씨가 흐리게 나타남
		
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
		dot.setOnAction(e -> textArea.appendText("."));
		plus.setOnAction(e -> textArea.appendText("+"));
		minus.setOnAction(e -> textArea.appendText("-"));
		mul.setOnAction(e -> textArea.appendText("*"));
		div.setOnAction(e -> textArea.appendText("/"));
		save.setOnAction(e -> {
			
		});
		del.setOnAction(e -> {
			
		});
		clear.setOnAction(e -> {
			
		});
		answer.setOnAction(e -> {
			
		});

		
		
		
		
	}
	
	
	
	
}
