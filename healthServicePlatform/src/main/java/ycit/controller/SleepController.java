package ycit.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ycit.dto.SleepAndFactorAndState;
import ycit.pojo.Factor;
import ycit.pojo.Sleep;
import ycit.pojo.User;
import ycit.pojo.State;
import ycit.service.IFactorService;
import ycit.service.ISleepService;
import ycit.service.IStateService;

@Controller
@RequestMapping("/sleep")
public class SleepController {
	
	@Autowired
	private ISleepService sleepService;
	@Autowired
	private IFactorService factorService;
	@Autowired
	private IStateService stateService;
      //查询所有的的睡眠因素状态的最近七天的信息 
	@RequestMapping("/query")
	public String queryLastSevenDaySleep(HttpSession session,Model model){
		
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
	    List<Sleep> sleeps =	sleepService.queryLastSevenDaySleep(id);
	    model.addAttribute("sleeps", sleeps);
		return "sleepQuantity/index";	
	}
	//查看最近七天的睡眠质量，返回json数据格式
	@RequestMapping("/queryByJson")
	@ResponseBody
	public Map<String, Object> queryLastSevenDaysSleep(HttpSession session){
		
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		
		Map<String, Object> map = new HashMap<>();
		
		List<Sleep> sleeps = sleepService.queryLastSevenDaySleep(id);
		
		map.put("sleeps", sleeps);
		
		return map;	
	}
	//去到添加信息的页面
	@RequestMapping("/toAddSleep")
	public String toAddSleep(){
		return "sleepQuantity/add";
	}
	//真正的添加睡眠因素状态的页面
	@RequestMapping("/addSleep")
	public String addSleep(SleepAndFactorAndState sleepAndFactorAndState,HttpSession session
			,Sleep sleep,State state,Factor factor){
		User user = (User) session.getAttribute("myuser");
		Integer id = user.getId();
		//1.先添加factor
		boolean sucFlag = factorService.addFactor(sleepAndFactorAndState,factor);
		//2.再添加sleep
		//先查询f_id
		 Factor factor2 = factorService.selectFactorByName(sleepAndFactorAndState.getName());
		 Integer fId = factor2.getId();
		boolean sucFlag1 = sleepService.addSleep(sleepAndFactorAndState,sleep,id,fId);
		//3.再添加state
		//先查询s_id
		Sleep sleep2 = sleepService.selectSleepByfId(fId);
		Integer sleepId = sleep2.getId();
		boolean sucFlag2 = stateService.addState(sleepAndFactorAndState,sleepId,state);
		return "forward:/sleep/query";
	}
	
}
