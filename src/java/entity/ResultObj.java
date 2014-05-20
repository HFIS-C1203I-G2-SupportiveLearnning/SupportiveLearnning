/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MyPC
 */
public class ResultObj {
    private String rollNo;
    private int asmId;
    private String fileName;
    private String path;
    private float mark;

    public ResultObj() {
    }

    public ResultObj(String rollNo, int asmId, String fileName, String path, float mark) {
        this.rollNo = rollNo;
        this.asmId = asmId;
        this.fileName = fileName;
        this.path = path;
        this.mark = mark;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getAsmId() {
        return asmId;
    }

    public void setAsmId(int asmId) {
        this.asmId = asmId;
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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    
    
}
