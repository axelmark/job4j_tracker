package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
            new Account("123", "Petr Arsentev", "eDer3432f"),
            new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
            Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
            )
        );
        assertThat(NotifyAccount.sent(accounts)).isEqualTo(expect);
    }

    @Test
    public void sentNoDublicat() {
        List<Account> accounts = Arrays.asList(
            new Account("123", "Petr Arsentev", "eDer3432f"),
            new Account("123", "Petr Arsentev", "eDer3432f"),
            new Account("142", "Petr Arsentev", "000001")

        );
        HashSet<Account> expect = new HashSet<>(
            Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
            )
        );
        assertThat(NotifyAccount.sent(accounts)).isEqualTo(expect);
    }
}