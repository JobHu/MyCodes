package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 有氧运动的实体类
 * CREATE TABLE `aerobic_movement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '有氧运动的主键ID',
  `movement_time` varchar(255) DEFAULT NULL COMMENT '运动时间的长短',
  `create_time` datetime DEFAULT NULL COMMENT '创建的时间点',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 * @author hyg
 *
 */
public class AerobicMovement {
    private Integer id;//有氧运动的主键ID

    private String movementTime;//运动时间的长短
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建的时间

    private String remark;//备注
    
    //用户ID
    private Integer uId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovementTime() {
        return movementTime;
    }

    public void setMovementTime(String movementTime) {
        this.movementTime = movementTime == null ? null : movementTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
    
}