/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.topic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.ObjectiveObj;
import entity.TopicObj;
import entity.User;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.ObjectiveModel;
import model.TopicModel;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.MyDate;


public class ManageTopic extends ActionSupport implements ServletRequestAware {

    private TopicModel topicModel = new TopicModel();
    private ObjectiveModel objModel = new ObjectiveModel();
    private HttpServletRequest servletRequest;
    private TopicObj topic;
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private List<ObjectiveObj> objectives;
    private Map<Integer, String> mObjective = new HashMap<Integer, String>();
    private List<TopicObj> topics;

    public ManageTopic() {
    }

    public String preCreateTopic() {
        objectives = objModel.getAll();

        boolean check = true;
        if (objectives.isEmpty()) {
            addFieldError("topic.objId", "Objective List is empty");
            check = false;
        }

        if (check) {
            for (ObjectiveObj objectiveObj : objectives) {
                mObjective.put(objectiveObj.getObjId(), objectiveObj.getObjName());
            }
        }

        return SUCCESS;
    }

    public String viewTopic() {
        preCreateTopic();

        if (!mObjective.isEmpty()) {
            int topicId = getTopic().getTopicId();
            topic = topicModel.getById(topicId);
        }

        return SUCCESS;
    }

    public String saveTopic() {
        preCreateTopic();
        Map session = ActionContext.getContext().getSession();
//        User user = (User) session.get("user");
        User user = new User();
        user.setUserId(1);
        String errorCode = SUCCESS;
        //validate
        if (user != null) {
            boolean check = true;
            if (topic.getName().isEmpty()) {
                check = false;
                addFieldError("topic.name", "You must to enter a value for name");
            }

            String fdTemp = MyDate.getCurrentDate("ddMMyyHHmmss");
            if (upload == null) {
                if (topic.getTopicId() == 0) {
                    check = false;
                    addFieldError("upload", "You must to select topic file");
                } else {
                    TopicObj topicTmp = topicModel.getById(topic.getTopicId());
                    topic.setFileName(topicTmp.getFileName());
                    topic.setPath(topicTmp.getPath());
                }
            } else {
                topic.setFileName(uploadFileName);
                topic.setPath((TopicObj.DEFAULT_PATH + fdTemp + "/" + uploadFileName).substring(1));
            }

            //process
            if (check) {
                boolean blnSave = false;
                if (topic.getTopicId() > 0) {
                    blnSave = topicModel.edit(topic);
                } else {
                    blnSave = topicModel.insert(topic);
                }
                if (blnSave) {
                    if (upload != null) {
                        String path = servletRequest.getSession().getServletContext()
                                .getRealPath(TopicObj.DEFAULT_PATH);
                        path = path + "\\" + fdTemp + "\\";
                        try {
                            File folder = new File(path);

                            boolean mkFolder = folder.mkdirs();
                            System.out.println(mkFolder);
                            if (mkFolder) {
                                File uploadTmp = new File(path, uploadFileName);
                                FileUtils.copyFile(upload, uploadTmp);
                            }
                        } catch (Exception e) {
                            errorCode = ERROR;
                            addActionError("Save file fail");
                            e.printStackTrace();
                        }
                    }
                    errorCode = SUCCESS;
                } else {
                    errorCode = ERROR;
                }
            } else {
                errorCode = ERROR;
            }
        }
        return errorCode;
    }

    public String deleteTopic() {
        listTopic();
        boolean rs = topicModel.delete(topic.getTopicId());
        if (!rs) {
            addActionError("This record can't delete");
            return ERROR;
        }

        return SUCCESS;
    }

    public String listTopic() {
        topics = topicModel.getAll(true);
        return SUCCESS;
    }

    public TopicObj getTopic() {
        return topic;
    }

    public void setTopic(TopicObj topic) {
        this.topic = topic;
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

    public TopicModel getTopicModel() {
        return topicModel;
    }

    public void setTopicModel(TopicModel topicModel) {
        this.topicModel = topicModel;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }

    public List<ObjectiveObj> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<ObjectiveObj> objectives) {
        this.objectives = objectives;
    }

    public Map<Integer, String> getmObjective() {
        return mObjective;
    }

    public void setmObjective(Map<Integer, String> mObjective) {
        this.mObjective = mObjective;
    }

    public List<TopicObj> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicObj> topics) {
        this.topics = topics;
    }
}
