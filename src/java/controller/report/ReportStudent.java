/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.report;

import com.opensymphony.xwork2.ActionSupport;
import entity.ClassObj;
import entity.ObjectiveObj;
import entity.StudentObj;
import entity.TopicObj;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.ClassModel;
import model.ObjectiveModel;
import model.ReportModel;
import model.TopicModel;

/**
 *
 * @author MyPC
 */
public class ReportStudent extends ActionSupport {
    private Map<String, String> mClass = new HashMap<String, String>();
    private Map<Integer, String> mObjective = new HashMap<Integer, String>();
    private Map<Integer, String> mTopic = new HashMap<Integer, String>();
    
    private ClassObj clo;
    private ObjectiveObj ojto;
    private TopicObj tpo;
    private StudentObj stdo;
    
    private List<StudentObj> students;
    
    ClassModel mdClass = new ClassModel();
    ObjectiveModel mdObjective = new ObjectiveModel();
    TopicModel mdTopic = new TopicModel();
    ReportModel mdReport = new ReportModel();
    
    public String preReportStudent() {
        List<ClassObj> lstClass = mdClass.getAll();
        List<ObjectiveObj> lstObjective = mdObjective.getAll();
        List<TopicObj> lstTopic = new LinkedList<TopicObj>();
        if(lstObjective.size() > 0){
            lstTopic = mdTopic.getByObjective(lstObjective.get(0).getObjId());
        }
        
        //validate
        boolean check = true;
        if(lstClass.isEmpty()){
            check = false;
            addFieldError("clo.classname", "Class List is empty");
        }
        
        if(lstObjective.isEmpty()){
            check = false;
            addFieldError("ojto.objName", "Objective List is empty");
        }
        
        if(lstTopic.isEmpty()){
            check = false;
            addFieldError("tpo.name", "Topic List is empty");
        }
        
        if(check){
            for (ClassObj classObj : lstClass) {
                mClass.put(classObj.getClassname(), classObj.getClassname());
            }
            
            for (ObjectiveObj objectiveObj : lstObjective) {
                mObjective.put(objectiveObj.getObjId(), objectiveObj.getObjName());
            }
            
            for (TopicObj topicObj : lstTopic) {
                mTopic.put(topicObj.getTopicId(), topicObj.getName());
            }
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
    public String reportStudent(){
        preReportStudent();
        
        boolean check = true;
        if(stdo.getStrMark().isEmpty()){
            check = false;
            addFieldError("stdo.strMark", "You must a value to mark");
        } else {
            try {
                stdo.setMark(Float.parseFloat(stdo.getStrMark()));
            } catch (Exception e) {
                check = false;
                addFieldError("stdo.strMark", "You must a float value to mark");
            }
        }
        
        if(check){
            students = mdReport.getStudentReport(clo.getClassname(), ojto.getObjId(), tpo.getTopicId(), stdo.getMark());
        }
        
        return SUCCESS;
    }
    
    public String changeObjective(){
        List<ClassObj> lstClass = mdClass.getAll();
        List<ObjectiveObj> lstObjective = mdObjective.getAll();
        List<TopicObj> lstTopic = new LinkedList<TopicObj>();
        if(lstObjective.size() > 0){
            lstTopic = mdTopic.getByObjective(ojto.getObjId());
        }
        
        //validate
        boolean check = true;
        if(lstClass.isEmpty()){
            check = false;
            addFieldError("clo.classname", "Class List is empty");
        }
        
        if(lstObjective.isEmpty()){
            check = false;
            addFieldError("ojto.objName", "Objective List is empty");
        }
        
        if(lstTopic.isEmpty()){
            check = false;
            addFieldError("tpo.name", "Topic List is empty");
        }
        
        if(check){
            for (ClassObj classObj : lstClass) {
                mClass.put(classObj.getClassname(), classObj.getClassname());
            }
            
            for (ObjectiveObj objectiveObj : lstObjective) {
                mObjective.put(objectiveObj.getObjId(), objectiveObj.getObjName());
            }
            
            for (TopicObj topicObj : lstTopic) {
                mTopic.put(topicObj.getTopicId(), topicObj.getName());
            }
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public Map<String, String> getmClass() {
        return mClass;
    }

    public void setmClass(Map<String, String> mClass) {
        this.mClass = mClass;
    }

    public Map<Integer, String> getmObjective() {
        return mObjective;
    }

    public void setmObjective(Map<Integer, String> mObjective) {
        this.mObjective = mObjective;
    }

    public Map<Integer, String> getmTopic() {
        return mTopic;
    }

    public void setmTopic(Map<Integer, String> mTopic) {
        this.mTopic = mTopic;
    }

    public ClassObj getClo() {
        return clo;
    }

    public void setClo(ClassObj clo) {
        this.clo = clo;
    }

    public ObjectiveObj getOjto() {
        return ojto;
    }

    public void setOjto(ObjectiveObj ojto) {
        this.ojto = ojto;
    }

    public TopicObj getTpo() {
        return tpo;
    }

    public void setTpo(TopicObj tpo) {
        this.tpo = tpo;
    }

    public List<StudentObj> getStudents() {
        return students;
    }

    public void setStudents(List<StudentObj> students) {
        this.students = students;
    }

    public StudentObj getStdo() {
        return stdo;
    }

    public void setStdo(StudentObj stdo) {
        this.stdo = stdo;
    }
    
}
