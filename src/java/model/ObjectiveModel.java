/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ObjectiveObj;
import java.sql.PreparedStatement;
import java.util.List;


public class ObjectiveModel extends CommonModel{
    public List<ObjectiveObj> getAll() {
        List<ObjectiveObj> items = null;
        String sql = "select * from Objective";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            items = getObjectiveTable(pre);
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
