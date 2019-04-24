package com.liyue.Test;


import com.liyue.domain.Account;
import com.liyue.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class springAOPtest {

    @Autowired
    private AccountService  ac;


    @Test
    public   void   testFindAll(){
        List<Account> all = ac.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }


    @Test
    public   void   testTransfer(){

        ac.transfer("张三","赵四",100f);

    }


}
