package com.de180602.mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoes")
public class Shoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoes_id")
    private Integer shoesId;

    @Column(name = "shoes_no", length = 10, nullable = false, unique = true)
    private String shoesNo;

    @Column(name = "shoes_name", length = 100, nullable = false)
    private String shoesName;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "type", length = 10, nullable = false)
    private String type;

    public Shoes() {
    }

    public Shoes(String shoesNo, String shoesName, Double price, String type) {
        this.shoesNo = shoesNo;
        this.shoesName = shoesName;
        this.price = price;
        this.type = type;
    }

    public Integer getShoesId() {
        return shoesId;
    }

    public void setShoesId(Integer shoesId) {
        this.shoesId = shoesId;
    }

    public String getShoesNo() {
        return shoesNo;
    }

    public void setShoesNo(String shoesNo) {
        this.shoesNo = shoesNo;
    }

    public String getShoesName() {
        return shoesName;
    }

    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
