package by.tms.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dao")
public class DAOService {
    List history;

    public List getHistory() {
        return history;
    }

    @Autowired
    public DAOService(@Qualifier("history") List history) {
        this.history = history;
    }

    public void addToHistory (Object historyItem) {
        history.add(historyItem);
    }}
