package ycit.pojo;
/**
 * 健身方法的实体类
 * CREATE TABLE `fit_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '健身方法的主键',
  `fit_name` varchar(255) DEFAULT NULL COMMENT '健身方法的名称',
  `fit_type` varchar(255) DEFAULT NULL COMMENT '健身类型',
  `fit_equipment` varchar(255) DEFAULT NULL COMMENT '是否需要器材',
  `fit_description` varchar(1000) DEFAULT NULL COMMENT '健身方法的描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class FitMethod {
    private Integer id;//健身方法的ID

    private String fitName;//健身方法的名称

    private String fitType;//健身方法的类型

    private String fitEquipment;//健身是否需要器材

    private String fitDescription;//健身方法的描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFitName() {
        return fitName;
    }

    public void setFitName(String fitName) {
        this.fitName = fitName == null ? null : fitName.trim();
    }

    public String getFitType() {
        return fitType;
    }

    public void setFitType(String fitType) {
        this.fitType = fitType == null ? null : fitType.trim();
    }

    public String getFitEquipment() {
        return fitEquipment;
    }

    public void setFitEquipment(String fitEquipment) {
        this.fitEquipment = fitEquipment == null ? null : fitEquipment.trim();
    }

    public String getFitDescription() {
        return fitDescription;
    }

    public void setFitDescription(String fitDescription) {
        this.fitDescription = fitDescription == null ? null : fitDescription.trim();
    }
}