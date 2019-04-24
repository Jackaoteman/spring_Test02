package com.liyue.dao;

import com.liyue.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account>   findAll();

    /**
     * 根据id寻找账户
     * @param name
     * @return
     */
    Account  findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void  updateAccount(Account  account);



}
