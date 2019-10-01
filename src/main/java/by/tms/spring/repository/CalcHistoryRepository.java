package by.tms.spring.repository;

import by.tms.spring.model.ExpressionRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("historyRepository")
public class CalcHistoryRepository implements HistoryRepository {

    private Map<Integer, List<ExpressionRecord>> history;

    public CalcHistoryRepository(Map<Integer, List<ExpressionRecord>> history) {
        this.history = history;
    }

    @Override
    public Map<Integer, List<ExpressionRecord>> getAllHistory() {
        return history;
    }

    @Override
    public void createNewHistory(int userId) {
        history.put(userId, new ArrayList<>());
    }

    @Override
    public void addHistoryRecord(int userId, ExpressionRecord record) {
        history.get(userId).add(record);
    }

    @Override
    public List<ExpressionRecord> getHistoryById(int userId) {
        return history.get(userId);
    }
}
