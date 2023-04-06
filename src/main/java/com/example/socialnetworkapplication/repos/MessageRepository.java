package com.example.socialnetworkapplication.repos;

import com.example.socialnetworkapplication.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {

    List<Message> findByTag(String tag);

}
