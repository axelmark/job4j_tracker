package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accountList = users.get(user.get());
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
            .stream()
            .filter(x -> x.getPassport().equals(passport))
            .findFirst();
    }

    /**
     * метод ищет счет пользователя по реквизитам
     *
     * @param passport  - паспорт клиента.
     * @param requisite - реквизиты счета.
     * @return - счет.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                .stream()
                .filter(x -> x.getRequisite().equals(requisite))
                .findFirst();
        }
        return rsl;
    }

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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(srcPassport, destRequisite);

        if (srcAccount.isPresent() && destAccount.isPresent()
            && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}