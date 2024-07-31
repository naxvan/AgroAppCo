package com.agroapp.agroapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private int PLU;
    private String image;
    private double price;
    @Column(updatable = false)
    private Date created_at = new Date();

    private Date updated_at = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @PrePersist
    protected void OnCreate() {
        if (image == null || image.isEmpty()) {
            this.image = "https://www.tiffincurry.ca/wp-content/uploads/2021/02/default-product.png";
        }
    }

}
