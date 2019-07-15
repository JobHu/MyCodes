package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * CREATE TABLE `blood_sugar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '血糖主键',
  `breaker_half` double(11,2) DEFAULT NULL COMMENT '早餐前半个小时',
  `break_two` double(11,2) DEFAULT NULL COMMENT '早餐后两个小时',
  `noon_half` double(11,2) DEFAULT NULL COMMENT '午饭前半个小时',
  `noon_two` double(11,2) DEFAULT NULL COMMENT '午饭后2个小时',
  `dinner_half` double(11,2) DEFAULT NULL COMMENT '晚饭前半个小时',
  `dinner_two` double(11,2) DEFAULT NULL COMMENT '晚饭后两个小时',
  `bed_time` double(11,2) DEFAULT NULL COMMENT '睡前的',
  `day_time` date DEFAULT NULL COMMENT '具体的一天',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class BloodSugar {
    private Long id;//血糖的ID

    private Double breakerHalf;//早餐前半个小时

    private Double breakTwo;//早餐后两个小时

    private Double noonHalf;//午餐前半个小时

    private Double noonTwo;//午餐后两个小时

    private Double dinnerHalf;//晚餐前半个小时

    private Double dinnerTwo;//晚餐后两个小时

    private Double bedTime;//睡前
     @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dayTime;//具体的一天
    
    private Integer uId;//用户ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBreakerHalf() {
        return breakerHalf;
    }

    public void setBreakerHalf(Double breakerHalf) {
        this.breakerHalf = breakerHalf;
    }

    public Double getBreakTwo() {
        return breakTwo;
    }

    public void setBreakTwo(Double breakTwo) {
        this.breakTwo = breakTwo;
    }

    public Double getNoonHalf() {
        return noonHalf;
    }

    public void setNoonHalf(Double noonHalf) {
        this.noonHalf = noonHalf;
    }

    public Double getNoonTwo() {
        return noonTwo;
    }

    public void setNoonTwo(Double noonTwo) {
        this.noonTwo = noonTwo;
    }

    public Double getDinnerHalf() {
        return dinnerHalf;
    }

    public void setDinnerHalf(Double dinnerHalf) {
        this.dinnerHalf = dinnerHalf;
    }

    public Double getDinnerTwo() {
        return dinnerTwo;
    }

    public void setDinnerTwo(Double dinnerTwo) {
        this.dinnerTwo = dinnerTwo;
    }

    public Double getBedTime() {
        return bedTime;
    }

    public void setBedTime(Double bedTime) {
        this.bedTime = bedTime;
    }

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