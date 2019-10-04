package by.tms.spring.repository;

import by.tms.spring.model.ExpressionRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("historyRepository")
public class CalcHistoryRepository implements HistoryRepository {

    private Map<Long, List<ExpressionRecord>> history;

    public CalcHistoryRepository(Map<Long, List<ExpressionRecord>> history) {
        this.history = history;
    }

    @Override
    public Map<Long, List<ExpressionRecord>> getAllHistory() {
        return history;
    }

    @Override
    public void createNewHistory(long userId) {
        history.put(userId, new ArrayList<>());
    }

    @Override
    public void addHistoryRecord(long userId, ExpressionRecord record) {
        history.get(userId).add(record);
    }

    @Override
    public List<ExpressionRecord> getHistoryById(long userId) {
        return history.get(userId);
    }
}
