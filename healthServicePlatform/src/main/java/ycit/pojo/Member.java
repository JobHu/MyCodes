package ycit.pojo;
/**
 * 
 * @author hyg
 *CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家属表的主键',
  `m_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `m_status` varchar(255) DEFAULT NULL COMMENT '现状',
  `m_sickness_count` int(11) DEFAULT NULL COMMENT '发病次数',
  `m_relation` varchar(255) DEFAULT NULL COMMENT '和用户的关系',
  `home_sickness_id` int(11) DEFAULT NULL COMMENT '疾病的主键',
  `u_id` int(11) DEFAULT NULL COMMENT '用户的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Member {
    private Integer id;//家属表的ID

    private String mName;//家属表的姓名

    private String mStatus;//家属的现状

    private Integer mSicknessCount;//发病的次数

    private String mRelation;//和用户的关系

    private Integer homeSicknessId;//疾病的主键

    private Integer uId;//用户的主键

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus == null ? null : mStatus.trim();
    }

    public Integer getmSicknessCount() {
        return mSicknessCount;
    }

    public void setmSicknessCount(Integer mSicknessCount) {
        this.mSicknessCount = mSicknessCount;
    }

    public String getmRelation() {
        return mRelation;
    }

    public void setmRelation(String mRelation) {
        this.mRelation = mRelation == null ? null : mRelation.trim();
    }

    public Integer getHomeSicknessId() {
        return homeSicknessId;
    }

    public void setHomeSicknessId(Integer homeSicknessId) {
        this.homeSicknessId = homeSicknessId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}