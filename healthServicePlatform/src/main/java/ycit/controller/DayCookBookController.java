package ycit.controller;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import ycit.pojo.DayCookBook;
import ycit.pojo.User;
import ycit.service.IDayCookBookService;

//每日食谱的控制类
@Controller
@RequestMapping("/dayCookBook")
public class DayCookBookController {
	
	@Autowired
	private IDayCookBookService dayCookBookService;
	
	//去到每日食谱的添加的页面
	@RequestMapping("/toAddCookBook")
	public String toAddDayCookBook(){
		return "/fruiteVegetables/add";
	}
	//每日食谱的添加的功能
	@RequestMapping("/addCookBook")
	public String addCookBook(HttpSession session,Model model,DayCookBook dayCookBook){
		
		User user = (User) session.getAttribute("myuser");
		Integer uId = user.getId();
		dayCookBook.setuId(uId);
		boolean sucFlag = dayCookBookService.insertCookBook(dayCookBook);
		 if (sucFlag) {
			return "redirect:/dayCookBook/queryAllCookBook/1";
		}
		return "/dayCookBook/toAddCookBook";
	}
	
	//查询所有人的所有的食谱
	@RequestMapping("/queryAllCookBook/{pageNo}")
	public String queryAllCookBook(@PathVariable("pageNo")Integer pageNo,Model model){
		
		 PageInfo<DayCookBook>  pageInfos = dayCookBookService.queryAllCookBook(pageNo);
		 model.addAttribute("pageInfos", pageInfos);
		return "/fruiteVegetables/index";
	}
	//查询所有的食谱通过早餐，中餐，晚餐的分类来查询
	@RequestMapping("/queryBookCookByHtmedType/{htmedType}/{pageNo}")
	public String queryBookCookByHtmedType(@PathVariable("htmedType")String htmedType,@PathVariable("pageNo")Integer pageNo,Model model){
		
		PageInfo<DayCookBook>  pageInfos = dayCookBookService.queryBookCookByHtmedType(htmedType,pageNo);
		 model.addAttribute("pageInfos", pageInfos);
		return "/fruiteVegetables/index1";
		
	}
	
	//导出所有的食谱的功能
	  @RequestMapping("/exportCookBook")
	 public void export(HttpServletResponse response) throws Exception{
        InputStream is=dayCookBookService.getInputStream();        
        response.setContentType("application/vnd.ms-excel");       
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");       
        ServletOutputStream output = response.getOutputStream();       
        IOUtils.copy(is,output);
    }
	//删除食谱通过id
	  @RequestMapping("/deleteDayCookBookById/{id}")
	  public String deleteDayCookBookById(@PathVariable("id")Integer id){
		  boolean sucFlag = dayCookBookService.deleteDayCookBookById(id);
		  if (sucFlag) {
			return "redirect:/dayCookBook/queryAllCookBook/1";
		}
		return null;
	  }

}
