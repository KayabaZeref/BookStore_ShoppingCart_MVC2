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
import phuong.dtos.OrderDetailDTO;
import phuong.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class OrderDetailDAO {
    public int getNoOfOrderDetail() throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT Count(orderDetailID) as NoOfOrderDetail\n" +
                           " FROM tblOrderDetail";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfOrderDetail");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs!=null)rs.close();
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
        return result;
    }
    
    public void createDetailOrder(OrderDetailDTO orderDetailDTO) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="INSERT INTO tblOrderDetail(orderDetailID,price,quantity,orderID,productID)\n" +
                           "values(?,?,?,?,?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,orderDetailDTO.getOrderDetailID());
                stm.setFloat(2,orderDetailDTO.getPrice());
                stm.setFloat(3,orderDetailDTO.getQuantity());
                stm.setString(4,orderDetailDTO.getOrderID());
                stm.setString(5,orderDetailDTO.getProductID());
                stm.executeUpdate();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
    }
}
