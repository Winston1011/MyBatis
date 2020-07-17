package dz.winston.repository;

import dz.winston.entity.Account;

import java.util.List;

public interface AccountRepository {
    public int save(Account account);
    public int update(Account account);
    public int deleteById(long id);
    public List<Account> findAll();
    public Account findById(long id);
    public Account findByName(String name);
    public List<Account> findByNameAndAge(String name,int age);
    public int count();
    public String findNameById(int id);
}
