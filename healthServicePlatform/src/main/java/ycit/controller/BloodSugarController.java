package ycit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.BloodSugar;
import ycit.pojo.User;
import ycit.service.IBloodSugarService;

//血糖的控制器
@Controller
@RequestMapping("/bloodSugar")
public class BloodSugarController {
     
	@Autowired
	private IBloodSugarService bloodSugarService;
	//查询所有的血糖值，根据分页的功能来查询
	@RequestMapping("/queryAllBloodSugar/{pageNo}")
	public String queryAllBloodSugars(@PathVariable("pageNo")Integer pageNo,HttpSession session,Model model){
		
		//先获取用户的信息
		User user = (User) session.getAttribute("myuser");
		Integer uId = user.getId();
		Page page = new Page();
		page.setPageNum(pageNo);
		page.setUserId(uId);
		PageInfo<BloodSugar> pageInfos = bloodSugarService.queryAllBloodSugars(page);
		model.addAttribute("pageInfos", pageInfos);
		return "/bloodSugar/index";
	}
	//去到添加的页面
	@RequestMapping("/toAddBloodSugar")
	public String toAddBloodSugar(){
		return "/bloodSugar/add";
	}
	//真正的添加的功能
	@RequestMapping("/addBloodSugar")
	public String addBloodSugar(BloodSugar bloodSugar,HttpSession session){
		         //先获取用户的信息
				User user = (User) session.getAttribute("myuser");
				Integer uId = user.getId();
				
				bloodSugar.setuId(uId);
				
				boolean  sucFlag = bloodSugarService.addBloodSugar(bloodSugar);
				
				if (sucFlag) {
					return "redirect:/bloodSugar/queryAllBloodSugar/1";
				}
		       return "/bloodSugar/add";
	}
	//去到编辑的页面
	@RequestMapping("/toEditBloodSugar/{id}")
	public String toEditBloodSugar(@PathVariable("id")Integer id,Model model){
		
		//通过ID查询到每一条编辑的血糖的数据
		BloodSugar bloodSugar = bloodSugarService.queryBloodSugarById(id);
		model.addAttribute("bloodSugar", bloodSugar);
		return "/bloodSugar/edit";
	}
	
	//真正的编辑
	@RequestMapping("/editBloodSugar")
	public String editBloodSugar(BloodSugar bloodSugar,@RequestParam("id")Long id){
		
		 bloodSugar.setId(id);
		
		boolean sucFlag = bloodSugarService.updateBloodSugar(bloodSugar);
		if (sucFlag) {
			return "redirect:/bloodSugar/queryAllBloodSugar/1";
		}
		
		return "/toEditBloodSugar/"+id;
	}
	//查询一条具体的血糖根据时间
	@RequestMapping("/queryBloodSugarByDayTime")
	public String queryBloodSugarByDayTime(@RequestParam("dayTime") String dayTime,Model model){
		
		//System.out.println(dayTime);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date = sf.parse(dayTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println(date);
		 List<BloodSugar> bloodSugars = bloodSugarService.queryBloodSugarByDayTime(date);
		 model.addAttribute("bloodSugars", bloodSugars);
		return  "/bloodSugar/index2";
	}
	
}
