package com.adekah.mypetproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 70, unique = true)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "user_name", length = 100, unique = true)
    private String username;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @JoinColumn(name = "owner_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Quiz> quizzes;

}
