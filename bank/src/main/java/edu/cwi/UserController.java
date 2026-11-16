package edu.cwi;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;

import edu.cwi.data.Account;
import edu.cwi.data.AccountMapper;
import edu.cwi.data.MyBatisConfig;
import edu.cwi.data.Transaction;
import edu.cwi.data.TransactionMapper;
import edu.cwi.data.User;
import edu.cwi.data.UserMapper;
import edu.cwi.data.enums.TransactionTypes;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class UserController implements CrudHandler {
    
    public UserController() {
    }

    @Override 
    public void getAll(Context ctx) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            ctx.json(mapper.getAll());
        }
    }

    @Override
    public void getOne(Context ctx, String resourceId) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            ctx.json(mapper.getById(Integer.parseInt(resourceId)));
        }
    }

    @Override
    public void create(Context ctx) {
        // Implement the logic to create a new user
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            TransactionMapper transactionMapper = session.getMapper(TransactionMapper.class);

            BigDecimal initialBalance = new BigDecimal("125.00");

            User user = ctx.bodyAsClass(User.class);
            
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            
            mapper.insert(user);
            
            Account account = new Account();

            account.setUserId(user.getId());
            account.setBalance(initialBalance);
            
            accountMapper.insert(account);
            
            Transaction transaction = new Transaction();

            transaction.setAccountId(account.getId());
            transaction.setTransactionType(TransactionTypes.DEPOSIT);
            transaction.setAmount(initialBalance);
            transaction.setDescription("Opening deposit.");

            transactionMapper.insert(transaction);

            session.commit();

            ctx.json(user);
        }
    }

    @Override
    public void update(Context ctx, String resourceId) {
        // Implement the logic to update a user
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = ctx.bodyAsClass(User.class);
            mapper.update(user);
            session.commit();
            ctx.json(user);
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {
        // Implement the logic to delete a user
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.delete(Integer.parseInt(resourceId));
            session.commit();
            ctx.json(Map.of("id", resourceId, "deleted", true));
        }
    }

    public User authenticateUser(Context ctx, String username, String password) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getByUsername(username);

            if(user != null) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                }
            }
            
            return null;
        }
    }
}
