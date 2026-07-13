package com.de180602.mvc.dto;

public class ShoesDTO {
    private Integer shoesId;
    private String shoesNo;
    private String shoesName;
    private Double price;
    private String typeCode;
    private String typeName;

    public ShoesDTO() {
    }

    public ShoesDTO(Integer shoesId, String shoesNo, String shoesName, Double price, String typeCode, String typeName) {
        this.shoesId = shoesId;
        this.shoesNo = shoesNo;
        this.shoesName = shoesName;
        this.price = price;
        this.typeCode = typeCode;
        this.typeName = typeName;
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
