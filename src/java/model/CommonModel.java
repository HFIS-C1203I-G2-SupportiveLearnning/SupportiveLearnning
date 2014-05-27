/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.AssignmentObj;
import entity.ClassObj;
import entity.ObjectiveObj;
import entity.StudentObj;
import entity.TopicObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


public class CommonModel {
    protected Connection con;
    
    public void connect() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; database=SupportiveLearningDB", "sa", "123456");
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
    
    public List<AssignmentObj> getAssignmentTable(PreparedStatement pre, boolean inner) {
        List<AssignmentObj> items = new LinkedList<AssignmentObj>();
        try {
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AssignmentObj item = new AssignmentObj();
                    item.setAsmId(rs.getInt("asm_id"));
                    item.setTopicId(rs.getInt("topic_id"));
                    item.setClassname(rs.getString("classname"));
                    item.setDeadline(new SimpleDateFormat("dd/MM/yyyy").format(rs.getTimestamp("deadline")));
                    if(inner){
                        item.setName(rs.getString("name"));
                    }
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
    
    public List<TopicObj> getTopicTable(PreparedStatement pre, boolean join) {
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
                    if(join){
                        item.setObjName(rs.getString("obj_name"));
                    }
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
