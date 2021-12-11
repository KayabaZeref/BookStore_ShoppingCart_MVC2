/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phuong.dtos.CategoryDTO;
import phuong.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class CategoryDAO {
    public List<CategoryDTO> getListCategory() throws SQLException{
        List<CategoryDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT categoryID, categoryName\n" +
                        "FROM tblCategory";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                String categoryID = rs.getString("categoryID");
                String categoryName = rs.getString("categoryName");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new CategoryDTO(categoryID, categoryName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
