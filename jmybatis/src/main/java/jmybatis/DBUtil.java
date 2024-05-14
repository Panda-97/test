package jmybatis;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {

	SqlSessionFactory sqlSessionFactory;

	public void init() {

		try {
			String resource = "jmybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 입력하는 스트림 InputStream
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// sqlSessionFactory sql문 가져오는데 도움주는거
		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오기 실패");

			e.printStackTrace();
		}
	} // init

	public ArrayList<UserDTO> getUser() {
		// SQL문 준비
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		ArrayList<UserDTO> userlist = mapper.getUser();
		
		return userlist;
	
	} // select 

	public void insertUser(String user_id, String user_pw, String name, String phone, String grade, int age) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserDTO userDTO = new UserDTO(user_id, user_pw, name, phone, grade, age);
		mapper.insertUser(userDTO);
		session.commit();
	} // insert
	
	public void updateUser(String name, String user_id) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.updateUser(name, user_id);
		session.commit();
	} // update
	
	public void deleteUser(String user_id) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUser(user_id);
		session.commit();
	} // delete 
	
	public void login(String user_id , String user_pw) {
		UserDTO dto = new UserDTO();
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.selectOne("loginCh", user_id);
		
		if(count == 0) {
			System.out.println("아이디가 존재하지 않습니다.");
		} else {
			dto = session.selectOne("login",user_id);
			if (user_pw.equals(dto.getUser_pw())) {
				System.out.println(dto.getName() +"님 로그인에 성공했습니다.");
			} else {
				System.out.println("비밀번호가 다릅니다!");
			}
		}
		
	} // login
	
	
	
}	// class
