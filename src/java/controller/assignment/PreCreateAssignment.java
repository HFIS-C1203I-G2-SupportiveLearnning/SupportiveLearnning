/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assignment;

import com.opensymphony.xwork2.ActionSupport;
import entity.Assignment;


public class PreCreateAssignment extends ActionSupport {

    private Assignment assignment;

    @Override
    public String execute() {
        return SUCCESS;
    }

    public PreCreateAssignment() {
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
