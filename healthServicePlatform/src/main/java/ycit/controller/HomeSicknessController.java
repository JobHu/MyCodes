package ycit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ycit.dto.MemHomeSickness;
import ycit.pojo.HomeSickness;
import ycit.pojo.Member;
import ycit.pojo.User;
import ycit.service.IHomeSicknessService;
import ycit.service.IMemberService;

//家族遗传病史的控制器
@Controller
@RequestMapping("/homesickness")
public class HomeSicknessController {
    
	@Autowired
	private IHomeSicknessService homeSicknessService;
	@Autowired
	private IMemberService memberService;
	//查询家族遗传病
	@RequestMapping("/queryHomeSickness")
	public String queryHomeSickness(Model model,HttpSession session){
		  User user = (User) session.getAttribute("myuser");
		  Integer id = user.getId();
	      List<HomeSickness> allHomeSickness = homeSicknessService.queryHomeSickness(id);
		  model.addAttribute("allHomeSickness", allHomeSickness);
		  return "homeSickness/index";
	}
	//去到添加疾病的界面
	@RequestMapping("/toAddHomeSickness")
	public String toAddHomeSickness(){
		
		return "homeSickness/add";
	}
	//添加疾病的页面
	@RequestMapping("/addHomeSickness")
	public String addHomeSickness(MemHomeSickness memHomeSickness,HomeSickness homeSickness,Member member,HttpSession session){
		User user = (User) session.getAttribute("myuser");
		memHomeSickness.setuId(user.getId());
		 //家族成员的添加
		boolean sucFlag1 =   memberService.insertMember(memHomeSickness,member);
		//查询特定的名称的member
		Member  m1 = memberService.selectMemberByName(memHomeSickness.getmName());
		//疾病的添加
	   boolean sucFlag = homeSicknessService.insertHomeSickness(memHomeSickness,homeSickness,m1);
	 
		return "forward:/homesickness/queryHomeSickness";
	}
	//删除指定的家族的遗传病
	@RequestMapping("/deleteHomeSickness/{id}")
	public String deleteHomeSickness(@PathVariable("id")Integer id){
		
		//首先删除member表的数据
	      boolean  sucFlag = 	memberService.deleteMember(id);
		//接着删除homeSickness表的数据
	      boolean sucFlag1 = homeSicknessService.deleteHomeSickness(id);
		return "forward:/homesickness/queryHomeSickness";
		
	}
}
