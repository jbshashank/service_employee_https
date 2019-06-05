package com.ayushya.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Brands;
import com.ayushya.spring.bean.Cities;
import com.ayushya.spring.bean.Models;
import com.ayushya.spring.bean.Product_category;
import com.ayushya.spring.bean.Product_subCategory;
import com.ayushya.spring.bean.States;
import com.ayushya.spring.service.UserService;

@RestController
@RequestMapping(value = { "/", "/utils" })
public class CommonController
{

  @Autowired
  UserService userService;

  /* Api name: Get all states
   * Parameters: N/A */
  @GetMapping(value = "/getstates", headers = "Accept=application/json")
  public List<States> getAllState()
  {
    List<States> tasks = userService.getStates();
    return tasks;

  }

  /* Api name: Get all Cities
   * Parameters: N/A */
  @GetMapping(value = "/getAllcity", headers = "Accept=application/json")
  public List<Cities> getAllCity()
  {
    List<Cities> tasks = userService.getCities();
    return tasks;

  }

  /* Api name: Get city by state id
   * Parameters: id */
  @GetMapping(value = "/{id}/getcity", headers = "Accept=application/json")
  public List<Cities> getAllCity(@PathVariable("id") int stateId)
  {
    try
    {
      List<Cities> tasks = userService.getCityByState(stateId);
      // List<Cities> tasks=userService.getCities();
      return tasks;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }

  /* Api name: Get all brands
   * Parameters: N/A */
  @GetMapping(value = "/brands", headers = "Accept=application/json")
  public List<Brands> getAllBrands()
  {
    List<Brands> brands = userService.getBrands();
    return brands;
  }

  @GetMapping(value = "/brands/{brand_id}/products/{product_id}/productsubcategory/{productSubCat_id}/models", headers = "Accept=application/json")
  public List<Models> getAllModelsById(@PathVariable("brand_id") int brand_id,
                                       @PathVariable("product_id") int product_id,
                                       @PathVariable("productSubCat_id") int productSubCat_id)
  {
    List<Models> models = userService.getModels(brand_id, product_id, productSubCat_id);
    return models;
  }

  @GetMapping(value = "/models", headers = "Accept=application/json")
  public List<Models> getAllModels()
  {
    List<Models> models = userService.getModels();
    return models;
  }

  @GetMapping(value = "/brands/{brand_id}/products", headers = "Accept=application/json")
  public List<Product_category> getAllProductsCategoryById(@PathVariable("brand_id") int brand_id)
  {
    List<Product_category> product_category = userService.getProducts(brand_id);
    return product_category;
  }

  @GetMapping(value = "/brands/{brand_id}/products/{product_id}/productsubcategory", headers = "Accept=application/json")
  public List<Product_subCategory> getAllProductSubCategoryById(@PathVariable("brand_id") int brand_id,
                                                                @PathVariable("product_id") int product_id)
  {
    List<Product_subCategory> product_subcategory = userService.getProductSubCategory(brand_id, product_id);
    return product_subcategory;
  }

  @GetMapping(value = "/products", headers = "Accept=application/json")
  public List<Product_category> getProductCategory()
  {
    List<Product_category> product_category = userService.getProducts();
    return product_category;

  }

  @GetMapping(value = "/productsubcategory", headers = "Accept=application/json")
  public List<Product_subCategory> getProductSubCategory()
  {
    List<Product_subCategory> product_subcategory = userService.getProductSubCategory();
    return product_subcategory;
  }
}
