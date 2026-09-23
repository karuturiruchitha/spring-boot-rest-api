package com.api.repository;

import com.api.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Project> projectMapper = (rs, rowNum) -> {
        Project p = new Project();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("name"));
        p.setDescription(rs.getString("description"));
        p.setStatus(rs.getString("status"));
        p.setClientName(rs.getString("client_name"));
        p.setBudget(rs.getDouble("budget"));
        p.setGmPercent(rs.getDouble("gm_percent"));
        p.setCreatedBy(rs.getString("created_by"));
        return p;
    };

    public List<Project> findAll(int page, int size) {
        String sql = "SELECT * FROM projects LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, projectMapper, size, page * size);
    }

    public Optional<Project> findById(Long id) {
        String sql = "SELECT * FROM projects WHERE id = ?";
        List<Project> results = jdbcTemplate.query(sql, projectMapper, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public int save(Project project) {
        String sql = """
            INSERT INTO projects 
            (name, description, status, client_name, budget, gm_percent, created_by)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
        return jdbcTemplate.update(sql,
            project.getName(), project.getDescription(),
            project.getStatus(), project.getClientName(),
            project.getBudget(), project.getGmPercent(),
            project.getCreatedBy()
        );
    }

    public int update(Long id, Project project) {
        String sql = """
            UPDATE projects SET 
            name = ?, description = ?, status = ?,
            client_name = ?, budget = ?, gm_percent = ?
            WHERE id = ?
            """;
        return jdbcTemplate.update(sql,
            project.getName(), project.getDescription(),
            project.getStatus(), project.getClientName(),
            project.getBudget(), project.getGmPercent(), id
        );
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM projects WHERE id = ?", id);
    }

    public List<Project> search(String keyword) {
        String sql = "SELECT * FROM projects WHERE name LIKE ? OR status LIKE ?";
        String pattern = "%" + keyword + "%";
        return jdbcTemplate.query(sql, projectMapper, pattern, pattern);
    }
}
