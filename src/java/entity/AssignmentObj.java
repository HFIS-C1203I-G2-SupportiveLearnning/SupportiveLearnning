/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class AssignmentObj {
    private int asmId;
    private int topicId;
    private String classname;
    private String deadline;
    private String name;

    public AssignmentObj() {
    }

    public AssignmentObj(int asmId, int topicId, String classname, String deadline) {
        this.asmId = asmId;
        this.topicId = topicId;
        this.classname = classname;
        this.deadline = deadline;
    }

    public int getAsmId() {
        return asmId;
    }

    public void setAsmId(int asmId) {
        this.asmId = asmId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
