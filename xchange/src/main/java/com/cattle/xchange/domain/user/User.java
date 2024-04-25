package com.cattle.xchange.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tuser")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bd_coduser")
    private UUID id;

    @Column(name = "bd_doc")
    private String document;

    @Column(name = "bd_name")
    private String name;

    @Column(name = "bd_lastname")
    private String lastName;

    @Column(name = "bd_email")
    private String email;

    @Column(name = "bd_password")
    private String password;

    @Column(name = "bd_createdate")
    private LocalDate creationDate;

    public User(String document, String name, String lastName, String email, String password, LocalDate now) {
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.creationDate = now;

    }
}
