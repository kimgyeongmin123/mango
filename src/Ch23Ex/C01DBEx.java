package Ch23Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C01DBEx {
	
	//DB정보
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/tmpdb";
	
	//JDBC참조변수
	static Connection conn=null;				//DB연결용 참조변수
	static PreparedStatement pstmt = null;		//SQL쿼리 전송용 참조변수
	static ResultSet rs = null;					//SQL쿼리 결과(SELECT결과) 수신용 참조변수
	
	public static void ConnectionDB() throws Exception{
		//연결시 사용
		Class.forName("com.mysql.cj.jdbc.Driver");	//드라이브 적재
		System.out.println("드라이브에 적재하였습니다.");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("커넥션이 성공하였습니다.");
	}
	
	public static void disConnectDB() throws Exception{
		//연결해제시 사용
		conn.close();
	}
	
	public static boolean InsertDB(String product_id, String product_name, int amount) {
		//완성시켜야 되는 코드
		//tbl_products
		//prod_id varchar(45), prod_name varchar(45), amount int
		int result = 0;
		try {
			pstmt = conn.prepareStatement("insert into tbl_products values(?,?,?)");
			pstmt.setString(1, product_id);
			pstmt.setString(2, product_name);
			pstmt.setInt(3, amount);
//--------------------------------------------------------------------------
			result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("인서트 성공했습니다 :)");
				return true;
			}else System.out.println("인서트 실패했습니다ㅜㅜ");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		try {
			ConnectionDB();
			InsertDB("3","컴퓨터",5);
			InsertDB("4","노트북",7);
			disConnectDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
