package com.de180602.mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoes_type")
public class ShoesType {

    @Id
    @Column(name = "type_code", length = 10, nullable = false)
    private String typeCode;

    @Column(name = "type_name", length = 50, nullable = false)
    private String typeName;

    public ShoesType() {
    }

    public ShoesType(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
