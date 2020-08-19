package com.adekah.mypetproject.repository;

import com.adekah.mypetproject.entity.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

