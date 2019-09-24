package by.tms.spring.application.repository;

import by.tms.spring.application.expression.CalcExpression;
import by.tms.spring.application.expression.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("historyRepository")
public class HistoryRepository {
    private List<Expression> history;

    public List<Expression> getHistory() {
        return history;
    }

    @Autowired
    public HistoryRepository(@Qualifier("history") List<Expression> history) {
        this.history = history;
    }

    public void addToHistory(CalcExpression historyItem) {
        history.add(historyItem);
    }
}
