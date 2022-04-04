package sg.edu.nus.iss.day21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private String commentId;
    private String commentText;
    private Integer gid;
    private Integer rating;
    private String user;

    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public static Comment create(SqlRowSet rs){
        Comment comment = new Comment();
        comment.setCommentId(rs.getString("c_id"));
        comment.setCommentText(rs.getString("c_text"));
        comment.setGid(rs.getInt("gid"));
        comment.setRating(rs.getInt("rating"));
        comment.setUser(rs.getString("user"));

        return comment;
    }
}
