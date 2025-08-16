package com.mayasmethods.journalApp.repository;
import com.mayasmethods.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalUserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
