package com.mayasmethods.journalApp.controller;

import com.mayasmethods.journalApp.entity.JournalEntry;
import com.mayasmethods.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.getEntryById(myId).orElse(null);
    }
    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteEntryById(myId);
       return true;
    }
    @PutMapping("id/{Id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId Id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getEntryById(Id).orElse(null);
        if(old != null) {
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}