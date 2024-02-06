package com.varun.mongodbpractice.Mapper;

import com.varun.mongodbpractice.Dto.TaskDto;
import com.varun.mongodbpractice.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task mapTaskDtoToTask(TaskDto taskDto);
    TaskDto mapTasktoTaskDto(Task task);
}
