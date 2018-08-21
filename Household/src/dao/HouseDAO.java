package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.House;


public class HouseDAO {

	public static ArrayList<House> record(String key,String income,String spending){
		ArrayList<House> resultList = new ArrayList<House>();

	//①準備
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs = 0;

	try{
		// ②JDBCドライバをロードする
		Class.forName("com.mysql.jdbc.Driver");

		// ③DBMSとの接続を確立する
		con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testdb?useSSL=false",
					"user1",
					"pass1");

		// ④SQL文を作成する
		String sql = "Insert into household values(?,?,?);";

		// ⑤SQL文を実行するための準備を行う

		pstmt = con.prepareStatement(sql);
		int keyN = Integer.parseInt(key);
		pstmt.setInt(1, keyN);
		pstmt.setString(2, income);
		pstmt.setString(3, spending);

		// ⑥SQL文を実行してDBMSから結果を受信する
		rs = pstmt.executeUpdate();



	}catch (ClassNotFoundException e) {
		System.out.println("JDBCドライバが見つかりません。");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("DBアクセス時にエラーが発生しました。");
		e.printStackTrace();
	} finally {
		// ⑧DBMSから切断する
		try {
			if (pstmt != null) {
				pstmt.close();
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
	//Monstoテーブルからデータをすべて取得する。
			public static House recordHouse(String key){
				ArrayList<House> resultList = new ArrayList<House>();

				//変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try{
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/testdb?useSSL=false",
							"user2",
							"pass2");

					String sql = "SELECT * FROM household where number = ?";

					pstmt = con.prepareStatement(sql);

					int keyN = Integer.parseInt(key);
					pstmt.setInt(1, keyN);

					rs = pstmt.executeQuery();

					rs.next();
					int number = rs.getInt("number");
					String income = rs.getString("income");
					String spending = rs.getString("spending");
					resultList.add(new House(number,income,spending));


				} catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();

				} catch (Exception e){
					System.out.println("数字を指定してください。");
				} finally {
					try {
						if( rs != null){
							rs.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
					try {
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

				}

				return null;
			}


}
