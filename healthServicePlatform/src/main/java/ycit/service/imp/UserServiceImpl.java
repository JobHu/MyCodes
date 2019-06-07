package ycit.service.imp;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.exception.UserException;
import ycit.mapper.IUserMapper;
import ycit.pojo.User;
import ycit.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService{
 
	
	@Autowired
	private IUserMapper userMapper;
	@Override
	public boolean addUser(User user,String confirmPwd) throws UserException {
	    String userCode = user.getUsercode();
	    String cpwd = DigestUtils.md5Hex(confirmPwd);
	    String pwd = DigestUtils.md5Hex(user.getPassword());
	    user.setPassword(pwd);
	    List<User> users = userMapper.queryUserByUserCode(userCode);
	    String phone = user.getPhone();
	    if(phone != null && !(phone.length()==11)){
	    	   throw new UserException("电话号码必须为11位,以1开头");
	    }
	    if(!cpwd.equals(user.getPassword())){
	    	throw new UserException("原始密码和确认密码要一致");
	    }
	    if(user != null &&users.size() ==1){
	    	throw new UserException("用户账户已经存在");  	
	    }else{
	    	//设置一下注册的时间
			 user.setLoginDate(new Date());
			int row = userMapper.addUser(user);
			return row==1?true:false;
	    }
		
	}
	@Override
	public User queryUserByuserCodeAndPwd(User user) {
		  String pwd = DigestUtils.md5Hex(user.getPassword());
		  
		List<User> users  = userMapper.queryUserByuserCodeAndPwd(user.getUsercode(),pwd);
		if(users != null && users.size() ==1){
			return users.get(0);
		}
		 return null;
	}

}
