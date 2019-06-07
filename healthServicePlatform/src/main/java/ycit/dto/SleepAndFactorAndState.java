package ycit.dto;
//睡眠质量和因素和状态的数据的传输对象
public class SleepAndFactorAndState {
       
	private Double sleepTime;//睡眠时间

	private Integer sleepQuantity;//睡眠质量
	 
	private String name;//名称

	private String time;//在什么时间点影响睡眠
	 
    private String mood;//睡眠之后的心情

	private String workState;//工作状态

    private String bodyState;//身体状态

    private String attention;//注意力

    private String appetite;//胃口

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getBodyState() {
		return bodyState;
	}

	public void setBodyState(String bodyState) {
		this.bodyState = bodyState;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getAppetite() {
		return appetite;
	}

	public void setAppetite(String appetite) {
		this.appetite = appetite;
	}
       
}
