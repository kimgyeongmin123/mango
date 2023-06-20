package Ch20;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class C03GUI extends JFrame{
	C03GUI(){
		super("두번째 프레임창입니다.");
		setBounds(100,100,700,700);
		
		JPanel panel = new JPanel();	//패널생성
		
		//배경색지정
		Color col = new Color(199,71,109);	//RGB
		panel.setBackground(col);
		
		add(panel);	//프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class C03SwingMain {

	public static void main(String[] args) {
		new C03GUI();
		
	}
}

