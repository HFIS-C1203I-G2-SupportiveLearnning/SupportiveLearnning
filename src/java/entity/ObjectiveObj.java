/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MyPC
 */
public class ObjectiveObj {
    private int objId;
    private String objName;

    public ObjectiveObj() {
    }

    public ObjectiveObj(int objId, String objName) {
        this.objId = objId;
        this.objName = objName;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }
    
    
}
