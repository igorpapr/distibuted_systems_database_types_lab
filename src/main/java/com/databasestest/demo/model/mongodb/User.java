//package com.databasestest.demo.model.mongodb;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.List;
//
//@Document("users")
//@Getter
//@Setter
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String _id;
//
//    private String login;
//
//    private String password;
//
//    private String contactInfo;
//
//    private City city;
//
//    //I don't know how to save degree here, maybe make an inner object too
//    private List<String> educationInstitutionIds;
//
//}
