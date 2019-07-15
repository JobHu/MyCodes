package ycit.pojo;
/**
 * CREATE TABLE `hour_pressure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每天血压的ID',
  `each_hour` varchar(255) DEFAULT NULL COMMENT '一天的每个小时',
  `blood_pressure_hour` double(11,2) DEFAULT NULL COMMENT '每个小时的血压',
  `blood_pressure_average` double(11,2) DEFAULT NULL COMMENT '每天血压的均值',
  `reason` varchar(255) DEFAULT NULL COMMENT '导致血压变化的原因',
  `result` varchar(500) DEFAULT NULL COMMENT '分析结果',
  `day_id` int(11) DEFAULT NULL COMMENT '具体一天的Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class HourPressure {
    private Integer id;//小时的Id

    private String eachHour;//具体的时间点

    private Double bloodPressureHour;//每个时间点的血压

    private Double bloodPressureAverage;

    private String reason;//分析每个时间点血压变化的原因

    private String result;//分析的结果

    private Integer dayId;//具体每一天的Id
    
    private DayPressure dayPressure;//具体哪一天的对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEachHour() {
        return eachHour;
    }

    public void setEachHour(String eachHour) {
        this.eachHour = eachHour == null ? null : eachHour.trim();
    }

    public Double getBloodPressureHour() {
        return bloodPressureHour;
    }

    public void setBloodPressureHour(Double bloodPressureHour) {
        this.bloodPressureHour = bloodPressureHour;
    }

    public Double getBloodPressureAverage() {
        return bloodPressureAverage;
    }

    public void setBloodPressureAverage(Double bloodPressureAverage) {
        this.bloodPressureAverage = bloodPressureAverage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

	public DayPressure getDayPressure() {
		return dayPressure;
	}

	public void setDayPressure(DayPressure dayPressure) {
		this.dayPressure = dayPressure;
	}
    
}