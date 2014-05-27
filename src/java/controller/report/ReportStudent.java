/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.report;

import com.opensymphony.xwork2.ActionSupport;
import entity.ClassObj;
import entity.ObjectiveObj;
import entity.PairValue;
import entity.StudentObj;
import entity.TopicObj;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.ClassModel;
import model.ObjectiveModel;
import model.ReportModel;
import model.TopicModel;
import static util.Constant.*;


public class ReportStudent extends ActionSupport {
    private Map<String, String> mClass = new LinkedHashMap<String, String>();
    private Map<Integer, String> mObjective = new HashMap<Integer, String>();
    private Map<Integer, String> mTopic = new HashMap<Integer, String>();
    private Map<Integer, String> mStatus = new HashMap<Integer, String>();
    
    private Map<Float, PairValue> mMarkStatistics = new LinkedHashMap<Float, PairValue>();
    private Map<String, PairValue> mSubmitted = new LinkedHashMap<String, PairValue>();
    
    private ClassObj clo;
    private ObjectiveObj ojto;
    private TopicObj tpo;
    private StudentObj stdo;
    
    private List<StudentObj> students;
    
    ClassModel mdClass = new ClassModel();
    ObjectiveModel mdObjective = new ObjectiveModel();
    TopicModel mdTopic = new TopicModel();
    ReportModel mdReport = new ReportModel();
    
    public String preReportByMark() {
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
            mClass.put(ALL, ALL);
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
    
    public String preReportBySubmitted() {
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
            mClass.put(ALL, ALL);
            for (ClassObj classObj : lstClass) {
                mClass.put(classObj.getClassname(), classObj.getClassname());
            }
            
            for (ObjectiveObj objectiveObj : lstObjective) {
                mObjective.put(objectiveObj.getObjId(), objectiveObj.getObjName());
            }
            
            for (TopicObj topicObj : lstTopic) {
                mTopic.put(topicObj.getTopicId(), topicObj.getName());
            }
            
            mStatus.put(0, "Not submitted");
            mStatus.put(1, "Submitted");
            
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
    
    public String preReportByType() {
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
            mClass.put(ALL, ALL);
            for (ClassObj classObj : lstClass) {
                mClass.put(classObj.getClassname(), classObj.getClassname());
            }
            
            for (ObjectiveObj objectiveObj : lstObjective) {
                mObjective.put(objectiveObj.getObjId(), objectiveObj.getObjName());
            }
            
            for (TopicObj topicObj : lstTopic) {
                mTopic.put(topicObj.getTopicId(), topicObj.getName());
            }
            
            mStatus.put(0, "Fail");
            mStatus.put(1, "Pass");
            
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
    
    public String reportByMark(){
        preReportByMark();
        
        boolean check = true;
        if(stdo.getStrMark().isEmpty()){
            check = false;
            addFieldError("stdo.strMark", "You must a value to mark");
        } else {
            try {
                stdo.setMark(Float.parseFloat(stdo.getStrMark()));
                if(stdo.getMark()<0 || stdo.getMark() > 100){
                    check = false;
                    addFieldError("stdo.strMark", "You must a value to mark which in [0, 100]");
                }
            } catch (Exception e) {
                check = false;
                addFieldError("stdo.strMark", "You must a float value to mark");
            }
        }
        
        if(check){
            students = mdReport.getStudentByMark(clo.getClassname(), ojto.getObjId(), tpo.getTopicId(), stdo.getMark());
            
            if(students.size() > 0){
                mMarkStatistics = new LinkedHashMap<Float, PairValue>();
                for (StudentObj studentObj : students) {
                    PairValue pair = mMarkStatistics.get(studentObj.getMark());
                    if(pair != null){
                        Integer countMark = Integer.valueOf(pair.getValue1()) + 1;
                        pair = new PairValue(countMark + "", (int)((countMark * 1.0/students.size()) * 100) + "");
                        mMarkStatistics.put(studentObj.getMark(), pair);
                    } else {
                        mMarkStatistics.put(studentObj.getMark(), new PairValue(1 + "", (int)((1.0/students.size()) * 100) + ""));
                    }
                }
            }
        }
        
        return SUCCESS;
    }
    
    public String markByMark(){
        preReportByMark();
        
        boolean check = true;
        
        if(check){
            students = mdReport.getStudentByMark(clo.getClassname(), ojto.getObjId(), tpo.getTopicId(), -1);
        }
        
        return SUCCESS;
    }
    
    public String reportBySubmitted(){
        preReportBySubmitted();
        
        List<StudentObj> lstSubmitted = mdReport.getStudentBySubmitted(clo.getClassname(), ojto.getObjId(), tpo.getTopicId());
        List<StudentObj> lstNotSubmitted = mdReport.getStudentNotSubmitted(clo.getClassname(), ojto.getObjId(), tpo.getTopicId());
        int sum = lstSubmitted.size() + lstNotSubmitted.size();
        
        
        mSubmitted.put("Not submitted", new PairValue(lstNotSubmitted.size() + "", (int)((lstNotSubmitted.size() * 1.0 / sum)*100) + ""));
        mSubmitted.put("Submitted", new PairValue(lstSubmitted.size() + "", (int)((lstSubmitted.size() * 1.0 / sum)*100) + ""));
        
        if(stdo.getSubmitted() == 1){
            students = lstSubmitted;
        } else {
            students = lstNotSubmitted;
        }
        
        return SUCCESS;
    }
    
    public String reportByType(){
        preReportByType();
        
        List<StudentObj> lstPass = mdReport.getStudentByType(clo.getClassname(), ojto.getObjId(), tpo.getTopicId(), 1);
        List<StudentObj> lstNotPass = mdReport.getStudentByType(clo.getClassname(), ojto.getObjId(), tpo.getTopicId(), 0);
        int sum = lstPass.size() + lstNotPass.size();
        
        
        mSubmitted.put("Fail", new PairValue(lstNotPass.size() + "", (int)((lstNotPass.size() * 1.0 / sum)*100) + ""));
        mSubmitted.put("Pass", new PairValue(lstPass.size() + "", (int)((lstPass.size() * 1.0 / sum)*100) + ""));
        
        if(stdo.getPass() == 1){
            students = lstPass;
        } else {
            students = lstNotPass;
        }
        
        return SUCCESS;
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

    public Map<Integer, String> getmStatus() {
        return mStatus;
    }

    public void setmStatus(Map<Integer, String> mStatus) {
        this.mStatus = mStatus;
    }

    public Map<Float, PairValue> getmMarkStatistics() {
        return mMarkStatistics;
    }

    public void setmMarkStatistics(Map<Float, PairValue> mMarkStatistics) {
        this.mMarkStatistics = mMarkStatistics;
    }

    public Map<String, PairValue> getmSubmitted() {
        return mSubmitted;
    }

    public void setmSubmitted(Map<String, PairValue> mSubmitted) {
        this.mSubmitted = mSubmitted;
    }
    
    
}
