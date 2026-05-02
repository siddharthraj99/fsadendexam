package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;

    public Project save(Project p) {
        return repo.save(p);
    }

    public Project getById(int id) {
        return repo.findById(id).orElse(null);
    }
}