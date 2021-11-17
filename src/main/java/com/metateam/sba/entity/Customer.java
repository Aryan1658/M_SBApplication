package com.metateam.sba.entity;


import com.metateam.sba.enums.IdType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@Entity
@Table(name = "tbl_customer", uniqueConstraints = {
        @UniqueConstraint(name = "unique_customer_mobile", columnNames = "mobile_number"),
        @UniqueConstraint(name = "unique_customer_email", columnNames = "email")
})
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @SequenceGenerator(name = "tbl_customer_id_sequence", initialValue = 1, sequenceName = "tbl_customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_customer_id_sequence")
    private Integer id;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mobile_number", length = 10)
    private String mobileNumber;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "date_of_birth")
    private Timestamp timestamp;

    @Column(name = "is_premium")
    private Boolean isPremium;

    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column(name = "id_value", length = 30)
    private String idValue;


}
