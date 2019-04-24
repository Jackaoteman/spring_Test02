package com.liyue.dao.impl;

import com.liyue.dao.AccountDao;
import com.liyue.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate template;
    @Override
    public List<Account> findAll() {

        List<Account> allAccount = template.query("select* from  account", new BeanPropertyRowMapper<Account>(Account.class));
        return  allAccount;
    }

    @Override
    public Account findByName(String name) {
        List<Account> all = template.query("select *from account where  name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if(all==null||all.size()==0){
            return null;
        }else{
            return  all.get(0);
        }
    }

    @Override
    public void updateAccount(Account account) {
        template.update("update  account  set  money=? where  id=?",account.getMoney(),account.getId());
    }
}
