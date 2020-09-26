package com.example.demo.service;

import com.example.demo.model.Resume;

import java.util.List;

public interface IResumeService {
    void add(Resume resume);
    List<Resume> findAll();
    void update(Resume resume);
    void delete(int id);
    Resume findById(int id);
}
