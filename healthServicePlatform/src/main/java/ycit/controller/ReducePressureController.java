package ycit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import ycit.pojo.ReducePressure;
import ycit.service.IReducePressureService;

/**
 * 抗压减压的controller
 * @author hyg
 *
 */
@Controller
@RequestMapping("/reducePressure")
public class ReducePressureController {
	
	@Autowired
	private IReducePressureService reducePressureService;
	
	//去到添加的页面
     @RequestMapping("/toAddReducePressure")
     public String toAddReducePressure(){
    	 
    	 return "/reducePressure/add";
     }
	//压力方法的添加
     @RequestMapping("/addReducePressure")
     public String addReducePressure(ReducePressure reducePressure){
    	 boolean sucFlag = reducePressureService.addReducePressure(reducePressure);
    	 if (sucFlag) {
			return "redirect:/reducePressure/queryAllReducePressure/1";
		}
    	 return "";
     }
	
	
	//压力方法的查询
     @RequestMapping("/queryAllReducePressure/{pageNo}")
     public String queryAllReducePressure(@PathVariable("pageNo")Integer pageNo,Model model){
    	 
    	 PageInfo<ReducePressure> pageInfos = reducePressureService.queryAllReducePressure(pageNo);
    	 model.addAttribute("pageInfos", pageInfos);
    	 return "/reducePressure/index";
     }
	
	
	//压力方法的删除
     @RequestMapping("/deleteReducePressure/{id}")
     public String deleteReducePressure(@PathVariable("id")Integer id){
    	 
    	 boolean sucFlag = reducePressureService.deleteReducePressure(id);
    	 if (sucFlag) {
			return "redirect:/reducePressure/queryAllReducePressure/1";
		}
		return "";
    	 
     }
	
	
}
