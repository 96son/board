package kh.study.board;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DB_Conect_Test {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void connectionTest() {
		try {
			Connection con = sqlSessionFactory.openSession().getConnection();
			System.out.println("연결 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}









