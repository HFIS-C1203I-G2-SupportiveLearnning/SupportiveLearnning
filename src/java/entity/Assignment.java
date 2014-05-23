/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Assignment {
    public static final String DEFAULT_PATH = "/assignment/";
    
    private int assignmentId;
    private String subject;
    private String fileName;
    private String path;
    private long size;
    private byte totalMark;
    private String deadline;
    private int userId;

    public Assignment() {
    }

    public Assignment(int assignmentId, String subject, String fileName, String path, long size, byte totalMark, String deadline, int userId) {
        this.assignmentId = assignmentId;
        this.subject = subject;
        this.fileName = fileName;
        this.path = path;
        this.size = size;
        this.totalMark = totalMark;
        this.deadline = deadline;
        this.userId = userId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(byte totalMark) {
        this.totalMark = totalMark;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
