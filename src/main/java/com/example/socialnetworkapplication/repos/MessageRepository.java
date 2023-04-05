package com.example.socialnetworkapplication.repos;

import com.example.socialnetworkapplication.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {

}
