package by.tms.spring.service;

import by.tms.spring.expression.CalcExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dao")
public class DAOService {
    private List<CalcExpression> history;

    public List getHistory() {
        return history;
    }

    @Autowired
    public DAOService(@Qualifier("history") List<CalcExpression> history) {
        this.history = history;
    }

    public void addToHistory (CalcExpression historyItem) {
        history.add(historyItem);
    }
}
