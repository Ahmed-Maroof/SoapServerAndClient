package com.boraji.tutorial.springboot.controller;

import com.boraji.tutorial.springboot.clients.UserClient;
import com.concretepage.wsdl.BillInfo;
import com.concretepage.wsdl.LoginUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

   @Autowired
   UserClient userClient;

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }

   @PostMapping("/main")
   public String mainpage(@RequestParam("username") String name,@RequestParam("password") String password , ModelMap model)
   {

      LoginUserInfo loginUserInfo = userClient.login(name,password).getLoginUserInfo();
      if(loginUserInfo.isRequeststatus()) {
         if (loginUserInfo.getRolename().equals("ROLE_USER")) {

            List<BillInfo> billInfos = (List<BillInfo>) userClient.getBills(loginUserInfo.getUserId()).getBillInfo();
            model.put("name", loginUserInfo.getName());
            model.put("balance" , loginUserInfo.getBalance());
            model.put("bills", billInfos);
            billInfos.stream().forEach(b-> System.out.println(b.getBillId()+","+b.isStatus()+""+b.getValue()));
            return "user-content";
         } else {
            return "admin-content";
         }
      }else
      {
         return "error";

      }

   }

   @PostMapping("/paybill")
   public String payBill(Model model) {
      System.out.println("payyyyyy");
      return "user-content";
   }

}
