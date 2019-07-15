package ycit.controller;

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
import ycit.pojo.FitMethod;
import ycit.pojo.FitPlan;
import ycit.pojo.User;
import ycit.service.IFitMethodService;
import ycit.service.IFitPlanService;

/**
 * 个人健身计划的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/fitPlan")
public class FitPlanController {
	
	@Autowired
	private IFitPlanService fitPlanService;
	
	@Autowired
	private IFitMethodService fitMethodService;
	
	//查看个人的健身计划
	@RequestMapping("/queryFitPlan/{pageNo}")
	public String queryFitPlan(@PathVariable("pageNo")Integer pageNo,HttpSession session,Model model){	
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		Page page = new Page();
		page.setPageNum(pageNo);
		page.setUserId(id);
		//这里的注意点
		//这里的方法是从健身方法中的方法中得来的
		 PageInfo<FitPlan> pageInfos = fitPlanService.queryFitPlan(page);
		 model.addAttribute("pageInfos", pageInfos);
		 return "/fitPlan/index";
	}
	//去到添加的页面
	@RequestMapping("/toAddFitPlan")
	public String toAddFitPlan(Model model){
		//这里面有个方法从健身方法中查出所有的健身方法
		
		  List<FitMethod> fitMethods =fitMethodService.queryAllMethod();
		  model.addAttribute("fitMethods", fitMethods);
		  return "/fitPlan/add";	
	}
	
	//真正的添加
	@RequestMapping("/addFitPlan")
	public String addFitPlan(FitPlan fitPlan,HttpSession session){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		fitPlan.setuId(id);
		boolean sucFlag = fitPlanService.insertFitPlan(fitPlan);
		if (sucFlag) {
			return "redirect:/fitPlan/queryFitPlan/1";
		}
		return "redirect:/fitPlan/toAddFitPlan";		
	}
	//删除的功能
	@RequestMapping("/deleteFitPlan/{id}")
	public String deleteFitPlan(@PathVariable("id")Integer id){
		
		boolean sucFlag = fitPlanService.deleteFitPlan(id);
		if(sucFlag){
			return "redirect:/fitPlan/queryFitPlan/1";
		}
		return "redirect:/fitPlan/queryFitPlan/1";
	}
	
	//去到编辑的页面
	@RequestMapping("/toEditFitPlan/{id}")
	public String toEditFitPlan(@PathVariable("id")Integer id,Model model){
		
		FitPlan fitPlan =  fitPlanService.selectFitPlanById(id);
		model.addAttribute("fitPlan", fitPlan);
		return "/fitPlan/edit";
	}
	//真正的编辑
	@RequestMapping("/editFitPlan")
	public String editFitPlan(FitPlan fitPlan){
		boolean sucFlag =  fitPlanService.updateFitPlan(fitPlan);
		if (sucFlag) {
			return "redirect:/fitPlan/queryFitPlan/1";
		}
		return "redirect:/fitPlan/queryFitPlan/1";		
	}
	//通过健身方法的名称来查询健身的计划
	@RequestMapping("/queryFitMethodByName")
	public String queryFitPlanByMethodName(@RequestParam("methodName") String methodName,Model model){
		 List<FitPlan> fitPlan = fitPlanService.queryFitPlanByMethodName(methodName);
		 model.addAttribute("fitPlan", fitPlan);
		return "/fitPlan/index2";
		
	}

}
