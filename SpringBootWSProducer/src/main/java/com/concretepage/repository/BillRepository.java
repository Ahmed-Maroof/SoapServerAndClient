package com.concretepage.repository;



import com.concretepage.entity.Article;
import com.concretepage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BillRepository  extends JpaRepository<Bill, Long> {

//    @Query("select b.id,b.name,b.value,b.user.name from Bill b ")
//    List<Bill> findAllBills();

    @Transactional
    @Modifying
    @Query("update Bill b set b.status = 1 where b.id = ?1")
    void updateBillStatusById(Long billId);


    List<Bill> findByUser_Id(Long user_id);
}
