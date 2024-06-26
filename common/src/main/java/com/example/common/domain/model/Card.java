package com.example.common.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    private String number;
    private String date;//cos there will be only two numbers, month and day
    private String cvv;

    @OneToMany
    @JoinTable(
            name = "cards_transactions",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Card(Account account) {
        this.account = account;
    }
}

