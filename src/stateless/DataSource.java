package stateless;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.crypto.Data;


public class DataSource {
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private	String url;
	private	String user ;
	private	String password ;
	
	private DataSource() {}
	
	
	public static DataSource getInstance() {
		
		return dataSource;
	}

	public Connection getConnection() {
		dbConfig(); //환경파일을 불러 DB정보를 담는다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//장점: 데이터베이스 접근정보 변경시 자바에서 수정할 필요없이 파일에서 바로 정보변경 가능
	
	public void dbConfig() { //환경파일을 불러오는 메소드
		String resource = getClass().getResource("db.properties").getPath();  //   .. : 상위폴더  getpath: 실제 위치를 알려준다
		//  getresource로 해당위치에 있는 파일 가져옴
		Properties properties = new Properties();  //properties (collection) 객체 생성
		
		try {
			
		//load 메소드 : 파일을 읽어서 properties 객체 안에 입력  (property / value)  / getproperty : value 반환
		properties.load(new FileReader(resource));   //환경파일을 reader 객체를 통해 읽음
		
		//getProperty메서드: value값을 반환
		driver = properties.getProperty("driver");   // 변수에 환경파일의 값을 적용
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
