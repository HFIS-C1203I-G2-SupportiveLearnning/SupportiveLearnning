/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assignment;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Assignment;
import entity.User;
import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.OldAssignmentModel;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.MyDate;


public class CreateAssignment extends ActionSupport implements ServletRequestAware{

    private HttpServletRequest servletRequest;
    private Assignment assignment;
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private OldAssignmentModel assignmentModel = new OldAssignmentModel();

    public CreateAssignment() {
    }
    
    @Override
    public String execute(){
        Map session = ActionContext.getContext().getSession();
//        User user = (User) session.get("user");
        User user = new User();
        user.setUserId(1);
        String errorCode = SUCCESS;
        //validate
        if (user != null) {
            String listTo[] = null;
            boolean check = true;
            if (assignment.getSubject().isEmpty()) {
                check = false;
                addFieldError("assignment.subject", "You must to enter a value for Subject");
            } 
            
            if (assignment.getTotalMark() == 0) {
                check = false;
                addFieldError("assignment.totalMark", "You must to enter a value for Total Mark and greater 0");
            } 

            if (assignment.getDeadline().isEmpty()) {
                check = false;
                addFieldError("assignment.deadline", "You must to enter a value for Deadline");
            } else {
                if(!MyDate.isValidate("dd/MM/yyyy", assignment.getDeadline())){
                    addFieldError("assignment.deadline", "You must to enter a value for Deadline with dd/mm/yyyy format");
                    check = false;
                }
            }
            
            String fdTemp = MyDate.getCurrentDate("ddMMyyHHmmss");
            if(upload == null){
                check = false;
                addFieldError("file", "You must to select assignment file");
            } else {
                assignment.setFileName(uploadFileName);
                assignment.setSize(upload.length());
                assignment.setPath((Assignment.DEFAULT_PATH + fdTemp + "/" + uploadFileName).substring(1));
            }

            //process
            if (check) {
                boolean blnInsert = assignmentModel.insert(assignment);
//                boolean blnInsert = true;
                if(blnInsert){
                    String path = servletRequest.getSession().getServletContext()
                            .getRealPath(Assignment.DEFAULT_PATH);
                     path = path +"\\" + fdTemp +"\\";
                    try {
                        File folder = new File(path);
                        
                        boolean mkFolder = folder.mkdir();
                        if(mkFolder){
                            File uploadTmp = new File(path, uploadFileName);
                            FileUtils.copyFile(upload, uploadTmp);
                        }
                    } catch (Exception e) {
                        errorCode = ERROR;
                        addActionError("Save file fail");
                        e.printStackTrace();
                    }
                }
            } else {
                errorCode = ERROR;
            }
        } else {
            errorCode = NONE;
        }
        
        return errorCode;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public File getFile() {
        return upload;
    }

    public void setFile(File file) {
        this.upload = file;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public OldAssignmentModel getAssignmentModel() {
        return assignmentModel;
    }

    public void setAssignmentModel(OldAssignmentModel assignmentModel) {
        this.assignmentModel = assignmentModel;
    }
    
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }
    
}
