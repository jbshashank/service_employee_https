package com.ayushya.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.Brands;
import com.ayushya.spring.bean.Cities;
import com.ayushya.spring.bean.Employee;
import com.ayushya.spring.bean.Models;
import com.ayushya.spring.bean.Product_category;
import com.ayushya.spring.bean.Product_subCategory;
import com.ayushya.spring.bean.States;

public interface UserService
{
  public void createUser(Employee user);

  public List<Employee> getUser();

  public Employee findById(String id);

  public Employee update(Employee user,
                         String l);

  public void deleteUserById(String id);

  public Employee updatePartially(Employee user,
                                  String id);

  public String uploadImage(MultipartFile uploadfile);

  public List<Cities> getCityByState(int id);

  public List<Cities> getCities();

  public Cities getCityById(String id);

  public List<States> getStates();

  public List<Employee> findByName(String name);

  public List<Employee> findByNameStartingWith(String regexp);

  public List<Employee> findByNameEndingWith(String regexp);

  public List<Employee> findByAgeBetween(int ageGT,
                                         int ageLT);

  public List<Brands> getBrands();

  public List<Product_category> getProducts();

  public List<Product_subCategory> getProductSubCategory();

  public List<Product_category> getProducts(int brand_id);

  public List<Models> getModels();

  public List<Models> getModels(int brand_id,
                                int product_id,
                                int productSubCat_id);

  List<Product_subCategory> getProductSubCategory(int brand_id,
                                                  int product_id);
}
