package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.House;


public class HouseDAO2 {

	public static ArrayList<House> Record(){
		ArrayList<House> resultList = new ArrayList<House>();

	//①準備
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		// ②JDBCドライバをロードする
		Class.forName("com.mysql.jdbc.Driver");

		// ③DBMSとの接続を確立する
		con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testdb?useSSL=false",
					"user1",
					"pass1");

		// ④SQL文を作成する
		String sql = "SELECT * FROM household";

		// ⑤SQL文を実行するための準備を行う
		pstmt = con.prepareStatement(sql);


		// ⑥SQL文を実行してDBMSから結果を受信する
		rs = pstmt.executeQuery();

		// ⑦実行結果を含んだインスタンスからデータを取り出す
		while(rs.next() == true){
			//ResultSetからデータを取得する
			int number = rs.getInt("number");
			String income = rs.getString("income");
			String spending = rs.getString("spending");

			resultList.add(new House(number,income,spending));

		}


	}catch (ClassNotFoundException e) {
		System.out.println("JDBCドライバが見つかりません。");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("DBアクセス時にエラーが発生しました。");
		e.printStackTrace();
	} finally {
		// ⑧DBMSから切断する
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
	}

	return resultList;


	}

}