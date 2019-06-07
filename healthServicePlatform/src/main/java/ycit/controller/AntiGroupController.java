package ycit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.AntiGroup;
import ycit.pojo.User;
import ycit.service.IAntiGroupService;

/**
 * 抗组运动的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/antiGroup")
public class AntiGroupController {
	
	@Autowired
	private IAntiGroupService antiGroupService;
	//查询所有的抗组运动的数据根据分页的功能
	@RequestMapping("/queryAllAntiGroup/{pageNO}")
	public String queryAllAntiGroup(HttpSession session,@PathVariable("pageNO")Integer pageNo,Model model){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		Page page = new Page();
		page.setPageNum(pageNo);
		page.setUserId(id);
		PageInfo<AntiGroup> pageInfos = antiGroupService.queryAllAntiGroup(page);
		model.addAttribute("pageInfos", pageInfos);
		return "/fitRecord/index";
	}
	//去到录入抗组运动数据的界面
	@RequestMapping("/toAddAntiGroup")
	public String toAddAntiGroup(){	
		return  "/fitRecord/add";
	}
	//真正的添加
	@RequestMapping("/addAntiGroup")
	public String addAntiGroup(AntiGroup antiGroup,HttpSession session){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		antiGroup.setuId(id);
		boolean sucFlag = antiGroupService.insertAntiGroup(antiGroup);
		if (sucFlag) {
			return "redirect:/antiGroup/queryAllAntiGroup/1";
		}
		return "/antiGroup/toAddAntiGroup";
	}
	
	//删除抗组运动的一条记录
	@RequestMapping("/deleteAntiGroup/{id}")
	public String deleteAntiGroup(@PathVariable("id")Integer id){
		
		boolean sucFlag = antiGroupService.deleteAntiGroup(id);
		
		if (sucFlag) {
			return "redirect:/antiGroup/queryAllAntiGroup/1";
		}
		return "redirect:/antiGroup/queryAllAntiGroup/1";
		
	}
	

}
