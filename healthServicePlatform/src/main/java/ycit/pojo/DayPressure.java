package ycit.pojo;

import java.util.Date;
/**
 * CREATE TABLE `day_pressure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'day的Id',
  `day_pressure` double(11,2) DEFAULT NULL COMMENT '每天的血压值',
  `day_result` varchar(500) DEFAULT NULL,
  `day_time` date DEFAULT NULL COMMENT '具体的哪一天',
  `month_id` int(11) DEFAULT NULL COMMENT '月份的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class DayPressure {
    private Integer id;//day的主键

    private Double dayPressure;//每天的血压值

    private String dayResult;//分析的结果

    private Date dayTime;//每天的时间
    
    private Integer monthId;//月份的Id
    
    private Integer uId;//用户的Id
    
    private Long tag;//标记
    
    private HourPressure hourPressure;//注入每天24小时的对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDayPressure() {
        return dayPressure;
    }

    public void setDayPressure(Double dayPressure) {
        this.dayPressure = dayPressure;
    }

    public String getDayResult() {
        return dayResult;
    }

    public void setDayResult(String dayResult) {
        this.dayResult = dayResult == null ? null : dayResult.trim();
    }

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) {
        this.dayTime = dayTime;
    }

	public Integer getMonthId() {
		return monthId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public HourPressure getHourPressure() {
		return hourPressure;
	}

	public void setHourPressure(HourPressure hourPressure) {
		this.hourPressure = hourPressure;
	}

	public Long getTag() {
		return tag;
	}

	public void setTag(Long tag) {
		this.tag = tag;
	}
    
}