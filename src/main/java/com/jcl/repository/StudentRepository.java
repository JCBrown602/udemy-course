package com.jcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcl.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
