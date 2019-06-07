package ycit.dto;
//添加家族遗传病的数据传输对象
public class MemHomeSickness {
 /*
  * <td>${obj.sicknessName}</td>
								<td>${obj.sicknessType}</td>
								<td>${obj.sicknessInheritance}</td>
								<td>${obj.sicknessTreat}</td>
								<td>${obj.sicknessAttack }</td>
								<td>${obj.member.mRelation}</td>
								<td>${obj.member.mName}</td>
								<td>${obj.member.mStatus }</td>
								<td>${obj.member.mSicknessCount }</td>
  */
	private String sicknessName;//名称
	private String sicknessInheritance;//遗传性
	private String sicknessType;//类型
	private String sicknessTreat;//是否可以治疗
	private Double sicknessAttack;//发病率
	private String mRelation;//关系
	private String mName;//姓名
	private String mStatus;//现状
	private Integer mSicknessCount;//发病的次数
	//个人ID
	private Integer uId;
	public String getSicknessName() {
		return sicknessName;
	}
	public void setSicknessName(String sicknessName) {
		this.sicknessName = sicknessName;
	}
	public String getSicknessInheritance() {
		return sicknessInheritance;
	}
	public void setSicknessInheritance(String sicknessInheritance) {
		this.sicknessInheritance = sicknessInheritance;
	}
	public String getSicknessType() {
		return sicknessType;
	}
	public void setSicknessType(String sicknessType) {
		this.sicknessType = sicknessType;
	}
	public String getSicknessTreat() {
		return sicknessTreat;
	}
	public void setSicknessTreat(String sicknessTreat) {
		this.sicknessTreat = sicknessTreat;
	}
	
	public Double getSicknessAttack() {
		return sicknessAttack;
	}
	public void setSicknessAttack(Double sicknessAttack) {
		this.sicknessAttack = sicknessAttack;
	}
	public String getmRelation() {
		return mRelation;
	}
	public void setmRelation(String mRelation) {
		this.mRelation = mRelation;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public Integer getmSicknessCount() {
		return mSicknessCount;
	}
	public void setmSicknessCount(Integer mSicknessCount) {
		this.mSicknessCount = mSicknessCount;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
}
