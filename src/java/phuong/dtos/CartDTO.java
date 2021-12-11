/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class CartDTO {
    private String orderDate;
    private Map<String, ProductDTO> cart;
    private float totalPrice;

    public CartDTO() {
    }

    public CartDTO(String orderDate, Map<String, ProductDTO> cart, float totalPrice) {
        this.orderDate = orderDate;
        this.cart = cart;
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    
    
    public void add(ProductDTO product) {
        if(this.cart == null){
            this.cart= new HashMap<>();
        }
        if(this.cart.containsKey(product.getProductID())){
            int quantity = this.cart.get(product.getProductID()).getQuantity();
            product.setQuantity(quantity + product.getQuantity());
        }
        this.cart.put(product.getProductID(), product);
    }
    
    public void delete(String id) {
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void update(ProductDTO dto) {
        if (cart != null) {
            if (this.cart.containsKey(dto.getProductID())) {
                this.cart.replace(dto.getProductID(), dto);
            }
        }
    }
    
}
