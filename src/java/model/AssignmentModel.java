/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.AssignmentObj;
import entity.User;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;


public class AssignmentModel extends CommonModel {

    public List<AssignmentObj> getAll(boolean inner) {
        List<AssignmentObj> items = null;
        String sql = "";
        if(inner){
            sql = "select asm_id, Assignment.topic_id, classname, deadline, name "
                    + "from Assignment inner join Topic on Assignment.topic_id = Topic.topic_id order by asm_id desc";
        } else {
            sql = "select * from Assignment order by asm_id desc";
        }
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            items = getAssignmentTable(pre, inner);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean insert(AssignmentObj item) {
        boolean rs = false;
        try {
            connect();
            String sql = "insert into Assignment(topic_id, classname, deadline) "
                    + "values (?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, item.getTopicId());
            pre.setString(2, item.getClassname());
            item.setDeadline(new SimpleDateFormat("MM/dd/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(item.getDeadline())));
            pre.setString(3, item.getDeadline());
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
