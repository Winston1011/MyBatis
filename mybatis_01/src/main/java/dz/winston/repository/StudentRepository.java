package dz.winston.repository;

import dz.winston.entity.Student;

public interface StudentRepository {
    public Student findById(int id);
}
