package com.liyue.services;

import com.liyue.domain.Account;

import java.util.List;

public interface AccountService {


    List<Account>  findAll();


    Account  findByName(String name);


    void  updateAccount(Account  account);

    void   transfer(String  name1,String  name2,float money);


}
