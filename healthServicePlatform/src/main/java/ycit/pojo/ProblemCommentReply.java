package ycit.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProblemCommentReply {
    private Integer id;

    private String commentReplyContent;
      
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commentReplyTime;

    private Integer commentId;

    private Integer uId;

    private Integer cUId;

    private Integer replyThumbs;
    
    private User user;
    private ProblemComment problemComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentReplyContent() {
        return commentReplyContent;
    }

    public void setCommentReplyContent(String commentReplyContent) {
        this.commentReplyContent = commentReplyContent == null ? null : commentReplyContent.trim();
    }

    public Date getCommentReplyTime() {
        return commentReplyTime;
    }

    public void setCommentReplyTime(Date commentReplyTime) {
        this.commentReplyTime = commentReplyTime;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcUId() {
        return cUId;
    }

    public void setcUId(Integer cUId) {
        this.cUId = cUId;
    }

    public Integer getReplyThumbs() {
        return replyThumbs;
    }

    public void setReplyThumbs(Integer replyThumbs) {
        this.replyThumbs = replyThumbs;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProblemComment getProblemComment() {
		return problemComment;
	}

	public void setProblemComment(ProblemComment problemComment) {
		this.problemComment = problemComment;
	}
    
}