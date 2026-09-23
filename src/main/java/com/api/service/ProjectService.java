package com.api.service;

import com.api.model.Project;
import com.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(int page, int size) {
        return projectRepository.findAll(page, size);
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public String createProject(Project project) {
        if (project.getName() == null || project.getName().isEmpty()) {
            throw new IllegalArgumentException("Project name is required");
        }
        int rows = projectRepository.save(project);
        return rows > 0 ? "Project created successfully" : "Failed to create project";
    }

    public String updateProject(Long id, Project project) {
        Optional<Project> existing = projectRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        int rows = projectRepository.update(id, project);
        return rows > 0 ? "Project updated successfully" : "Failed to update project";
    }

    public String deleteProject(Long id) {
        Optional<Project> existing = projectRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        int rows = projectRepository.deleteById(id);
        return rows > 0 ? "Project deleted successfully" : "Failed to delete project";
    }

    public List<Project> searchProjects(String keyword) {
        return projectRepository.search(keyword);
    }
}
