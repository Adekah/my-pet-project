package com.adekah.mypetproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@Table(name = "answers")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer_text", length = 1000)
    private String answerText;
    
    @Column(name = "is_true_answer")
    private Boolean isTrueAnswer;

    @JoinColumn(name = "answer_question_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Question question;
}
