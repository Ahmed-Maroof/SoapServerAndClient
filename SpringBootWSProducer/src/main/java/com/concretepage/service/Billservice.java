package com.concretepage.service;

import com.concretepage.entity.Bill;
import com.concretepage.repository.BillRepository;
import com.concretepage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Billservice implements IBillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;

    public List<Bill> retriveAllBills(){
        return  billRepository.findAll();
    }

    @Override
    public boolean payBill(Long billId) {

        //get bill by id
        if(billRepository.exists(billId))
        {
            Bill tempBill = billRepository.findOne(billId);
            //get balance
            Long userCurrentBalance= tempBill.getUser().getBalance();

            if(userCurrentBalance > tempBill.getValue())
            {
                //sub
                userCurrentBalance = userCurrentBalance-tempBill.getValue();

                //update user in DB
                userRepository.updateUserBalanceById(userCurrentBalance,tempBill.getUser().getId());

                //update bill ib DB
                updateBillStatus(tempBill.getId());

                return true;
            }else
            {
                return false;
            }
        }else
        {
            return false;
        }



     }

    @Override
    public Boolean updateBillStatus(Long billId) {
       if( billRepository.exists(billId))
       {
           billRepository.updateBillStatusById(billId);
       }
        return null;
    }

    @Override
    public List<Bill> retriveBillsByUserId(Long userId) {

        return  billRepository.findByUser_Id(userId);
    }
}
