package Ch20;

import javax.swing.JFrame;

public class C01SwingMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("첫번째 프레임창입니다.");
		frame.setBounds(100,100,700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X 버튼 클릭시 프로그램 종료
		frame.setVisible(true);
		
	}
}
