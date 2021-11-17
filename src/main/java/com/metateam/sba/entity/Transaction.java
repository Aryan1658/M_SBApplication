package com.metateam.sba.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tbl_transaction")
public class Transaction implements Serializable {

    @Id
    @SequenceGenerator(name = "tbl_transaction_sequence", initialValue = 1, sequenceName = "tbl_transaction_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_transaction_sequence")
    private Integer id;

    @Column(name="amount")
    private Double amount;

    @Column(name ="created_date")
    private Date createdDate;

    @ManyToOne(targetEntity = TransactionType.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_type_id",foreignKey = @ForeignKey(name= "FK_TRANSACTION_TRANSACTIONTYPE"))
    private TransactionType transactionType;

    @ManyToOne(targetEntity = Account.class,fetch = FetchType.LAZY)
    @JoinColumn(name="account_id",foreignKey = @ForeignKey(name ="FK_TRANSACTION_ACCOUNT"))
    private Account account;

    private String status;
}
