package ycit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import ycit.pojo.FitMethod;
import ycit.service.IFitMethodService;

/**
 * 健身方法的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/fitMethod")
public class FitMethodController {
	
	@Autowired
	private IFitMethodService fitMethodService;
	
	
	//查询所有的健身方法
	@RequestMapping("/queryAllFitMethod/{pageNo}")
	public String queryAllFitMethod(FitMethod fitMethod,@PathVariable("pageNo")Integer pageNo,Model model){
		
		PageInfo<FitMethod> pageInfos  = fitMethodService.queryAllFitMethod(fitMethod,pageNo);
		
		model.addAttribute("pageInfos", pageInfos);
		
		return "/fitMethod/index";
	}
	//查询健身方法根据名称
	@RequestMapping("/queryFitMethodByName")
	public String queryFitMethodByName(FitMethod fitMethod,@RequestParam("pageNo")Integer pageNo,Model model){
		
         PageInfo<FitMethod> pageInfos  = fitMethodService.queryAllFitMethod(fitMethod,pageNo);
		
		model.addAttribute("pageInfos", pageInfos);
		
		return "/fitMethod/queryByName";
		
	}
	
	//去到添加方法的界面
	@RequestMapping("/toAddFitMethod")
	public String toAddFitMethod(){
		return "/fitMethod/add";
	}
	
	//真正的添加方法
	@RequestMapping("/addFitMethod")
	public String addFitMethod(FitMethod fitMethod){
		
		boolean sucFlag = fitMethodService.insertFitMethod(fitMethod);
		if(sucFlag){
			return "redirect:/fitMethod/queryAllFitMethod/1";
		}
		return "/fitMethod/add";
	}
	//根据ID查明细
	@RequestMapping("/queryDetailById/{id}")
	public String queryDetailById(@PathVariable("id")Integer id,Model model){
		
		FitMethod fitMethod = fitMethodService.queryDetailById(id);
		model.addAttribute("fitMethod", fitMethod);
		return "/fitMethod/detail";	
	}
	
}
