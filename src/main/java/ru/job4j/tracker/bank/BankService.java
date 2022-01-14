package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account != null && account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
        String destRequisite, double amount) {
        User scrUser = findByPassport(srcPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (!srcAccount.getRequisite().equals(srcRequisite) || srcAccount.getBalance() < amount) {
            return false;
        }

        User destUser = findByPassport(destPassport);
        Account destAccount = findByRequisite(srcPassport, destRequisite);
        List<Account> destListAccounts = users.get(destUser);
        destAccount.setBalance(destAccount.getBalance() + amount);
        users.putIfAbsent(destUser, destListAccounts);
        return true;
    }
}