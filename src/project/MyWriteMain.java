package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyWriteMain {

	public static void main(String[] args) {
		new GUI2();
	}

}

class GUI2 extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JTable tbl1;
	JTable tbl2;
	JTextArea area1;
	JScrollPane scroll1;
	JScrollPane scroll2;
//	연결정보 저장용 변수
	String id="root";
	String pw="1234";
	String url="jdbc:mysql://localhost:3306/게시판";
	
//	JDBC참조변수
	Connection conn = null;				//DB연결용 참조변수
	PreparedStatement pstmt = null;		//SQL쿼리 전송용 참조변수
	ResultSet rs = null;				//SQL쿼리 결과(SELECT결과)수신용 참조변수

	GUI2() {
		// Frame
		super("내가 쓴 글");
		setBounds(100, 100, 900, 900);


		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);


		// Component
		btn1 = new JButton("나가기");
		tbl1 = new JTable();
		tbl2 = new JTable();
		area1 = new JTextArea();
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);
		
//		JTextField srch = new JTextField();

		// Positioning
		tbl1.setBounds(10, 130, 860, 200);		//인기글
		tbl2.setBounds(10, 340, 860, 450);		//메인글
		
		btn1.setBounds(700, 800, 90, 30);		//나가기

		
		scroll1.setBounds(10, 130, 860, 200);	//인기글 스크롤
		scroll2.setBounds(10, 340, 860, 450);	//메인글 스크롤
		
//		srch.setBounds(15,800,140,30);			//검색

		// Event처리
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                
//                new GUI(); // GUI1으로 돌아가기
			}
		});		//글작성

		
		tbl1.addKeyListener(this);
		area1.setEditable(false);
		
		btn1.setFont(new Font("굴림",Font.BOLD,12));

		
// 		Add_Panel_Component
		panel.add(btn1);
		
		panel.add(tbl1);
		panel.add(tbl2);
//		panel.add(area1);
		panel.add(scroll1);
		panel.add(scroll2);
		
//		panel.add(srch);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}