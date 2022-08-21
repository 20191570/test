package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
		
		//textArea�� textField�� �ۼ��� ���� ȭ�鿡�� �������� ���ϵ���
		textArea.setEditable(false);
		textField.setEditable(false);
		
		//�� ������ �κ� ������ ����
		textField.setAlignment(Pos.CENTER_RIGHT);
		
		//Font font = new Font(null, 0);
		//textArea.setFont(font);
		
		//textArea.setVisible(true); -> �۾��� �帮�� ��Ÿ��
		
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
		dot.setOnAction(e -> textArea.appendText("."));
		
		//split �ؾ���.
		plus.setOnAction(e -> textArea.appendText("+"));
		minus.setOnAction(e -> textArea.appendText("-"));
		mul.setOnAction(e -> textArea.appendText("��"));
		div.setOnAction(e -> textArea.appendText("/"));
		lring.setOnAction(e -> textArea.appendText("("));
		rring.setOnAction(e -> textArea.appendText(")"));
		
		
		del.setOnAction(e -> {
			
		});
		clear.setOnAction(e -> {
			
		});
		//'='�� �ۼ��ϸ� ������� ��µǵ��� �ؾ� �ϴµ�...
		answer.setOnAction(e -> {
			String str = textArea.getText();
			textField.setText(str);
			textArea.setText(""); //���� �Է��ϴ� �� �ʱ�ȭ	
		});

		
		
		
		
	}
	
	
	
	
}
