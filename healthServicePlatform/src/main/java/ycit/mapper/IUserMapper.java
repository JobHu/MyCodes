package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.User;

public interface IUserMapper {
    //添加一个用户
	int addUser(User user);
	//查询user通过账户
	List<User> queryUserByUserCode(@Param("userCode")String userCode);
	List<User> queryUserByuserCodeAndPwd(@Param("usercode")String usercode, @Param("pwd")String pwd);

}
