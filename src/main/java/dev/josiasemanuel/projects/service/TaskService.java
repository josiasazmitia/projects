package dev.josiasemanuel.projects.service;

import dev.josiasemanuel.projects.model.Project;
import dev.josiasemanuel.projects.model.Task;
import dev.josiasemanuel.projects.repository.ProjectRepository;
import dev.josiasemanuel.projects.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public List<Task> findTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }


}
