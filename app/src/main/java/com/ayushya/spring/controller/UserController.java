package com.ayushya.spring.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.ayushya.spring.bean.BusinessClient;
import com.ayushya.spring.bean.Employee;
import com.ayushya.spring.service.UserService;

@RestController
@RequestMapping(value = { "/", "/user" })
public class UserController
{

  private final Logger logger = Logger.getLogger(this.getClass()
                                                     .getName());

  @Autowired
  UserService userService;

  @GetMapping("/")
  public String index(Model model)
  {

    int day, month, year;
    int second, minute, hour;
    GregorianCalendar date = new GregorianCalendar();

    day = date.get(Calendar.DAY_OF_MONTH);
    month = date.get(Calendar.MONTH);
    year = date.get(Calendar.YEAR);

    second = date.get(Calendar.SECOND);
    minute = date.get(Calendar.MINUTE);
    hour = date.get(Calendar.HOUR);

    // System.out.println("Current date is "+day+"/"+(month+1)+"/"+year);
    return "Auto deploy working  " + day + "/" + (month + 1) + "/" + year;
  }

  /* Api name: Get user by id
   * Parameters: id */
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> getUserById(@PathVariable("id") String id)
  {
    System.out.println("Fetching User with id " + id);
    Employee user = userService.findById(id);
    if (user == null)
    {
      return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Employee>(user, HttpStatus.OK);
  }

  /* Api name: Create user
   * Parameters: Employee Object */
  @PostMapping(value = "/create", headers = "Accept=application/json")
  public ResponseEntity<Void> createUser(@RequestBody Employee user,
                                         UriComponentsBuilder ucBuilder)
  {
    // System.out.println("Creating User "+user.getName());
    userService.createUser(user);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/user/{id}")
                                 .buildAndExpand(user.getId())
                                 .toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  /* Api name: Image upload
   * Parameters: file */
  @PostMapping(value = "/upload")
  public ResponseEntity<Map<String, String>> fileUpload(@RequestParam("file") MultipartFile uploadfile)
  {
    // System.out.println("Creating User "+user.getName());
    String filePath = userService.uploadImage(uploadfile);
    Map<String, String> imageProp = new HashMap<String, String>();
    imageProp.put("path", filePath);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<Map<String, String>>(imageProp, HttpStatus.OK);
  }

  /* Api name: Get all user
   * Parameters: N/A */
  @GetMapping(value = "/get", headers = "Accept=application/json")
  public List<Employee> getAllUser()
  {
    List<Employee> tasks = userService.getUser();
    return tasks;

  }

  /* Api name: Update user
   * Parameters: Employee Object */
  @PutMapping(value = "/update", headers = "Accept=application/json")
  public ResponseEntity<String> updateUser(@RequestBody Employee currentUser)
  {
    System.out.println("sd");
    Employee user = userService.findById(currentUser.getId());
    if (user == null)
    {
      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    userService.update(currentUser, currentUser.getId());
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  /* Api name: Delete user
   * Parameters: id */
  @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
  public ResponseEntity<Employee> deleteUser(@PathVariable("id") String id)
  {
    Employee user = userService.findById(id);
    if (user == null)
    {
      return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    userService.deleteUserById(id);
    return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
  }

  /* Api name: Update user partially
   * Parameters: id, Employee Object */
  @PatchMapping(value = "/{id}", headers = "Accept=application/json")
  public ResponseEntity<Employee> updateUserPartially(@PathVariable("id") String id,
                                                      @RequestBody Employee currentUser)
  {
    Employee user = userService.findById(id);
    if (user == null)
    {
      return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    Employee usr = userService.updatePartially(currentUser, id);
    return new ResponseEntity<Employee>(usr, HttpStatus.OK);
  }

  /* Api name: Search by First Name, Last Name Or Role
   * Parameters: searchParam */
  @GetMapping(value = "/search", headers = "Accept=application/json")
  public List<Employee> searchByName(@RequestParam("searchParam") String searchParam)
  {
    List<Employee> user = userService.findByName(searchParam);
    return user;
  }

  /* Api name: Get client by id
   * Parameters: id */
  @GetMapping(value = "/businessclient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BusinessClient> getClientById(@PathVariable("id") String id)
  {
    System.out.println("Fetching clients with id " + id);
    BusinessClient client = userService.findClientById(id);
    if (client == null)
    {
      return new ResponseEntity<BusinessClient>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<BusinessClient>(client, HttpStatus.OK);
  }

  /* Api name: Create BusinessClient
   * Parameters: BusinessClient Object */
  @PostMapping(value = "/businessclient/create", headers = "Accept=application/json")
  public ResponseEntity<Void> createClient(@RequestBody BusinessClient client,
                                           UriComponentsBuilder ucBuilder)
  {
    userService.createClient(client);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("businessclient/user/{id}")
                                 .buildAndExpand(client.getId())
                                 .toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  /* Api name: Get all BusinessClient
   * Parameters: N/A */
  @GetMapping(value = "/businessclient/get", headers = "Accept=application/json")
  public List<BusinessClient> getAllClient()
  {
    List<BusinessClient> client = userService.getClient();
    return client;

  }

  /* Api name: Update BusinessClient
   * Parameters: BusinessClient Object */
  @PutMapping(value = "/businessclient/{id}", headers = "Accept=application/json")
  public ResponseEntity<String> updateClient(@RequestBody BusinessClient currentClient)
  {
    BusinessClient client = userService.findClientById(currentClient.getId());
    if (client == null)
    {
      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    userService.updateclient(currentClient, currentClient.getId());
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  /* Api name: Delete BusinessClient
   * Parameters: id */
  @DeleteMapping(value = "/businessclient/{id}", headers = "Accept=application/json")
  public ResponseEntity<BusinessClient> deleteClient(@PathVariable("id") String id)
  {
    BusinessClient client = userService.findClientById(id);
    if (client == null)
    {
      return new ResponseEntity<BusinessClient>(HttpStatus.NOT_FOUND);
    }
    userService.deleteClientById(id);
    return new ResponseEntity<BusinessClient>(HttpStatus.NO_CONTENT);
  }

}
