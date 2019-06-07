package ycit.pojo;

import java.util.Date;

/**
 * CREATE TABLE `sleep` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sleep_time` double(11,2) DEFAULT NULL COMMENT '睡眠时间',
  `sleep_quantity` int(11) DEFAULT NULL COMMENT '用100分制度来标志',
  `f_id` int(11) DEFAULT NULL COMMENT '因素的Id',
  `u_id` int(11) DEFAULT NULL COMMENT '用户的Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
//睡眠质量表
public class Sleep {
    private Integer id;

    private Double sleepTime;//睡眠时间

    private Integer sleepQuantity;//睡眠质量

    private Integer fId;//因素的ID

    private Integer uId;//用户的ID
    
    private  Date lastTime;//最近的时间
    
    private Factor factor;//因素的对象
    
    private State state;//状态的对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Double sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Integer getSleepQuantity() {
        return sleepQuantity;
    }

    public void setSleepQuantity(Integer sleepQuantity) {
        this.sleepQuantity = sleepQuantity;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
    
}