package ycit.pojo;
/**
 * 
 * @author hyg
 *CREATE TABLE `standard_physical_examination` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标准的ID',
  `standard_blood_pressure_max` double(11,2) DEFAULT NULL COMMENT '标准血压的最大值',
  `standard_blood_pressures_min` double(11,2) DEFAULT NULL COMMENT '标准血压的最小值',
  `standard_blood_suger_min` double(11,2) DEFAULT NULL COMMENT '标准血糖的最小值',
  `standard_wr_proportion` double(11,2) DEFAULT NULL COMMENT '白红细胞的比例',
  `standard_weight` double(11,2) DEFAULT NULL COMMENT '体重',
  `standard_bodyfat_max` double(11,2) DEFAULT NULL COMMENT '体脂的最大值',
  `standard_bodyfat_min` double(11,2) DEFAULT NULL COMMENT '体脂的最小值',
  `standard_blood_suger_max` double(11,2) DEFAULT NULL COMMENT '标准的血糖的最大值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class StandardPhysicalExamination {
    private Integer id;//标准的ID

    private Double standardBloodPressureMax;//标准血压的最大值

    private Double standardBloodPressuresMin;//标准血压的最小值

    private Double standardBloodSugerMin;//标准血糖的最小值
    
    private Double standardBloodSugerMax;//标准血糖的最大值

    private Double standardWrProportion;//红白细胞的比例

    private Double standardWeight;//标准的体重

    private Double standardBodyfatMax;//体脂的最大值

    private Double standardBodyfatMin;//体脂的最小值

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getStandardBloodPressureMax() {
        return standardBloodPressureMax;
    }

    public void setStandardBloodPressureMax(Double standardBloodPressureMax) {
        this.standardBloodPressureMax = standardBloodPressureMax;
    }

    public Double getStandardBloodPressuresMin() {
        return standardBloodPressuresMin;
    }

    public void setStandardBloodPressuresMin(Double standardBloodPressuresMin) {
        this.standardBloodPressuresMin = standardBloodPressuresMin;
    }

    public Double getStandardBloodSugerMin() {
        return standardBloodSugerMin;
    }

    public void setStandardBloodSugerMin(Double standardBloodSugerMin) {
        this.standardBloodSugerMin = standardBloodSugerMin;
    }

    public Double getStandardWrProportion() {
        return standardWrProportion;
    }

    public void setStandardWrProportion(Double standardWrProportion) {
        this.standardWrProportion = standardWrProportion;
    }

    public Double getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(Double standardWeight) {
        this.standardWeight = standardWeight;
    }

    public Double getStandardBodyfatMax() {
        return standardBodyfatMax;
    }

    public void setStandardBodyfatMax(Double standardBodyfatMax) {
        this.standardBodyfatMax = standardBodyfatMax;
    }

    public Double getStandardBodyfatMin() {
        return standardBodyfatMin;
    }

    public void setStandardBodyfatMin(Double standardBodyfatMin) {
        this.standardBodyfatMin = standardBodyfatMin;
    }

    public Double getStandardBloodSugerMax() {
        return standardBloodSugerMax;
    }

    public void setStandardBloodSugerMax(Double standardBloodSugerMax) {
        this.standardBloodSugerMax = standardBloodSugerMax;
    }
}