package com.mayasmethods.journalApp.service;


import com.mayasmethods.journalApp.entity.User;
import com.mayasmethods.journalApp.repository.JournalUserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private JournalUserRepository journaluserRepository;

    public void saveEntry(User user) {
        journaluserRepository.save(user);
    }
    public List<User> getAll() {
        return journaluserRepository.findAll();
    }
    public Optional<User> getEntryById(ObjectId id) {
        return journaluserRepository.findById(id);
    }
    public void deleteEntryById(ObjectId id) {
        journaluserRepository.deleteById(id);
    }
    public User findByUsername(String username) {
        return journaluserRepository.findByUsername(username);
    }

}
