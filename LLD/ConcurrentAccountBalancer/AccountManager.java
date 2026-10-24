package org.example.Study.LLD.ConcurrentAccountBalancer;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {

    private final AccountRepository accountRepository;


    public AccountManager(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public MoneyTransferResponse transferResponse(UUID from, UUID to,long timestamp, BigDecimal amount){
        Map<String,Account> accountIdMap = accountRepository.getAccountIdMap();
        if(accountIdMap.isEmpty()) throw new EmptyAccountIdMapException("Repository Not populated");

        Account fromAccount = accountIdMap.get(from.toString());
        Account toAccount = accountIdMap.get(to.toString());

        if(toAccount == null || fromAccount ==null) throw new EmptyAccountIdMapException("Repository Not populated");

        ReentrantLock lock1 = fromAccount.getAccountId().compareTo(toAccount.getAccountId()) >= 0 ? fromAccount.getLock() : toAccount.getLock();
        ReentrantLock lock2 =  lock1 == fromAccount.getLock() ? toAccount.getLock() : fromAccount.getLock();
        MoneyTransferResponse moneyTransferResponse = null;
        lock1.lock();
        try {
            lock2.lock();
            try {
                if((fromAccount.getBalance().compareTo(amount) >= 0)) {
                    fromAccount.unSafeSubtractBalance(amount);
                    toAccount.unSafeAddBalance(amount);
                    moneyTransferResponse = new MoneyTransferResponse(true,"transferred successfully");
                } else {
                    moneyTransferResponse = new MoneyTransferResponse(false,"transferred failed due to low balance");
                }

            } finally {
                lock2.unlock();
            }
        }finally {
            lock1.unlock();
        }
        System.out.println("started at" +timestamp + "finishedAt" + timestamp);
        return moneyTransferResponse;
    }



}

class MoneyTransferResponse {
    public MoneyTransferResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    boolean success;
    String message;
}

class EmptyAccountIdMapException extends RuntimeException {

    public EmptyAccountIdMapException(String message) {
        super(message);
    }
}
class EmptyAccountsException extends RuntimeException {

    public EmptyAccountsException(String message) {
        super(message);
    }
}

class AccountRepository{
    public Map<String, Account> getAccountIdMap() {
        return accountIdMap;
    }

    private final Map<String,Account> accountIdMap;

    AccountRepository(Map<String, Account> accountIdMap) {
        this.accountIdMap = accountIdMap;
    }

    public void addAccount(Account account){
        accountIdMap.put(account.accountId.toString(),account);
    }
}

class Account{
    public Account(UUID accountId, BigDecimal balance, ReentrantLock lock) {
        this.accountId = accountId;
        this.balance = balance;
        this.lock = lock;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    UUID accountId;
    BigDecimal balance;
    ReentrantLock lock;

    void unSafeAddBalance(BigDecimal amount) {
        balance = balance.add(amount);
    }

    void unSafeSubtractBalance(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    void lockSafeAddBalance(BigDecimal amount){
        lock.lock();
        try {
           balance = balance.add(amount);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    void lockSafeSubtractBalance(BigDecimal amount){
        lock.lock();
        try {
           balance = balance.subtract(amount);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    BigDecimal getBalance() {
        return balance;
    }

}


