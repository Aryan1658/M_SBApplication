package com.metateam.sba.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tbl_transaction_type_master", uniqueConstraints = {})
public class TransactionType implements Serializable {

    @Id
    @SequenceGenerator(name = "tbl_transaction_type_sequence", initialValue = 1, sequenceName = "tbl_transaction_type_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_transaction_type_sequence")
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "code", length = 10)
    private String code;

}
