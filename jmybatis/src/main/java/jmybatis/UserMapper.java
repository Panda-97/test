package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	// 리턴타입, 메소드명, 매개변수
	
	public ArrayList<UserDTO> getUser();
	
	public void insertUser(UserDTO userDTO);
	
	public void updateUser(@Param("name") String name, @Param("user_id") String user_id);
	
	public void deleteUser(String user_id);
	
	public void loginCh(String user_id);
	
	public UserDTO login(String user_id, String user_pw);
}
