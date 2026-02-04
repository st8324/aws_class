package kr.hi.auth.dao;

import org.apache.ibatis.annotations.Param;

import kr.hi.auth.domain.UserDTO;

public interface UserDAO {

	boolean insertUser(@Param("user") UserDTO newUser);

}
