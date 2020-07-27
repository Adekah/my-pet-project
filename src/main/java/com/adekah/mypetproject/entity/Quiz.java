package com.adekah.mypetproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "quizzes")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quiz extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "explanation", length = 500)
    private String explanation;

    @Column(name = "number_of_questions")
    private byte numberOfQuestions;

    @JoinColumn(name = "owner_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User owner;


}
