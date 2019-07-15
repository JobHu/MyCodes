package ycit.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.PhysicalExamination;
import ycit.pojo.User;
import ycit.service.IPhysicalExaminationService;

/**
 * 个人体检数据的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/physicalExamination")
public class PhysicalExaminationController {
	
	@Autowired
	private IPhysicalExaminationService physicalExaminationService;
	
	//查询个人体检的所有的数据,根据个人的用户的ID
	@RequestMapping("/personPhysicalExamination/{pageNum}")
	public String queryAllPhysicalExamination(@PathVariable("pageNum")Integer pageNum,HttpSession session,Model model){
		   
		    User user = (User) session.getAttribute("myuser");
		    Integer id =  user.getId();   
		    Page page = new Page();
		    page.setPageNum(pageNum);
		    page.setUserId(id);
			PageInfo<PhysicalExamination> allPhysicalExamination = 
					physicalExaminationService.queryAllPhysicalExamination(page);
			model.addAttribute("allPhysicalExamination", allPhysicalExamination);
			return "physicalExamination/index";
	}
	//个人每次体检数据的录入的页面
	@RequestMapping("/toAddPhysicalExamination")
	public String toAddPhysicalExamination(){
		
		return "physicalExamination/add";
	}
	//真正的体检数据的录入的功能
	@RequestMapping("/addPhysicalExamintion")
	public String addPhysicalExamination(PhysicalExamination physicalExamination,HttpSession session){
		
		User user = (User) session.getAttribute("myuser");
	    //Integer id =  user.getId(); 
		physicalExamination.setUser(user);
		
	    boolean sucFlag = physicalExaminationService.insertPhysicalExamination(physicalExamination);
	    if (sucFlag) {
			return "forward:/physicalExamination/personPhysicalExamination/1";
		}
		return "forward:/physicalExamination/toAddPhysicalExamination";
	}
	//删除某一次的体检的信息根据id
	@RequestMapping("/deletePhysicalExamination/{id}")
	public String deletePhysicalExamination(@PathVariable("id")Integer id){
		
		boolean sucFlag = physicalExaminationService.deletePhysicalExamination(id);
		if (sucFlag) {
			return "forward:/physicalExamination/personPhysicalExamination/1";
		}else{
			return "forward:/physicalExamination/personPhysicalExamination/1";	
		}
	}
	//体检数据的分析功能
	@RequestMapping("/physicalExaminationAnysical")
	@ResponseBody
	public Map<String, Object> queryMyPhyscialExamination(HttpSession session){
		
		Map<String, Object> map = new HashMap<>();
		//获取Id
		User user = (User) session.getAttribute("myuser");
	    Integer id =  user.getId();
	    //根据Id获取体检的数据
	    
	   List<PhysicalExamination> allPhysicalExamination =  physicalExaminationService.queryExaminationByUserId(id);
		map.put("allPhysicalExamination", allPhysicalExamination);
		return map;
	}
}
