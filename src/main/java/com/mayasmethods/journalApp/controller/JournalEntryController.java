package com.mayasmethods.journalApp.controller;

import com.mayasmethods.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable long myId) {
        return journalEntries.remove(myId);
    }
    @PutMapping("id/{Id}")
    public JournalEntry updateEntryById(@PathVariable long Id, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(Id, myEntry);
    }
}