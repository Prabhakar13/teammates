package teammates.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import teammates.common.datatransfer.CommentRecipientType;
import teammates.common.datatransfer.CommentStatus;

import com.google.appengine.api.datastore.Text;

/**
 * An association class that represents the association Giver
 * --> [comments about] --> Receiver.
 * Both giver and receiver must be in the same course.
 * Currently giver is restricted only to Instructor, and
 * receiver is restricted to Student. Comments are only visible by
 * the Giver.
 */
@PersistenceCapable
public class Comment {
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private transient Long commentId = null;
    
    /** The foreign key to locate the Course object. */
    @Persistent
    private String courseId;

    /** The giver's email used for this comment. */
    @Persistent
    private String giverEmail;
    
    /** The recipient type for this comment. */
    @Persistent
    private CommentRecipientType recipientType; 

    /** The recipients' id used for this comment. E.g.
     * if the recipient type is PERSON, then it stands for 
     * recipients' email; if it's TEAM, it stands for the
     * team id; if it's COURSE, it will store the course
     * id. */
    @Persistent
    private Set<String> recipients;
    
    /** The comment's status */
    @Persistent
    private CommentStatus status;
    
    /** Visibility options **/
    @Persistent
    private List<CommentRecipientType> showCommentTo;
    
    @Persistent
    private List<CommentRecipientType> showGiverNameTo;
    
    @Persistent
    private List<CommentRecipientType> showRecipientNameTo;
    
    //TODO: remove this property after data migration
    /** The receiver's email used for this comment. */
    @Persistent
    private String receiverEmail;
    
    /** The creation time of this comment. */
    @Persistent
    private Date createdAt;
    
    /** The comment from giver for receiver */
    @Persistent
    private Text commentText;

    public Comment(String courseId, String giverEmail, CommentRecipientType recipientType, Set<String> recipients, CommentStatus status,
            List<CommentRecipientType> showCommentTo,
            List<CommentRecipientType> showGiverNameTo,
            List<CommentRecipientType> showRecipientNameTo,
            Text comment, Date date){
        this.commentId = null; //Auto generated by GAE
        this.courseId = courseId;
        this.giverEmail = giverEmail;
        this.recipientType = recipientType;
        this.recipients = recipients;
        this.status = status;
        this.showCommentTo = showCommentTo;
        this.showGiverNameTo = showGiverNameTo;
        this.showRecipientNameTo = showRecipientNameTo;
        this.createdAt = date;
        this.commentText = comment;
    }

    public Long getId() {
        return commentId;
    }

    /* Auto generated. Don't set this.
    public void setId(Long id) {
        this.id = id;
    }*/

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGiverEmail() {
        return giverEmail;
    }

    public void setGiverEmail(String giverEmail) {
        this.giverEmail = giverEmail;
    }

    public CommentRecipientType getRecipientType() {
        return recipientType;
    }
    
    public void setRecipientType(CommentRecipientType recipientType) {
        this.recipientType = recipientType;
    }
    
    public Set<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<String> recipients) {
        this.recipients = recipients;
    }
    
    public CommentStatus getStatus(){
        return status;
    }
    
    public void setStatus(CommentStatus status){
        this.status = status;
    }
    
    public List<CommentRecipientType> getShowCommentTo(){
        return showCommentTo;
    }
    
    public void setShowCommentTo(List<CommentRecipientType> showCommentTo){
        this.showCommentTo = showCommentTo;
    }
    
    public List<CommentRecipientType> getShowGiverNameTo(){
        return showGiverNameTo;
    }
    
    public void setShowGiverNameTo(List<CommentRecipientType> showGiverNameTo){
        this.showGiverNameTo = showGiverNameTo;
    }
    
    public List<CommentRecipientType> getShowRecipientNameTo(){
        return showRecipientNameTo;
    }
    
    public void setShowRecipientNameTo(List<CommentRecipientType> showRecipientNameTo){
        this.showRecipientNameTo = showRecipientNameTo;
    }
    
    @Deprecated 
    public String getReceiverEmail() {
        return receiverEmail;
    }

    @Deprecated 
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Text getCommentText() {
        return commentText;
    }

    public void setCommentText(Text commentText) {
        this.commentText = commentText;
    }
}