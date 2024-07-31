package com.agroapp.agroapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String contactName;
    private String contactTittle;
    private String webSite;
    private String notes;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany
    @JoinColumn(name = "supplier_id")
    private Set<Product> products;
}
