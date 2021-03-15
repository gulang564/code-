package com.test.repository;

import com.test.model.FileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileModel,String> {
}
