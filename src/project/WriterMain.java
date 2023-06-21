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
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class WriterMain {

	public static void main(String[] args) {
		new GUI1();

	}

}

class GUI1 extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextArea area1;
	JScrollPane scroll1;
//	연결정보 저장용 변수
	String id="root";
	String pw="1234";
	String url="jdbc:mysql://localhost:3306/게시판";
	
//	JDBC참조변수
	Connection conn = null;				//DB연결용 참조변수
	PreparedStatement pstmt = null;		//SQL쿼리 전송용 참조변수
	ResultSet rs = null;				//SQL쿼리 결과(SELECT결과)수신용 참조변수


	GUI1() {
		// Frame
		super("글쓰기");
		setBounds(100, 100, 1000, 800);

		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);


		// Component
		btn1 = new JButton("저장");
		btn2 = new JButton("수정");
		btn3 = new JButton("나가기");
		txt1 = new JTextField("닉네임 : ");
		txt2 = new JTextField("제목 : ");
		txt3 = new JTextField("내용 : ");
		area1 = new JTextArea();
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);

		// Positioning
		txt1.setBounds(15, 15, 300, 40); // 전
//		txt1.setBounds(730, 70, 235, 40); // 후
		txt2.setBounds(15, 70, 700, 40);
		txt3.setBounds(15, 125, 950, 570);

		btn1.setBounds(770, 10, 90, 30); // 저장
		btn2.setBounds(870, 10, 90, 30); // 수정
		btn3.setBounds(870, 700, 90, 30); // 나가기

		scroll1.setBounds(15, 125, 950, 570);

		// Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
		txt3.addKeyListener(this);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "저장하실?");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	//드라이버 적재
					System.out.println("Driver Loading Success..");
					conn = DriverManager.getConnection(url,id,pw);
					System.out.println("DB Connected..");
					pstmt = conn.prepareStatement("insert into tbl_게시판 values(null,?,?,?,now())");
					pstmt.setString(1, txt1.getText());
					pstmt.setString(2, txt2.getText());
					pstmt.setString(3, txt3.getText());
					int result = pstmt.executeUpdate();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					try {pstmt.close();}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				dispose();
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn2 클릭 시 수정
				JOptionPane.showMessageDialog(null, "수정하실?");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 적재
					System.out.println("Driver Loading Success..");
					conn = DriverManager.getConnection(url, id, pw);
					System.out.println("DB Connected..");
					pstmt = conn.prepareStatement("update tbl_게시판 set 글쓴이=?, 글제목 = ?,작성날짜=now() where 글내용=?");
					pstmt.setString(1, txt1.getText());
					pstmt.setString(2, txt2.getText());
					pstmt.setString(3, txt3.getText());
					int result = pstmt.executeUpdate();
				
					if(result>0) {
						JOptionPane.showMessageDialog(null, "UPDATE성공", "DBCONN",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false); // 프레임창닫기

					}
					else {
						JOptionPane.showMessageDialog(null, "UPDATE실패", "DBCONN", JOptionPane.ERROR_MESSAGE);
						setVisible(false); // 프레임창닫기
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {pstmt.close();} catch (Exception e1) {e1.printStackTrace();}
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn3 클릭 시 돌아가기
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                
//                new GUI(); // GUI1으로 돌아가기
				
				

				
			}
		});

		
		btn1.setFont(new Font("굴림",Font.BOLD,12));
		btn2.setFont(new Font("굴림",Font.BOLD,12));		
		btn3.setFont(new Font("굴림",Font.BOLD,12));
		
		
// 		Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(txt2);
		panel.add(txt3);
//				panel.add(area1);
		panel.add(scroll1);

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