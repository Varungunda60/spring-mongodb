package com.varun.mongodbpractice.repository;

import com.varun.mongodbpractice.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
