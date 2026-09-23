package com.api.controller;

import com.api.model.Project;
import com.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Project> projects = projectService.getAllProjects(page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("data", projects);
        response.put("page", page);
        response.put("size", size);
        response.put("count", projects.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        if (project.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Project not found with id: " + id));
        }
        return ResponseEntity.ok(project.get());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createProject(
            @RequestBody Project project) {
        String message = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(Map.of("message", message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateProject(
            @PathVariable Long id,
            @RequestBody Project project) {
        String message = projectService.updateProject(id, project);
        return ResponseEntity.ok(Map.of("message", message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProject(
            @PathVariable Long id) {
        String message = projectService.deleteProject(id);
        return ResponseEntity.ok(Map.of("message", message));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(
            @RequestParam String keyword) {
        List<Project> results = projectService.searchProjects(keyword);
        return ResponseEntity.ok(results);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", e.getMessage()));
    }
}
