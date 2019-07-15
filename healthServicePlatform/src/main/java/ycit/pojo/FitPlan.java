package ycit.pojo;
/**
 * 健身计划的制定
 * CREATE TABLE `fit_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '健身计划的id',
  `attention` varchar(255) DEFAULT NULL COMMENT '健身计划的目的',
  `strength` varchar(255) DEFAULT NULL COMMENT '运动的强度',
  `frequency` varchar(255) DEFAULT NULL COMMENT '运动的频率',
  `fixed_time` varchar(255) DEFAULT NULL COMMENT '每天固定的时间点',
  `m_id` int(11) DEFAULT NULL COMMENT '运动方法的ID',
  `method_name` varchar(255) DEFAULT NULL COMMENT '运动方法的名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 * @author hyg
 *
 */
public class FitPlan {
    private Integer id;//健身计划的ID

    private String attention;//健身计划的目的

    private String strength;//运动的强度

    private String frequency;//运动的频率

    private String fixedTime;//每天固定的时间点

    private Integer mId;//健身方法的Id 

    private String methodName;//健身计划方法的名称
    //用户的ID
    private Integer uId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention == null ? null : attention.trim();
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength == null ? null : strength.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getFixedTime() {
        return fixedTime;
    }

    public void setFixedTime(String fixedTime) {
        this.fixedTime = fixedTime == null ? null : fixedTime.trim();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
    
}