package com.test.repository;

import com.test.entity.Student;

public interface StudentRepository {
    public Student getById(Integer id);
    public Student findByStuId(Integer id);
}
