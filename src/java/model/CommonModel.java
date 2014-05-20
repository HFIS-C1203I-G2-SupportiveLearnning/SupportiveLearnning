/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Assignment;
import entity.ClassObj;
import entity.ObjectiveObj;
import entity.StudentObj;
import entity.TopicObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import util.MyDate;


public class CommonModel {
    protected Connection con;
    
    public void connect() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; database=SupportiveLearningDB2", "sa", "123456");
    }
    
    public void close() throws SQLException{
        if(con!=null && !con.isClosed()){
            con.close();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public List<Assignment> getAssignmentTable(PreparedStatement pre) {
        List<Assignment> items = new LinkedList<Assignment>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Assignment item = new Assignment();
                    item.setAssignmentId(rs.getInt("assignment_id"));
                    item.setSubject(rs.getString("subject"));
                    item.setFileName(rs.getString("file_name"));
                    item.setPath(rs.getString("path"));
                    item.setSize(rs.getLong("size"));
                    item.setTotalMark(rs.getByte("total_mark"));
                    item.setDeadline(MyDate.formatDate("dd/MM/yyyy", rs.getTimestamp("deadline")));
                    item.setUserId(rs.getInt("user_id"));
                    items.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
    
    public List<ClassObj> getClassTable(PreparedStatement pre) {
        List<ClassObj> items = new LinkedList<ClassObj>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClassObj item = new ClassObj();
                    item.setClassname(rs.getString("classname"));
                    item.setStaffId(rs.getString("staff_id"));
                    item.setObjId(rs.getInt("obj_id"));
                    items.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
    
    public List<ObjectiveObj> getObjectiveTable(PreparedStatement pre) {
        List<ObjectiveObj> items = new LinkedList<ObjectiveObj>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ObjectiveObj item = new ObjectiveObj();
                    item.setObjId(rs.getInt("obj_id"));
                    item.setObjName(rs.getString("obj_name"));
                    items.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
    
    public List<TopicObj> getTopicTable(PreparedStatement pre) {
        List<TopicObj> items = new LinkedList<TopicObj>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    TopicObj item = new TopicObj();
                    item.setTopicId(rs.getInt("topic_id"));
                    item.setName(rs.getString("name"));
                    item.setFileName(rs.getString("filename"));
                    item.setPath(rs.getString("path"));
                    item.setObjId(rs.getInt("obj_id"));
                    items.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
    
    public List<StudentObj> getStudentTable(PreparedStatement pre) {
        List<StudentObj> items = new LinkedList<StudentObj>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    StudentObj item = new StudentObj();
                    item.setRollNo(rs.getString("rollNo"));
                    item.setPassword(rs.getString("password"));
                    item.setFullName(rs.getString("fullname"));
                    item.setEmail(rs.getString("email"));
                    item.setClassname(rs.getString("classname"));
                    item.setAddress(rs.getString("address"));
                    items.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
}
