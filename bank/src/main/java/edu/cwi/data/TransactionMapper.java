package edu.cwi.data;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TransactionMapper {
    @Select("SELECT transaction_id as id, account_id as accountId, transaction_type as transactionType, amount, description, created_at as createdAt FROM transactions")
    List<Transaction> getAll();

    @Select("SELECT transaction_id as id, account_id as accountId, transaction_type as transactionType, amount, description, created_at as createdAt FROM transactions WHERE transaction_id = #{transactionId}")
    Transaction getById(int transactionId);

    @Insert("INSERT INTO transactions (account_id, transaction_type, amount, description, created_at) VALUES (#{accountId}, #{transactionType}, #{amount}, #{description}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Transaction transaction);

    @Update("UPDATE transactions SET account_id = #{accountId}, transaction_type = #{transactionType}, amount = #{amount}, description = #{description}, created_at = #{createdAt} WHERE transaction_id = #{transactionId}")
    void update(Transaction transaction);

    @Delete("DELETE FROM transactions WHERE transaction_id = #{transactionId}")
    void delete(int transactionId);
}
