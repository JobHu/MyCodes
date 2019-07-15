package ycit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.AerobicMovement;
import ycit.pojo.User;
import ycit.service.IAerobicMovementService;

/**
 * 有氧运动的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/aerobicMovement")
public class AerobicMovementController {
	
	@Autowired
	private IAerobicMovementService aerobicMovementService;
	//查询有氧运动的所有的数据
	@RequestMapping("/queryAerobicMovement/{pageNo}")
	public String queryAerobicMovement(HttpSession session,@PathVariable("pageNo")Integer pageNo,Model model){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		Page page = new Page();
		page.setPageNum(pageNo);
		page.setUserId(id);
		
		PageInfo<AerobicMovement> pageInfos = aerobicMovementService.queryAerobicMovement(page);
		model.addAttribute("pageInfos", pageInfos);
		
		return "/aerobicMovement/index";	
	}
	//去到添加有氧运动数据的页面
	@RequestMapping("/toAddAerobicMovement")
	public String toAddAerobicMovement(){
		return "/aerobicMovement/add";
	}
	@RequestMapping("/addAerobicMovement")
	public String addAerobicMovement(AerobicMovement aerobicMovement,HttpSession session){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		aerobicMovement.setuId(id);
		boolean sucFlag = aerobicMovementService.insertAerobicMovement(aerobicMovement);
		if (sucFlag) {
			return "redirect:/aerobicMovement/queryAerobicMovement/1";
		}
		return "redirect:/aerobicMovement/toAddAerobicMovement";
	}
	//根据ID删除数据
	@RequestMapping("/deleteAerobicMovement/{id}")
	public String deleteAerobicMovement(@PathVariable("id")Integer id){
		boolean sucFlag = aerobicMovementService.deleteAerobicMovement(id);
		if (sucFlag) {
			return "redirect:/aerobicMovement/queryAerobicMovement/1";
		}
		return "redirect:/aerobicMovement/queryAerobicMovement/1";
	}

}
