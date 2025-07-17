package com.test.repository;

import com.test.entity.Class;
import com.test.entity.Student;

import java.util.List;

public interface StudentRepository {
    public Student getById(Integer id);
}
