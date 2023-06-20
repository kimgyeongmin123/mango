package Ch20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C05GUI extends JFrame implements ActionListener, KeyListener{
	JButton btn1;
	JButton btn2;
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	
	C05GUI(){
		//Frame
		super("다섯번째 프레임창입니다.");
		setBounds(100,100,700,700);
		
		//Panel
		JPanel panel = new JPanel();	//패널생성
		panel.setLayout(null);
		
		//Btn_Component
		btn1 = new JButton("버튼을 만드럿다");
		btn1.setBounds(10,10,100,30);
		btn2 = new JButton("버튼을 만드럿다");
		btn2.setBounds(120,10,100,30);
		
		//Txt_Component
		txt1 = new JTextField();
		txt1.setBounds(10,50,100,30);
		txt2 = new JTextField();
		txt2.setBounds(120,50,100,30);

		//TxtArea_Component
		area1 = new JTextArea();
		area1.setBounds(10,90,210,300);
		
		//ScrollPane_Component
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,90,210,300);
		
		//Event_처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		
		//Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		
		
		//Frame
		add(panel);	//프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("이벤트 발생");
		if(e.getSource()==btn1)
		{
			System.out.println("버튼원 클릭");
		}else if(e.getSource()==btn2)
		{
			System.out.println("버튼투 클릭");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//키를 땟을때(UNICODE 지원)
//		System.out.println("키타입"+e.getKeyChar());
		System.out.println("키타입"+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때
		System.out.println("키프레스"+e.getKeyChar());
		System.out.println("키프레스"+e.getKeyCode());
		if(e.getSource()==txt1)
		{
			if(e.getKeyCode()==10)
			{
				System.out.println("txt1's Enter");
				String str = txt1.getText();
				area1.append(str+"\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//키를 땟을때(UNICODE 미지원)
		System.out.println("키릴리즈");
	}
}

public class C05SwingMain {

	public static void main(String[] args) {
		new C05GUI();
		
	}
}

