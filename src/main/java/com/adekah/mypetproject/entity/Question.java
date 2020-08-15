package com.adekah.mypetproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Questions")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question_type")
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(name = "question_text", length = 1000)
    private String questionText;

    @Column(name = "question_image", length = 1000)
    private String questionImage;

    @JoinColumn(name = "question_quiz_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Quiz question_quiz;

    @JoinColumn(name = "answer_question_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answers;


}
