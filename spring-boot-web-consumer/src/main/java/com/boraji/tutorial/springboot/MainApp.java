package com.boraji.tutorial.springboot;

import com.boraji.tutorial.springboot.clients.UserClient;
import com.concretepage.wsdl.GetAllBillsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {
   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
   }

//   @Bean
//   CommandLineRunner lookup(UserClient articleClient) {
//      return args -> {
//
//         System.out.println("--- Get all Articles ---");
//         GetAllBillsResponse allBillsResponse = articleClient.getAllArticles();
//         allBillsResponse.getBillInfo().stream()
//                 .forEach(e -> System.out.println(e.getBillId() + ", " + e.getValue() + ", " + e.getName()+", " + e.getUserName()+", " + e.isStatus()));
//
//      };
//   }
}
