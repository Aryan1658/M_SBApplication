package com.metateam.sba.loader;

import com.metateam.sba.entity.TransactionType;
import com.metateam.sba.repo.TransactionTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MasterDataLoader {

    @Autowired
    private TransactionTypeRepo transactionTypeRepo;
    @PostConstruct
    public void loadData(){
        createTransactionTypeIfNotFound();
    }

    private void createTransactionTypeIfNotFound(){

        List<TransactionType> transactionTypeList = new ArrayList<>();
        transactionTypeList.add(new TransactionType().builder().name("Deposit").code("DEP").build());
        transactionTypeList.add(new TransactionType().builder().name("Withdraw").code("WIT").build());
        transactionTypeList.add(new TransactionType().builder().name("Fund Transfer").code("IBFT").build());
        transactionTypeList.add(new TransactionType().builder().name("Merchant Pay").code("MPAY").build());
        /*
        * Find by code in database.
        * If doesn't exist save the entity.
        * If already exist do nothing.
        * */
        for(TransactionType transactionType : transactionTypeList ){
            String code = transactionType.getCode();
           Optional< TransactionType> optionalTransactionType = transactionTypeRepo.findByCode(code);
            if(!optionalTransactionType.isPresent()){
                //Save
                transactionTypeRepo.save(transactionType);
                log.info("SAVED TRANSACTION TYPE WITH CODE {} "+code);
            }else {
                log.info("ALREADY EXIST WITH CODE {}",code);
            }
        }
    }
}
