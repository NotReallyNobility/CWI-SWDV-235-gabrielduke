package edu.cwi.data;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    @Select("SELECT account_id as id, user_id as userId, account_type as accountType, balance FROM accounts")
    List<Account> getAll();

    @Select("SELECT account_id as id, user_id as userId, account_type as accountType, balance FROM accounts WHERE account_id = #{accountId}")
    Account getById(int accountId);

    @Insert("INSERT INTO accounts (user_id, account_type, balance) VALUES (#{userId}, #{accountType}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "id") 
    void insert(Account account);

    @Update("UPDATE accounts SET user_id = #{userId}, account_type = #{accountType}, balance = #{balance} WHERE account_id = #{accountId}")
    void update(Account account);

    @Delete("DELETE FROM accounts WHERE account_id = #{accountId}")
    void delete(int accountId);
}
