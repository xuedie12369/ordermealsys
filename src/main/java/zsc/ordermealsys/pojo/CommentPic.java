package zsc.ordermealsys.pojo;

import java.util.Date;

public class CommentPic {
    private Integer id;

    private Integer commentId;

    private Date createtime;

    private Date updatetime;

    private String pic;

    public CommentPic(Integer id, Integer commentId, Date createtime, Date updatetime, String pic) {
        this.id = id;
        this.commentId = commentId;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.pic = pic;
    }

    public CommentPic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}