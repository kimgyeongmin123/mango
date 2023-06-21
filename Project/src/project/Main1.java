package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Main1 {

	public static void main(String[] args) {
		new Main_GUI();
	}

}

class Main_GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
//	JButton btn3;
	JButton btn4;
	JButton btn5;

	JTable tbl1;
	JTable tbl2;
	JLabel txt3;

	JTextArea area1;
	JScrollPane scroll1;
	JScrollPane scroll2;

	DefaultTableModel model;

	Main_GUI() {
		// Frame
		super("");
		setBounds(100, 100, 900, 900);

		// Panel
		JPanel panel = new JPanel(); // 패널생성

		panel.setLayout(null);

		// Component
		btn1 = new JButton("글 작성");
		btn2 = new JButton("내가 쓴글");
		btn4 = new JButton("종료");
		btn5 = new JButton("검색");
		tbl1 = new JTable();
		tbl2 = new JTable();
		txt3 = new JLabel("다 같이 게시판");
		area1 = new JTextArea();
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);

		JTextField srch = new JTextField();

		// Positioning
		tbl1.setBounds(10, 130, 860, 200); // 인기글
		tbl2.setBounds(10, 340, 860, 450); // 메인글
		txt3.setBounds(280, 10, 300, 60); // 제목

		btn1.setBounds(680, 80, 90, 30); // 글작성
		btn2.setBounds(780, 80, 90, 30); // 내가 쓴 글
//		btn3.setBounds(10, 10, 860, 60);		//제목
		btn4.setBounds(770, 800, 90, 30); // 나가기
		btn5.setBounds(160, 800, 60, 30); // 검색

		scroll1.setBounds(10, 130, 860, 200); // 인기글 스크롤
		scroll2.setBounds(10, 340, 860, 450); // 메인글 스크롤

		srch.setBounds(15, 800, 140, 30); // 검색

		// Event처리
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WriterMain_GUI();
				dispose();
			}
		}); // 글작성

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MyWriter_GUI();
				dispose();
			}
		});
//		btn2.addActionListener(this);		//내가 쓴 글
//		btn3.addActionListener(this);		//제목
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 종료
				JOptionPane.showMessageDialog(null, "프로그램 종료하실?");
				System.exit(0);
			}
		});

		tbl1.addKeyListener(this);
		area1.setEditable(false);

		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		btn2.setFont(new Font("굴림", Font.BOLD, 12));
//		btn3.setFont(new Font("굴림",Font.BOLD,25));
		btn4.setFont(new Font("굴림", Font.BOLD, 12));
		btn5.setFont(new Font("굴림", Font.BOLD, 12));

		txt3.setFont(new Font("굴림", Font.BOLD, 30)); // 제목

		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
//		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

//		panel.add(tbl1);
//		panel.add(tbl2);
		panel.add(txt3); // 다 같이 게시판 제목

//			panel.add(area1);
//		panel.add(scroll1);	//게시물 목록뜰 때 더블클릭 안되게 할 수 있음
//		panel.add(scroll2);

		panel.add(srch);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// DB연결해서 메인창에 띄우기
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/게시판";

		// JDBC참조변수
		Connection conn = null; // DB연결용 참조변수
		PreparedStatement pstmt = null; // SQL쿼리 전송용 참조변수
		ResultSet rs = null; // SQL쿼리 결과(SELECT결과) 수신용 참조변수

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이브 적재
			System.out.println("Driver Loading Success!");
			conn = DriverManager.getConnection(url, id, pw); // 성공하면 Connection객체를 반환
			System.out.println("DB Connected!");

			String[] column = { "No", "글쓴이", "글제목", "작성날짜" };
			Object[][] data = {};

			model = new DefaultTableModel(data, column) {

				public boolean isCellEditable(int i, int c) {
					return false;
				}

			};

			// 쿼리문
			pstmt = conn.prepareStatement("select * from tbl_게시판");

			rs = pstmt.executeQuery();

			if (rs != null) {

				while (rs.next()) {
					Object[] rowData = { rs.getInt("number"), rs.getString("글쓴이"), rs.getString("글제목"),
							rs.getString("작성날짜") };
					model.addRow(rowData);
//					System.out.print(rs.getString("number") + " ");
//					System.out.print(rs.getString("글쓴이") + " ");
//					System.out.print(rs.getString("글제목") + " ");
//					System.out.print(rs.getString("작성날짜") + "\n");
				}
			}

			JTable table = new JTable(model);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setBounds(10, 130, 860, 650);

			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(1).setMaxWidth(200);
			table.getColumnModel().getColumn(2).setMaxWidth(1000);
			table.getColumnModel().getColumn(3).setMaxWidth(400);

			panel.add(scroll);
			panel.setLayout(null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		model.addMouseListener(new MouseListener(){
			
			public void mouseClicked1(MouseEvent e) {
				// JTable 셀 클릭 시 이벤트 처리
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				int col = target.getSelectedColumn();
				
				System.out.println("이벤트처리는 됏따 이말이야");
				
			}

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			});

		
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
