package com.sotnikov.memstorage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sotnikov.memstorage.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {



}
