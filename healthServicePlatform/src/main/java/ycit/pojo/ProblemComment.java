package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProblemComment {
    private Integer id;

    private String commentContent;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

    private Integer pId;

    private Integer uId;

    private Integer commentThumbs;
    //注册用户和提出问题的对象 
    private User user;
    private Problem problem;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getCommentThumbs() {
        return commentThumbs;
    }

    public void setCommentThumbs(Integer commentThumbs) {
        this.commentThumbs = commentThumbs;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
    
}