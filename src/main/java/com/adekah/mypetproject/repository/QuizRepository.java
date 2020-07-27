package com.adekah.mypetproject.repository;

import com.adekah.mypetproject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findById(long id);

    Quiz findByName(String name);
}
