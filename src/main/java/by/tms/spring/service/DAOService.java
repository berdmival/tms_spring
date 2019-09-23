package by.tms.spring.service;

import by.tms.spring.expression.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dao")
public class DAOService {
    private List<Expression> history;

    public List<Expression> getHistory() {
        return history;
    }

    @Autowired
    public DAOService(@Qualifier("history") List<Expression> history) {
        this.history = history;
    }

    public void addToHistory(Expression historyItem) {
        history.add(historyItem);
    }
}
