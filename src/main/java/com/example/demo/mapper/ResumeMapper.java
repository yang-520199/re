package com.example.demo.mapper;

import com.example.demo.model.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ResumeMapper {
    void add(Resume resume);
    void update(Resume resume);
    void delete(int id);
    Resume findById(int id);
    List<Resume> findAll();

}
