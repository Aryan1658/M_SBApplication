package com.metateam.sba.repo;

import com.metateam.sba.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TransactionTypeRepo extends JpaRepository<TransactionType,Integer> {

    @Query(value = "select * from tbl_transaction_type_master where code = ?1",nativeQuery = true)
   Optional<TransactionType> findByCode(String code);
}
