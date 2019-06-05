package com.ayushya.spring.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@SuppressWarnings("serial")
@Document(collection = "brands")
public class Brands {

    @Id ObjectId databaseId;
    @Field("id")
    private String id;
    @Field("brand")
    private String brand;
    @Field("brand_id")
    private int brand_id;



    public Brands(String id, String brand, int brand_id) {

        this.id = id;
        this.brand = brand;
        this.brand_id = brand_id;
    }




	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public void setId(String id) {
		this.id = id;
	}
}