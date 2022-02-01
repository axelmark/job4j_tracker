package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * В классе можно производить следующие действия: 1. Регистрировать пользователя. 2. Удалять
 * пользователя из системы. 3. Добавлять пользователю банковский счет. У пользователя системы могут
 * быть несколько счетов. 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author axelmark
 * @version 1.0
 */
public class BankService {

    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами:
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод должен добавить пользователя в систему В методе должна быть проверка, что такого
     * пользователя еще нет в системе. Если он есть, то нового добавлять не надо.
     *
     * @param user - клиент.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод должен добавить новый счет к клиенту.
     *
     * @param passport - паспорт клиента.
     * @param account  - счет клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Этот метод ищет пользователя по номеру паспорта.
     *
     * @param passport - паспорт клиента.
     * @return - владельца документа.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
            .filter(x -> x.getPassport().equals(passport))
            .findFirst()
            .orElse(null);
    }

    /**
     * метод ищет счет пользователя по реквизитам
     *
     * @param passport  - паспорт клиента.
     * @param requisite - реквизиты счета.
     * @return - счет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
//        if (user != null) {
//            for (Account account : users.get(user)) {
//                if (account.getRequisite().equals(requisite)) {
//                    return account;
//                }
//            }
//        }
//        return null;
        return users.get(user)
            .stream()
            .filter(x -> x.getRequisite()
                .equals(requisite))
            .findFirst()
            .orElse(null);
    }

//    public Subject findBySubjectName(String account, String name) {
//        Student a = findByAccount(account);
//        if (a != null) {
//            return students.get(a)
//                .stream()
//                .filter(s -> s.getName().equals(name))
//                .findFirst()
//                .orElse(null);
//        }
//        return null;
//    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * <p>
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят), то метод
     * должен вернуть false.
     *
     * @param srcPassport   - паспорт отправителя.
     * @param srcRequisite  - реквизиты отправителя.
     * @param destPassport  - паспорт получателя.
     * @param destRequisite - реквизиты получателя.
     * @param amount        - сумма операции.
     * @return - true если перевод успешен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
        String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(srcPassport, destRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}