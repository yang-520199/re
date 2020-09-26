package com.example.demo.service;

import com.example.demo.mapper.ResumeMapper;
import com.example.demo.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements IResumeService{
    @Autowired
    private ResumeMapper resumeMapper;


    public void add(Resume resume) {
        resumeMapper.add(resume);
    }


    public List<Resume> findAll() {
        return resumeMapper.findAll();
    }


    public void update(Resume resume) {
        resumeMapper.update(resume);
    }


    public void delete(int id) {
        resumeMapper.delete(id);
    }


    public Resume findById(int id) {
        return resumeMapper.findById(id);
    }
}
