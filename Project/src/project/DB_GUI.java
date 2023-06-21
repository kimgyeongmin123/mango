package project;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class MyWriter_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	
	
	JLabel lbl1;
	JTable tbl1;
	JTable tbl2;
	JTable tbl3;
	JTable tbl4;
	JTable tbl5;

	JTextArea area1;
	
	JScrollPane scroll1;
//	JScrollPane scroll2;

	DefaultTableModel model;
	
	MyWriter_GUI() {
		// Frame
		super("클릭한 게시물");
		setBounds(100, 100, 900, 900);
		setResizable(false);


		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);


		// Component
		btn1 = new JButton("나가기");

		lbl1 = new JLabel("게시물 조회");
		
		
		area1 = new JTextArea();
		 area1.setBounds(10,90,210,300);
//		scroll1 = new JScrollPane(area1);
//		scroll2 = new JScrollPane(area1);

		
		JTextField srch = new JTextField();

		//---------------------------------------------------------------
				String id = "root";
				String pw = "1234";
				String url = "jdbc:mysql://localhost:3306/게시판";
			
				//JDBC참조변수
				Connection conn = null; 	//DB연결용 참조변수
				PreparedStatement pstmt = null; // SQL쿼리 전송용 참조변수
				ResultSet rs = null;		// SQL쿼리 결과(SELECT결과) 수신용 참조변수
				
				try { 
					Class.forName("com.mysql.cj.jdbc.Driver");		//드라이브 적재
					System.out.println("Driver Loading Success..");
					conn=DriverManager.getConnection(url,id,pw);
					System.out.println("DB Connected..");
					
					String[] column = {"number","글쓴이","글제목","글내용","작성날짜"};
					Object[][] data = {};
					
					model = new DefaultTableModel(data, column) {
						public boolean isCellEditable(int i , int c) {
						return false;	
						}
					};
					
					pstmt = conn.prepareStatement("select * from tbl_게시판");
					rs=pstmt.executeQuery();
					
					if(rs!= null) {
					while(rs.next()) {
						Object[] rowData = {rs.getInt("number"), rs.getString("글쓴이"), rs.getString("글제목"),
								rs.getString("글내용"),rs.getString("작성날짜")};
						model.addRow(rowData);
						}
//						System.out.print(rs.getInt("number")+" ");
//						System.out.print(rs.getString("이름")+" ");
//						System.out.print(rs.getString("제목")+" ");
//						System.out.print(rs.getString("내용")+" ");
//						System.out.print(rs.getString("작성날짜")+" ");
					}
					tbl1 = new JTable(model);
					tbl2 = new JTable(model);
					tbl3 = new JTable(model);
					tbl4 = new JTable(model);
					tbl5 = new JTable(model);
					
					tbl1.getColumnModel().getColumn(0).setMaxWidth(20);
					tbl2.getColumnModel().getColumn(1).setMaxWidth(30);
					tbl3.getColumnModel().getColumn(2).setMaxWidth(100);
					tbl4.getColumnModel().getColumn(3).setMaxWidth(300);
					tbl5.getColumnModel().getColumn(4).setMaxWidth(50);
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();}catch(Exception e) {e.printStackTrace();}
					
					try {
					pstmt.close();} catch(Exception e){e.printStackTrace();}
					try {
						
					conn.close();}catch(Exception e) {e.printStackTrace();}
				}
				//------------------------------------------------------------------

		// Positioning
		lbl1.setBounds(10, 10, 400, 80);		//대제목
		tbl1.setBounds(10, 100, 100, 30);	//게시글번호 칸
		tbl2.setBounds(130, 100, 730, 30);	//작성자 칸
		tbl3.setBounds(10, 150, 850, 30);	//제목 칸
		tbl4.setBounds(10, 200, 850, 530);	//내용 칸
		tbl5.setBounds(10, 750, 850, 30);	//시간 칸	
		Color col = new Color(71,100,109); //RGB
		Color col1 = new Color(80,15,109); //RGB
		Color col2 = new Color(90,150,109); //RGB
		Color col3 = new Color(100,80,109); //RGB
		Color col4 = new Color(110,199,10); //RGB
		tbl1.setBackground(col);
		tbl2.setBackground(col1);
		tbl3.setBackground(col2);
		tbl4.setBackground(col3);
		tbl5.setBackground(col4);
//		scroll1.setBounds(10, 100, 860, 680);		//작성 글 
		
		btn1.setBounds(770, 800, 90, 30);		//나가기
		

		// Event처리
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                
//                new GUI(); // GUI1으로 돌아가기
			}
		});		//글작성

		area1.setEditable(false);

		btn1.setFont(new Font("굴림",Font.BOLD,17));
		lbl1.setFont(new Font("굴림",Font.BOLD,30));
		tbl1.setFont(new Font("굴림",Font.BOLD,15));
		tbl2.setFont(new Font("굴림",Font.BOLD,15));
		tbl3.setFont(new Font("굴림",Font.BOLD,17));
		tbl4.setFont(new Font("굴림",Font.BOLD,20));
		tbl5.setFont(new Font("굴림",Font.BOLD,10));
		
		// Add_Panel_Component
		panel.add(btn1);

		
		panel.add(lbl1);
		
		panel.add(tbl1);
		panel.add(tbl2);
		panel.add(tbl3);
		panel.add(tbl4);
		panel.add(tbl5);
//			panel.add(area1);
//		panel.add(scroll1);
//		panel.add(scroll2);
		
		panel.add(srch);

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

public class DB_GUI extends MyWriter_GUI {
	
	public static void main(String[] args) {
		new DB_GUI();

		


	}
}
	