/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assignment;

import com.opensymphony.xwork2.ActionSupport;
import entity.AssignmentObj;
import entity.ClassObj;
import entity.TopicObj;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.AssignmentModel;
import model.ClassModel;
import model.TopicModel;


public class ManageAssignment extends ActionSupport{
    private AssignmentModel asmModel = new AssignmentModel();
    private TopicModel topicModel = new TopicModel();
    private ClassModel classModel = new ClassModel();
    
    private AssignmentObj asmo;
    private Map<Integer, String> mTopic = new LinkedHashMap<Integer, String>();
    private Map<String, String> mClass = new LinkedHashMap<String, String>();
    private List<TopicObj> topics = new LinkedList<TopicObj>();
    private List<ClassObj> classs = new LinkedList<ClassObj>();
    private List<AssignmentObj> assignments = new LinkedList<AssignmentObj>();
    
    public String preCreateAssignment() {
        topics = topicModel.getAll(false);
        classs = classModel.getAll();

        boolean check = true;
        if (topics.isEmpty()) {
            addFieldError("asmo.topicId", "Topic List is empty");
            check = false;
        }
        
        if (classs.isEmpty()) {
            addFieldError("asmo.classname", "Class List is empty");
            check = false;
        }

        if (check) {
            for (TopicObj topicObj : topics) {
                mTopic.put(topicObj.getTopicId(), topicObj.getName());
            }
            
            for (ClassObj classObj : classs) {
                mClass.put(classObj.getClassname(), classObj.getClassname());
            }
        }

        return SUCCESS;
    }
    
    public String saveAssignment(){
        preCreateAssignment();
        boolean check = true;
        
        if(asmo.getDeadline().isEmpty()){
            check = false;
            addFieldError("asmo.deadline", "You must to enter a value to deadline");
        }else {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = df.parse(asmo.getDeadline());
                if(date.after(new Date())){
                    
                } else {
                    check = false;
                    addFieldError("asmo.deadline", "You must to enter a value to deadline which greater than now");
                }
            } catch (Exception e) {
                check = false;
                addFieldError("asmo.deadline", "You must to enter a value to deadline which format is dd/MM/yyyy");
            }
        }
        
        if(check){
            boolean blnSave = asmModel.insert(asmo);
            if(blnSave){
                addActionMessage("Create assignment successfull");
            }
        }
        
        return SUCCESS;
    }
    
    public String listAssignment(){
        assignments = asmModel.getAll(true);
        return SUCCESS;
    }

    public AssignmentObj getAsmo() {
        return asmo;
    }

    public void setAsmo(AssignmentObj asmo) {
        this.asmo = asmo;
    }

    public Map<Integer, String> getmTopic() {
        return mTopic;
    }

    public void setmTopic(Map<Integer, String> mTopic) {
        this.mTopic = mTopic;
    }

    public Map<String, String> getmClass() {
        return mClass;
    }

    public void setmClass(Map<String, String> mClass) {
        this.mClass = mClass;
    }

    public List<AssignmentObj> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentObj> assignments) {
        this.assignments = assignments;
    }
    
    
    
}
