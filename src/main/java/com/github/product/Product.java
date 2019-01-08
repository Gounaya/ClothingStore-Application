package com.github.product;


import com.github.cart.Cart;
import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 32)
    private String name;

    @NotNull
    private int cost;

    private int quantity;
    private int available;

    @ManyToOne
    private Cart cart;

    @Lob
    private byte[] photo;

    @Transient
    private MultipartFile image;

    @DateTimeFormat
    private LocalDateTime created;

    public Product() {
    }

    public Product(String name, int cost, int quantity, byte[] photo, MultipartFile image) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.photo = photo;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() throws UnsupportedEncodingException {
        byte[] encodeBase64 = Base64.getEncoder().encode(this.photo);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        return base64Encoded;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
