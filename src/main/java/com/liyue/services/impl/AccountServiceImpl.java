package com.liyue.services.impl;

import com.liyue.dao.AccountDao;
import com.liyue.domain.Account;
import com.liyue.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional//切面类
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao  accountDao;

    @Override
    public List<Account> findAll() {

        List<Account> all = accountDao.findAll();
        return all;


    }

    @Override
    public Account findByName(String name) {
      return      accountDao.findByName(name);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    @Override
    public void transfer(String name1, String name2, float money) {
        //根据姓名查询账户
        Account account1 = accountDao.findByName(name1);
        Account account2 = accountDao.findByName(name2);

        //给转出账户减钱
        account1.setMoney(account1.getMoney()-money);
        //给转入账户加钱
        account2.setMoney(account2.getMoney()+money);


        //更新账户
        accountDao.updateAccount(account1);

        //有异常
    //   int  num=10/0;

        accountDao.updateAccount(account2);



    }
}
