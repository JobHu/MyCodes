package ycit.controller;

import java.io.InputStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ycit.constant.DayBloodPressureConstatnt;
import ycit.dto.HourPressureDTO;
import ycit.excel.HourBloodPressure;
import ycit.excel.ImportExcelUtil;
import ycit.pojo.DayPressure;
import ycit.pojo.HourPressure;
import ycit.pojo.User;
import ycit.service.IDayPressureService;
import ycit.service.IHourPressureService;

//血压的控制器
@Controller
@RequestMapping("/bloodPressure")
public class PressureController {
	
	@Autowired
	private IHourPressureService hourPressureService;
	
	@Autowired
	private IDayPressureService dayPressureService;
	
	
	//查询某一天的血压的具体的变化，就是一天24个小时的血压的变化值
	@RequestMapping("/bloodPressureHoures/{dayTime}")
	@ResponseBody
	public Map<String, Object> queryTwentyFourPressure(@PathVariable("dayTime")String dayTime,HttpSession session,HourPressureDTO hourPressureDTO){
		
		User user = (User) session.getAttribute("myuser");
		Integer uId = user.getId();
		//设置用户Id
		//System.out.println(dayTime);
		hourPressureDTO.setuId(uId);
		//日期类型和String类型之间的转换
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    Date convertDayTime = null;
		try {
			convertDayTime = sf.parse(dayTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hourPressureDTO.setDayTime(convertDayTime);
		Map<String, Object> map = new HashMap<>();
		//查询一天24小时的血压的变化
	    List<HourPressure> hourPressures = hourPressureService.queryTwentyFourPressure(hourPressureDTO);
		map.put("hourPressures", hourPressures);
		return map;	
	}
	//添加每天24个小时的血压值
	@RequestMapping("/addBloodPressureHoures")
	public String addTwentyFourPressure(HttpServletRequest request,HttpSession session) throws Exception{
		 //获得用户的ID
		 User user = (User) session.getAttribute("myuser");
		 Integer uId = user.getId();
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;        
	     InputStream in =null;  
	     List<List<Object>> listob = null;  
	     MultipartFile file = multipartRequest.getFile("upfile");  
	    
	     if(file.isEmpty()){  
	         throw new Exception("文件不存在！");  
	     }  
	     in = file.getInputStream();  
	     listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
	     in.close();  
	    
	    //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	    /* for (int i = 0; i < listob.size(); i++) {  
	         List<Object> lo = listob.get(i);  
	         HourBloodPressure hourBloodPressure = new HourBloodPressure();  
	         hourBloodPressure.setEachHour(String.valueOf(lo.get(0))); 
	         hourBloodPressure.setBloodPressureHour(Double.parseDouble(String.valueOf(lo.get(1))));  
	         hourBloodPressure.setReason(String.valueOf(lo.get(2)));      
	         System.out.println("打印信息-->"+hourBloodPressure.toString()); 
	      }*/
	     //保存到数据库的操作
	     //1.先将得到的数据的血压值的平均值求出放到dayPressure中，在自动创建一个天数日期
		// 定义一个变量用来存放平均的血压值
		Double bloodPressureAverage = 0.0;
		
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			HourBloodPressure hourBloodPressure = new HourBloodPressure();
			hourBloodPressure.setBloodPressureHour(Double.parseDouble(String.valueOf(lo.get(1))));
			// 这个是获得总的血压值
			bloodPressureAverage += hourBloodPressure.getBloodPressureHour();
		}
		bloodPressureAverage = bloodPressureAverage/24;// 算出平均
		// 这边是DayHourPressure的插入
		DayPressure dayPressure = new DayPressure();
		dayPressure.setDayPressure(bloodPressureAverage);
		Date newDayTime = new Date();// 记住这个值
		dayPressure.setDayTime(newDayTime);
		Long tag  = newDayTime.getTime();
		dayPressure.setuId(uId);
		dayPressure.setTag(tag);
		
		// 这个result根据分析得出结果
		if (bloodPressureAverage < DayBloodPressureConstatnt.LOWDAYBLOODPRESSURE) {
			dayPressure.setDayResult(DayBloodPressureConstatnt.MSG1);
		} else if (bloodPressureAverage > DayBloodPressureConstatnt.HIGHDAYBLOODPRESSURE) {
			dayPressure.setDayResult(DayBloodPressureConstatnt.MSG2);
		} else {
			dayPressure.setDayResult(DayBloodPressureConstatnt.MSG3);
		}
		boolean sucFlag2 = dayPressureService.addDayBloodPressure(dayPressure);

	    // 2.HourPressure插入的开始
		//这个ID怎么来,根据时间点来查dayPressure得到
		 
          DayPressure dayPressure2 = dayPressureService.queryDayBloodPressureByTag(tag);
          Integer dayId = dayPressure2.getId();
	     for (int i = 0; i < listob.size(); i++) {  
	         List<Object> lo = listob.get(i);  
	         HourBloodPressure hourBloodPressure = new HourBloodPressure();  
	         hourBloodPressure.setEachHour(String.valueOf(lo.get(0))); 
	         hourBloodPressure.setBloodPressureHour(Double.parseDouble(String.valueOf(lo.get(1))));
	         hourBloodPressure.setReason(String.valueOf(lo.get(2)));
	         
	         //这边是HourPressure的插入
	         HourPressure hourPressure = new HourPressure();
	         hourPressure.setEachHour(hourBloodPressure.getEachHour());
	         hourPressure.setBloodPressureHour(hourBloodPressure.getBloodPressureHour());
	         hourPressure.setReason(hourBloodPressure.getReason());
	         hourPressure.setDayId(dayId);
	         boolean sucFlag1 = hourPressureService.addHourBloodPressure(hourPressure);
	      }
	     
       
	     return "/bloodPressure/index";
}
}
