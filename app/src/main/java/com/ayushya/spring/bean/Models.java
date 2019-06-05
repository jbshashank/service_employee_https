package com.ayushya.spring.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@SuppressWarnings("serial")
@Document(collection = "models")
public class Models
{

  @Id
  ObjectId databaseId;
  @Field("id")
  private String id;
  @Field("model")
  private String model;
  @Field("product_id")
  private int product_id;
  @Field("brand_id")
  private int brand_id;
  @Field("productSubCat_id")
  private int productSubCat_id;

  public Models(String id,
                String model,
                int product_id,
                int brand_id,
                int productSubCat_id)
  {
    this.id = id;
    this.model = model;
    this.product_id = product_id;
    this.brand_id = brand_id;
    this.productSubCat_id = productSubCat_id;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public int getProduct_id()
  {
    return product_id;
  }

  public void setProduct_id(int product_id)
  {
    this.product_id = product_id;
  }

  public int getBrand_id()
  {
    return brand_id;
  }

  public void setBrand_id(int brand_id)
  {
    this.brand_id = brand_id;
  }

  public int getProductSubCat_id()
  {
    return productSubCat_id;
  }

  public void setProductSubCat_id(int productSubCat_id)
  {
    this.productSubCat_id = productSubCat_id;
  }

}
