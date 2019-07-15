package ycit.pojo;

import java.util.List;

/**
 * 
 * @author hyg
 *CREATE TABLE `home_sickness` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `sickness_name` varchar(255) DEFAULT NULL COMMENT '疾病的名称',
  `sickness_type` varchar(255) DEFAULT NULL COMMENT '疾病的类型',
  `sickness_attack` double(11,2) DEFAULT NULL COMMENT '发病率',
  `sickness_inheritance` varchar(255) DEFAULT NULL COMMENT '0代表无，1代表有',
  `sickness_treat` varchar(255) DEFAULT NULL COMMENT '1是可以治疗，0是不可以治疗',
  `sickness_person_count` int(11) DEFAULT NULL COMMENT '疾病的人数',
  `member_id` int(11) DEFAULT NULL COMMENT '家属表的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class HomeSickness {
    private Long id;//主键

    private String sicknessName;//疾病的名称

    private String sicknessType;//疾病的类型

    private Double sicknessAttack;//疾病的发病率

    private String sicknessInheritance;//有无遗传性

    private String sicknessTreat;//可不可以治疗

    private Integer sicknessPersonCount;//疾病的人数

    private Integer memberId;//家属表的主键ID
    
    //建立疾病和家属表之间的联系
    private List<Member> members ;
  
    private Member member;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSicknessName() {
        return sicknessName;
    }

    public void setSicknessName(String sicknessName) {
        this.sicknessName = sicknessName == null ? null : sicknessName.trim();
    }

    public String getSicknessType() {
        return sicknessType;
    }

    public void setSicknessType(String sicknessType) {
        this.sicknessType = sicknessType == null ? null : sicknessType.trim();
    }

    public Double getSicknessAttack() {
        return sicknessAttack;
    }

    public void setSicknessAttack(Double sicknessAttack) {
        this.sicknessAttack = sicknessAttack;
    }

    public String getSicknessInheritance() {
        return sicknessInheritance;
    }

    public void setSicknessInheritance(String sicknessInheritance) {
        this.sicknessInheritance = sicknessInheritance == null ? null : sicknessInheritance.trim();
    }

    public String getSicknessTreat() {
        return sicknessTreat;
    }

    public void setSicknessTreat(String sicknessTreat) {
        this.sicknessTreat = sicknessTreat == null ? null : sicknessTreat.trim();
    }

    public Integer getSicknessPersonCount() {
        return sicknessPersonCount;
    }

    public void setSicknessPersonCount(Integer sicknessPersonCount) {
        this.sicknessPersonCount = sicknessPersonCount;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}   
}