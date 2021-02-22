package com.abc.order.repository;

import com.abc.order.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileEntityRepository extends CrudRepository<FileEntity, Long> {
}
