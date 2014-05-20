/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Assignment;
import entity.ClassObj;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author MyPC
 */
public class ClassModel extends CommonModel {
    public List<ClassObj> getAll() {
        List<ClassObj> items = null;
        String sql = "select * from Class";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            items = getClassTable(pre);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
