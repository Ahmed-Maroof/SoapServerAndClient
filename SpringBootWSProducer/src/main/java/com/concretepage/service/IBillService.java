package com.concretepage.service;

import com.concretepage.entity.Bill;

import java.util.List;

public interface IBillService {

    public List<Bill> retriveAllBills();
    public boolean payBill(Long billId);
    public Boolean updateBillStatus (Long billId);
    public List<Bill> retriveBillsByUserId(Long userId);
}
