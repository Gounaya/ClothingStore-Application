package com.github.cart;

import com.github.product.Product;
import com.github.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> productList = new ArrayList<>();

    private int quantityProductCart;

    private int subtotal;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void updateProductList(Product product){
        this.productList.add(product);
        this.subtotal = product.getCost();
        this.quantityProductCart++;
    }
    public void deleteProductList(Product product){
        for (int i = 0; i < this.productList.size(); i++) {

            if(this.productList.get(i).equals(product)){
                this.productList.remove(product);
                this.quantityProductCart--;
            }
        }
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public List<Product> getProductList() {
        return productList;
    }
    public int getQuantityProductCart() {
        return quantityProductCart;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setQuantityProductCart(int quantityProductList) {
        this.quantityProductCart = quantityProductList;
    }

}
