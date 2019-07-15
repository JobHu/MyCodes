package ycit.excel;
//excel导入的实体类
public class HourBloodPressure {
	
	private String eachHour;//具体的时间点

    private Double bloodPressureHour;//每个时间点的血压
    
    private String reason;//分析每个时间点血压变化的原因

	public String getEachHour() {
		return eachHour;
	}

	public void setEachHour(String eachHour) {
		this.eachHour = eachHour;
	}

	public Double getBloodPressureHour() {
		return bloodPressureHour;
	}

	public void setBloodPressureHour(Double bloodPressureHour) {
		this.bloodPressureHour = bloodPressureHour;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "HourBloodPressure [eachHour=" + eachHour + ", bloodPressureHour=" + bloodPressureHour + ", reason="
				+ reason + "]";
	}
	
    
}
