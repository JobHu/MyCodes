package ycit.pojo;

import java.util.Date;

/**
 * 
 * @author hyg
 *CREATE TABLE `physical_examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `weight` double(11,2) DEFAULT NULL COMMENT '体重',
  `blood_pressure` double(11,2) DEFAULT NULL COMMENT '血压',
  `blood_sugar` double(11,2) DEFAULT NULL COMMENT '血糖',
  `white_red_proportion` double(11,2) DEFAULT NULL COMMENT '白红细胞的比例',
  `body_fat` double(11,2) DEFAULT NULL COMMENT '体脂',
  `electrocardiogram` varchar(255) DEFAULT NULL COMMENT '心电图',
  `liver_function` varchar(255) DEFAULT NULL COMMENT '肝功能',
  `chest_x_rays` varchar(255) DEFAULT NULL COMMENT '胸透',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
public class PhysicalExamination {
    private Long id;//主键ID

    private Double weight;//体重

    private Double bloodPressure;//血压
    
    private Double bloodPressureTwo;//舒张压

    private Double bloodSugar;//血糖

    private Double whiteRedProportion;//白细胞红细胞的比例

    private Double bodyFat;//体脂

    private String electrocardiogram;//心电图

    private String liverFunction;//肝功能

    private String chestXRays;//胸透

    private Integer age;//年龄
    
    private Date physicalTime;//体检的时间
    
    private  User user;//和user表建立联系

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Double getWhiteRedProportion() {
        return whiteRedProportion;
    }

    public void setWhiteRedProportion(Double whiteRedProportion) {
        this.whiteRedProportion = whiteRedProportion;
    }

    public Double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Double bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getElectrocardiogram() {
        return electrocardiogram;
    }

    public void setElectrocardiogram(String electrocardiogram) {
        this.electrocardiogram = electrocardiogram == null ? null : electrocardiogram.trim();
    }

    public String getLiverFunction() {
        return liverFunction;
    }

    public void setLiverFunction(String liverFunction) {
        this.liverFunction = liverFunction == null ? null : liverFunction.trim();
    }

    public String getChestXRays() {
        return chestXRays;
    }

    public void setChestXRays(String chestXRays) {
        this.chestXRays = chestXRays == null ? null : chestXRays.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	public Date getPhysicalTime() {
		return physicalTime;
	}

	public void setPhysicalTime(Date physicalTime) {
		this.physicalTime = physicalTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBloodPressureTwo() {
		return bloodPressureTwo;
	}

	public void setBloodPressureTwo(Double bloodPressureTwo) {
		this.bloodPressureTwo = bloodPressureTwo;
	}
	
	
    
    
}