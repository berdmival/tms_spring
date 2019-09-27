package by.tms.spring.application.repository;

import by.tms.spring.application.model.expression.CalcExpression;
import by.tms.spring.application.model.expression.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("historyRepository")
public class CalcHistoryRepository {

    private Map<String, List<Expression>> history;

    @Autowired
    public CalcHistoryRepository(@Qualifier("history") Map<String, List<Expression>> history) {
        this.history = history;
    }

    public Map<String, List<Expression>> getAllHistory() {
        return history;
    }

    public List<Expression> getUserHistory(String userId) {
        return history.get(userId);
    }

    public void addToHistory(String userId, CalcExpression historyItem) {
        history.get(userId).add(historyItem);
    }
}
