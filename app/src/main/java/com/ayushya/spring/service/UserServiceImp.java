package com.ayushya.spring.service;

import static com.ayushya.spring.helper.GlobalConstants.DIR_PATH_SEPERATOR;
import static com.ayushya.spring.helper.GlobalConstants.IMAGE_UPLOAD_FOLDER;
import static com.ayushya.spring.helper.GlobalConstants.UPLOADED_FOLDER_PATH;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.Brands;
import com.ayushya.spring.bean.Cities;
import com.ayushya.spring.bean.Employee;
import com.ayushya.spring.bean.Models;
import com.ayushya.spring.bean.Product_category;
import com.ayushya.spring.bean.Product_subCategory;
import com.ayushya.spring.bean.States;
import com.ayushya.spring.repository.BrandsRepository;
import com.ayushya.spring.repository.CityRepository;
import com.ayushya.spring.repository.ModelsRepository;
import com.ayushya.spring.repository.Product_categoryRepository;
import com.ayushya.spring.repository.Product_subCategoryRepository;
import com.ayushya.spring.repository.StateRepository;
import com.ayushya.spring.repository.UserRepository;
import com.ayushya.spring.utils.GlobalUtils;

@Service
@Transactional
public class UserServiceImp implements UserService
{
  @Autowired
  UserRepository userRepository;

  @Autowired
  StateRepository stateRepository;

  @Autowired
  CityRepository cityRepository;

  @Autowired
  ModelsRepository modelsRepository;

  @Autowired
  BrandsRepository brandsRepository;

  @Autowired
  Product_categoryRepository product_categoryRepository;

  @Autowired
  Product_subCategoryRepository product_subcategoryRepository;

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public void createUser(Employee user)
  {
    // TODO Auto-generated method stub
    userRepository.save(user);
  }

  @Override
  public List<Employee> getUser()
  {
    // TODO Auto-generated method stub
    return (List<Employee>) userRepository.findAll();
  }

  @Override
  public Employee findById(String id)
  {
    // TODO Auto-generated method stub
    return userRepository.findOne(id);
  }

  @Override
  public Employee update(Employee user,
                         String l)
  {
    // TODO Auto-generated method stub
    return userRepository.save(user);
  }

  @Override
  public void deleteUserById(String id)
  {
    // TODO Auto-generated method stub
    userRepository.delete(id);
  }

  @Override
  public Employee updatePartially(Employee emp,
                                  String id)
  {
    // TODO Auto-generated method stub
    Employee emp_Det = findById(id);
    return userRepository.save(emp);
  }

  public List<Employee> findByName(String name)
  {
    // TODO Auto-generated method stub
    return userRepository.findByEmpFirstName(name);

  }

  public List<Employee> findByNameStartingWith(String regexp)
  {
    // TODO Auto-generated method stub
    return (List<Employee>) userRepository.findAll();
  }

  public List<Employee> findByNameEndingWith(String regexp)
  {
    // TODO Auto-generated method stub
    return (List<Employee>) userRepository.findAll();
  }

  public List<Employee> findByAgeBetween(int ageGT,
                                         int ageLT)
  {
    // TODO Auto-generated method stub
    return (List<Employee>) userRepository.findAll();
  }

  public String uploadImage(MultipartFile uploadfile)
  {

    try
    {
      String path = UPLOADED_FOLDER_PATH + IMAGE_UPLOAD_FOLDER + DIR_PATH_SEPERATOR + "employees" + DIR_PATH_SEPERATOR;
      /* Runtime.getRuntime().exec("chmod 777 -R " + UPLOADED_FOLDER_PATH); if linux system */
      File folder = new File(path);
      if (!folder.exists())
      {
        if (folder.mkdirs())
        {
          // Runtime.getRuntime().exec("chmod 644 " + path); If linux system
        }
      }
      GlobalUtils.uploadFile(folder.getAbsolutePath(), uploadfile);
      String imagePath = IMAGE_UPLOAD_FOLDER + "/employees/" + uploadfile.getOriginalFilename();

      return imagePath;
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return e.getMessage();
    }
  }

  public List<Cities> getCityByState(int id)
  {
    return (List<Cities>) cityRepository.findByStateId(id);
  }

  @Override
  public Cities getCityById(String id)
  {
    return cityRepository.findOne(id);
  }

  @Override
  public List<States> getStates()
  {
    return (List<States>) stateRepository.findAll();
  }

  @Override
  public List<Cities> getCities()
  {
    return (List<Cities>) cityRepository.findAll();
  }

  @Override
  public List<Brands> getBrands()
  {
    // TODO Auto-generated method stub
    return (List<Brands>) brandsRepository.findAll();
  }

  @Override
  public List<Product_category> getProducts()
  {
    // TODO Auto-generated method stub
    return (List<Product_category>) product_categoryRepository.findAll();
  }

  @Override
  public List<Product_subCategory> getProductSubCategory()
  {
    // TODO Auto-generated method stub
    return (List<Product_subCategory>) product_subcategoryRepository.findAll();
  }

  @Override
  public List<Models> getModels()
  {
    // TODO Auto-generated method stub
    return (List<Models>) modelsRepository.findAll();

  }

  @Override
  public List<Product_category> getProducts(int brand_id)
  {
    // TODO Auto-generated method stub
    return (List<Product_category>) product_categoryRepository.findProducts(brand_id);
  }

  @Override
  public List<Product_subCategory> getProductSubCategory(int brand_id,
                                                         int product_id)
  {
    // TODO Auto-generated method stub
    return (List<Product_subCategory>) product_subcategoryRepository.findProductSubCategory(brand_id, product_id);
  }

  @Override
  public List<Models> getModels(int brand_id,
                                int product_id,
                                int productSubCat_id)
  {
    // TODO Auto-generated method stub
    System.out.println("Brand" + brand_id + "product" + product_id + "product sub category" + productSubCat_id);
    return (List<Models>) modelsRepository.findModels(brand_id, product_id, productSubCat_id);
    // return null;
  }
}
