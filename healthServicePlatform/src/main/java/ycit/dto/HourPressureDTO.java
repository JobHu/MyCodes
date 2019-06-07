package ycit.dto;
//每天的血压的数据的传输对象

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HourPressureDTO {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dayTime;
	
	private Integer uId;

	public Date getDayTime() {
		return dayTime;
	}
    
	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
	

}
