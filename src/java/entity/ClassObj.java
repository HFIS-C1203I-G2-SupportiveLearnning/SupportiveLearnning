/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class ClassObj {
    private String classname;
    private String staffId;
    private int objId;

    public ClassObj() {
    }

    public ClassObj(String classname, String staffId, int objId) {
        this.classname = classname;
        this.staffId = staffId;
        this.objId = objId;
    }
    
    

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }
    
    
}
