package com.varun.mongodbpractice.service;

import com.varun.mongodbpractice.Dto.TaskDto;
import com.varun.mongodbpractice.Mapper.TaskMapper;
import com.varun.mongodbpractice.entity.Task;
import com.varun.mongodbpractice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto){
        Task tempTask = TaskMapper.INSTANCE.mapTaskDtoToTask(taskDto);
        tempTask.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        Task task = taskRepository.save(tempTask);
        return TaskMapper.INSTANCE.mapTasktoTaskDto(task);
    }
    public List<TaskDto> findAllTasks(){
      return taskRepository.findAll().stream().map(TaskMapper.INSTANCE::mapTasktoTaskDto).toList();
    }
}
