/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ObjectiveObj;
import entity.TopicObj;
import java.sql.PreparedStatement;
import java.util.List;


public class TopicModel extends CommonModel{
     public List<TopicObj> getByObjective(int objId) {
        List<TopicObj> items = null;
        String sql = "select * from Topic where obj_id = ?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            items = getTopicTable(pre);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
