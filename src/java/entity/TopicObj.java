/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class TopicObj {
    private int topicId;
    private String name;
    private String fileName;
    private String path;
    private int objId;

    public TopicObj() {
    }
    
    public TopicObj(int topicId, String name, String fileName, String path, int objId) {
        this.topicId = topicId;
        this.name = name;
        this.fileName = fileName;
        this.path = path;
        this.objId = objId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }
    
    
}
