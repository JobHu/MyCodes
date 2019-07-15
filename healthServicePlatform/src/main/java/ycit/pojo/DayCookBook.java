package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
//每日食谱的实体类
/**
 * CREATE TABLE `day_cook_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '每日食谱的主键',
  `htmed_type` varchar(11) DEFAULT NULL COMMENT '每日食谱的种类，早中晚',
  `staple_food` varchar(255) DEFAULT NULL COMMENT '主食',
  `vegetables` varchar(255) DEFAULT NULL COMMENT '每日食谱的蔬菜',
  `whether_vegetables` varchar(10) DEFAULT NULL COMMENT '是否有蔬菜',
  `whether_meat` varchar(10) DEFAULT NULL COMMENT '是否有肉类',
  `meat` varchar(255) DEFAULT NULL COMMENT '肉类',
  `whether_fruit` varchar(10) DEFAULT NULL COMMENT '是否有水果',
  `fruit` varchar(255) DEFAULT NULL COMMENT '水果',
  `fruit_time` datetime DEFAULT NULL COMMENT '吃水果的时间',
  `whether_drinking` varchar(10) DEFAULT NULL COMMENT '是否喝酒',
  `drinking` varchar(255) DEFAULT NULL COMMENT '喝什么酒',
  `u_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class DayCookBook {
    private Long id;

    private String htmedType;//早中晚的分类

    private String stapleFood;//主食

    private String vegetables;//蔬菜

    private String whetherVegetables;//是否有蔬菜

    private String whetherMeat;//是否有肉类

    private String meat;//肉类

    private String whetherFruit;//是否有水果

    private String fruit;//水果
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fruitTime;//吃水果的具体的时间

    private String whetherDrinking;//是否喝酒

    private String drinking;//喝什么酒

    private Integer uId;//用户的ID
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dayTime;//每一天的具体的饮食的时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHtmedType() {
        return htmedType;
    }

    public void setHtmedType(String htmedType) {
        this.htmedType = htmedType == null ? null : htmedType.trim();
    }

    public String getStapleFood() {
        return stapleFood;
    }

    public void setStapleFood(String stapleFood) {
        this.stapleFood = stapleFood == null ? null : stapleFood.trim();
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables == null ? null : vegetables.trim();
    }

    public String getWhetherVegetables() {
        return whetherVegetables;
    }

    public void setWhetherVegetables(String whetherVegetables) {
        this.whetherVegetables = whetherVegetables == null ? null : whetherVegetables.trim();
    }

    public String getWhetherMeat() {
        return whetherMeat;
    }

    public void setWhetherMeat(String whetherMeat) {
        this.whetherMeat = whetherMeat == null ? null : whetherMeat.trim();
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat == null ? null : meat.trim();
    }

    public String getWhetherFruit() {
        return whetherFruit;
    }

    public void setWhetherFruit(String whetherFruit) {
        this.whetherFruit = whetherFruit == null ? null : whetherFruit.trim();
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit == null ? null : fruit.trim();
    }

    public Date getFruitTime() {
        return fruitTime;
    }

    public void setFruitTime(Date fruitTime) {
        this.fruitTime = fruitTime;
    }

    public String getWhetherDrinking() {
        return whetherDrinking;
    }

    public void setWhetherDrinking(String whetherDrinking) {
        this.whetherDrinking = whetherDrinking == null ? null : whetherDrinking.trim();
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking == null ? null : drinking.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}
    
}