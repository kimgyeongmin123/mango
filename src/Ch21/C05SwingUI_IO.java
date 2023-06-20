package Ch21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C06GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;

	C06GUI() {
		// Frame
		super("여섯번째 프레임창입니다.");
		setBounds(100, 100, 700, 700);

		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);

		// Btn_Component
		btn1 = new JButton("버튼을 만드럿다");
		btn1.setBounds(10, 10, 100, 30);
		btn2 = new JButton("버튼을 만드럿다");
		btn2.setBounds(120, 10, 100, 30);

		// Txt_Component
		txt1 = new JTextField();
		txt1.setBounds(10, 50, 100, 30);
		txt2 = new JTextField();
		txt2.setBounds(120, 50, 100, 30);

		// TxtArea_Component
		area1 = new JTextArea();
		area1.setBounds(10, 90, 210, 300);

		// ScrollPane_Component
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 90, 210, 300);

		// Event_처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("이벤트 발생");
		if (e.getSource() == btn1) {
			System.out.println("저장하기 클릭");

			String context = area1.getText();
			String dirPath = "c:\\iotest\\";
			String filename = UUID.randomUUID().toString();

			try {
				Writer out = new FileWriter(dirPath + filename + ".txt");
				out.write(new Date().toString() + "\n");
				out.write(context);
				out.flush();
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == btn2) {
			System.out.println("불러오기 클릭");
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			String filename=null;
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				filename=fileChooser.getSelectedFile().toString();
				}
			System.out.println(filename);
			
			try {
				Reader in = new FileReader(filename);
				area1.setText(""); 	//area1에 있는 내용들을 비운다.
				StringBuffer buffer = new StringBuffer();
				while(true)
				{
					int data = in.read();
					if(data==-1) break;
					buffer.append((char)data);
				}
				in.close();
				area1.append(buffer.toString());
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 키를 땟을때(UNICODE 지원)
//		System.out.println("키타입"+e.getKeyChar());
//		System.out.println("키타입"+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 눌렀을때
//		System.out.println("키프레스"+e.getKeyChar());
//		System.out.println("키프레스"+e.getKeyCode());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				System.out.println("txt1's Enter");
				String str = txt1.getText();
				area1.append(str + "\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 키를 땟을때(UNICODE 미지원)
//		System.out.println("키릴리즈");
	}

	@Override
	public void mouseClicked(MouseEvent e) {0
		System.out.println("미우스 클릭");
		System.out.println("x축 : "+e.getPoint().x+" "+"y축 : "+e.getPoint().y);	//x, y position return
		int offset = area1.viewToModel(e.getPoint());
		System.out.println("처음부터 " + offset + "번째 문자 입니다.");
		try {
			int row = area1.getLineOfOffset(offset);		//해당라인이 몇번째 라인인지 저장
			System.out.println((row+1)+"번째 라인 입니다.");
			int startOffset = area1.getLineStartOffset(row);	//로우값을 받아서 해당행에있는 시작문자열 위치를 숫자형태로 받아온다.
			int endOffset = area1.getLineEndOffset(row);		//로우값을 받아서 해당행에있는 마지막문자열 위치를 숫자형태로 받아온다.
			String txt = area1.getText(startOffset,endOffset-startOffset);
			System.out.println("입력한 문자 : " + txt);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("마우스 프레스드");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("마우스 릴리즈");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("마우스엔털드");

	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("마우스엑시트");

	}
}

public class C05SwingUI_IO {

	public static void main(String[] args) {
		new C06GUI();

	}
}
