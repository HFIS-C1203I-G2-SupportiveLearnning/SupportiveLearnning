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
import static util.Constant.*;


public class ReportModel extends CommonModel {
     public List<StudentObj> getStudentByMark(String classname, int objId, int topicId, float mark) {
        List<StudentObj> items = new LinkedList<StudentObj>();
        String sql = "select Student.classname, Student.rollNo, fullname, email, mark from Student inner join Result on Student.rollNo = Result.rollNo inner join Assignment on Result.asm_id = Assignment.asm_id "
                    + "inner join Topic on Assignment.topic_id = Topic.topic_id inner join Objective on Topic.obj_id = Objective.obj_id "
                    + "where Objective.obj_id = ? and Topic.topic_id = ? and mark >= ? ";
        if(!classname.equals(ALL)){
            sql += "and Student.classname = ? ";
        }
        sql += "order by mark desc";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            pre.setInt(2, topicId);
            pre.setFloat(3, mark);
            if(!classname.equals(ALL)){
                pre.setString(4, classname);
            }
            
            try {
                ResultSet rs = pre.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        StudentObj item = new StudentObj();
                        item.setClassname(rs.getString("classname"));
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
     
    public List<StudentObj> getStudentBySubmitted(String classname, int objId, int topicId) {
         List<StudentObj> items = new LinkedList<StudentObj>();
        String sql = "select Student.classname, Student.rollNo, fullname, email from Student inner join Result on Student.rollNo = Result.rollNo inner join Assignment on Result.asm_id = Assignment.asm_id "
                    + "inner join Topic on Assignment.topic_id = Topic.topic_id inner join Objective on Topic.obj_id = Objective.obj_id "
                    + "where Objective.obj_id = ? and Topic.topic_id=? ";
        if(!classname.equals(ALL)){
            sql += "and Student.classname = ? ";
        }
        sql += "order by Student.classname";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            pre.setInt(2, topicId);
            if(!classname.equals(ALL)){
                pre.setString(3, classname);
            }
            
            try {
                ResultSet rs = pre.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        StudentObj item = new StudentObj();
                        item.setClassname(rs.getString("classname"));
                        item.setRollNo(rs.getString("rollNo"));
                        item.setFullName(rs.getString("fullname"));
                        item.setEmail(rs.getString("email"));
                        
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
    
    public List<StudentObj> getStudentNotSubmitted(String classname, int objId, int topicId) {
        List<StudentObj> items = new LinkedList<StudentObj>();
        String sql = "select Student.classname, Student.rollNo, fullname, email from Student inner join Class on Student.classname = Class.classname "
                    + "inner join Assignment on Class.classname = Assignment.classname "
                    + "where Class.obj_id = ? and Assignment.topic_id = ? and (select count(*) from Result where Student.rollNo = Result.rollNo and Assignment.asm_id = Result.asm_id) = 0 ";
        if(!classname.equals(ALL)){
            sql += "and Student.classname = ? ";
        }
        sql += "order by Student.classname";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            pre.setInt(2, topicId);
            if(!classname.equals(ALL)){
                pre.setString(3, classname);
            }
            
            try {
                ResultSet rs = pre.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        StudentObj item = new StudentObj();
                        item.setClassname(rs.getString("classname"));
                        item.setRollNo(rs.getString("rollNo"));
                        item.setFullName(rs.getString("fullname"));
                        item.setEmail(rs.getString("email"));
                        
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
    
    public List<StudentObj> getStudentByType(String classname, int objId, int topicId, int pass) {
        List<StudentObj> items = new LinkedList<StudentObj>();
        String sql = "select Student.classname, Student.rollNo, fullname, email, mark from Student inner join Result on Student.rollNo = Result.rollNo inner join Assignment on Result.asm_id = Assignment.asm_id "
                    + "inner join Topic on Assignment.topic_id = Topic.topic_id inner join Objective on Topic.obj_id = Objective.obj_id "
                    + "where Objective.obj_id = ? and Topic.topic_id = ? and mark ";
        if(pass==1){
            sql += " >= ? ";
        } else {
            sql += " < ? ";
        }
        if(!classname.equals(ALL)){
            sql += "and Student.classname = ? ";
        }
        sql += "order by mark desc";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, objId);
            pre.setInt(2, topicId);
            pre.setFloat(3, 40);
            if(!classname.equals(ALL)){
                pre.setString(4, classname);
            }
            
            try {
                ResultSet rs = pre.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        StudentObj item = new StudentObj();
                        item.setClassname(rs.getString("classname"));
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
