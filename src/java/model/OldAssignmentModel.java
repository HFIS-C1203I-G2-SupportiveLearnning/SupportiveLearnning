/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Assignment;
import entity.User;
import java.sql.PreparedStatement;
import java.util.List;


public class OldAssignmentModel extends CommonModel {

    public List<Assignment> getAll() {
        List<Assignment> items = null;
        String sql = "select * from Assignment";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            items = getAssignmentTable(pre);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean insert(Assignment item) {
        boolean rs = false;
        try {
            connect();
            String sql = "insert into Assignment(subject, file_name, path, size, total_mark, deadline, user_id) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, item.getSubject());
            pre.setString(2, item.getFileName());
            pre.setString(3, item.getPath());
            pre.setLong(4, item.getSize());
            pre.setByte(5, item.getTotalMark());
            pre.setString(6, item.getDeadline());
            pre.setInt(7, item.getUserId());
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
