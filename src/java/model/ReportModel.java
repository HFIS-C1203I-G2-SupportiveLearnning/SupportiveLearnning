/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.StudentObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class ReportModel extends CommonModel {
     public List<StudentObj> getStudentReport(String classname, int objId, int topicId, float mark) {
        List<StudentObj> items = new LinkedList<StudentObj>();
        String sql = "select Student.rollNo, fullname, email, mark from Student inner join Result on Student.rollNo = Result.rollNo inner join Assignment on Result.asm_id = Assignment.asm_id "
                + "inner join Topic on Assignment.topic_id = Topic.topic_id inner join Objective on Topic.obj_id = Objective.obj_id "
                + "where Student.classname = ? and Objective.obj_id = ? and Topic.topic_id = ? and mark > ?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, classname);
            pre.setInt(2, objId);
            pre.setInt(3, topicId);
            pre.setFloat(4, mark);
            
            try {
                ResultSet rs = pre.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        StudentObj item = new StudentObj();
                        item.setRollNo(rs.getString("rollNo"));
                        item.setFullName(rs.getString("fullname"));
                        item.setEmail(rs.getString("email"));
                        item.setMark(rs.getFloat("mark"));
                        
                        items.add(item);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
