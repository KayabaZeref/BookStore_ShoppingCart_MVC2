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
import phuong.dtos.OrderDTO;
import phuong.dtos.UserDTO;
import phuong.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class OrderDAO {
    public int getNoOfOrder() throws SQLException{
        int result=0;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="SELECT Count(orderID) as NoofOrder\n" 
                           + " FROM tblOrders";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()){
                    result=rs.getInt("NoOfOrder");
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
    
    public boolean createOrder(OrderDTO order, UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql=" INSERT INTO tblOrders(orderID,orderDate,totalMoney,userID,address,phone,statusID,email) " +
                           " VALUES (?,?,?,?,?,?,'PA',?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,order.getOrderID());
                stm.setString(2,order.getOrderDate());
                stm.setFloat(3,order.getTotalPrice());
                stm.setString(4,order.getUserID());
                stm.setString(5,user.getAddress());
                stm.setString(6,user.getPhone());
                stm.setString(7,order.getEmail());
                check = stm.executeUpdate() > 0;          
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(stm!=null)stm.close();
            if(conn!=null)conn.close();
        }
        return check;
    }
}
