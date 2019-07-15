package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 抗组运动的实体类
 * CREATE TABLE `anti_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '抗组的主键ID',
  `training_equipment` varchar(255) DEFAULT NULL COMMENT '锻炼器材',
  `count` int(11) DEFAULT NULL COMMENT '次数',
  `group` int(11) DEFAULT NULL COMMENT '组数',
  `weight` double(11,2) DEFAULT NULL COMMENT '重量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class AntiGroup {
    private Integer id;//抗组主键的ID

    private String trainingEquipment;//锻炼的器材

    private Integer count;//次数

    private Integer antiGroup;//组数

    private Double weight;//重量

    private String remark;//备注
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建的时间
    
    private Integer uId;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainingEquipment() {
        return trainingEquipment;
    }

    public void setTrainingEquipment(String trainingEquipment) {
        this.trainingEquipment = trainingEquipment == null ? null : trainingEquipment.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

   
    public Integer getAntiGroup() {
		return antiGroup;
	}

	public void setAntiGroup(Integer antiGroup) {
		this.antiGroup = antiGroup;
	}

	public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
    
}