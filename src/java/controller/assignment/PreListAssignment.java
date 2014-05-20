/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assignment;

import com.opensymphony.xwork2.ActionSupport;
import entity.Assignment;
import java.util.ArrayList;
import java.util.List;
import model.OldAssignmentModel;

/**
 *
 * @author MyPC
 */
public class PreListAssignment extends ActionSupport {

    private List<Assignment> assignments;
    private OldAssignmentModel assignmentModel = new OldAssignmentModel();

    @Override
    public String execute() {
        assignments = assignmentModel.getAll();
//        assignments =new ArrayList<Assignment>();
//        assignments.add(new Assignment(1, "fab", "abc.doc", "assignment/160514061630/Document_Status1.docx", (long)100, (byte)22, "25/12/2014", 1));
        return SUCCESS;
    }

    public PreListAssignment() {
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    
}
