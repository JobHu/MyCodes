package ycit.service;

import ycit.exception.UserException;
import ycit.pojo.User;

public interface IUserService {

	boolean addUser(User user,String confirmPwd) throws UserException;

	User queryUserByuserCodeAndPwd(User user);

}
