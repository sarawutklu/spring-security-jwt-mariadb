package com.github.sarawutklu.spring_security_jwt.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
                @UniqueConstraint(columnNames = { "email" }) })
@Data
// @AllArgsConstructor
// @NoArgsConstructor
@EqualsAndHashCode
public class User {

        public User() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(min = 3, max = 50)
        private String name;

        @NotBlank
        @Size(min = 3, max = 50)
        private String username;

        @NaturalId
        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank
        @Size(min = 6, max = 100)
        private String password;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        public User(String name, String username, String email, String password) {
                this.name = name;
                this.username = username;
                this.email = email;
                this.password = password;
        }

}