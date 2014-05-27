/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.TopicObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class TopicModel extends CommonModel {

    public List<TopicObj> getByObjective(int objId) {
        List<TopicObj> items = null;
        String sql = "select * from Topic where obj_id = ?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            items = getTopicTable(pre, false);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public TopicObj getById(int topicId) {
        TopicObj item = null;
        String sql = "select * from Topic where topic_id = ?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, topicId);
            ResultSet rs = pre.executeQuery();
            if(rs!=null && rs.next()){
                item = new TopicObj();
                item.setTopicId(rs.getInt("topic_id"));
                item.setName(rs.getString("name"));
                item.setFileName(rs.getString("filename"));
                item.setPath(rs.getString("path"));
                item.setObjId(rs.getInt("obj_id"));
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public List<TopicObj> getAll(boolean inner) {
        List<TopicObj> items = null;
        
        String sql = "";
        if(inner){
                sql = "select topic_id, name, filename, path, Topic.obj_id, obj_name "
                + "from Topic inner join Objective on Topic.obj_id = Objective.obj_id order by Topic.obj_id, topic_id desc";
        } else {
            sql = "select * from Topic order by topic_id desc";
        }
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            items = getTopicTable(pre, inner);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean insert(TopicObj item) {
        boolean rs = false;
        try {
            connect();
            String sql = "insert into Topic(name, filename, path, obj_id) "
                    + "values (?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, item.getName());
            pre.setString(2, item.getFileName());
            pre.setString(3, item.getPath());
            pre.setLong(4, item.getObjId());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean edit(TopicObj item) {
        boolean rs = false;
        try {
            connect();
            String sql = "update Topic set name=?, filename=?, path=?, obj_id=? where topic_id=? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, item.getName());
            pre.setString(2, item.getFileName());
            pre.setString(3, item.getPath());
            pre.setLong(4, item.getObjId());
            pre.setInt(5, item.getTopicId());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean delete(int topicId) {
        boolean rs = false;
        try {
            connect();
            String sql = "delete Topic where topic_id=? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, topicId);
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
