package by.tms.spring.application.repository;

import by.tms.spring.application.model.expression.ExpressionRecord;

import java.util.List;
import java.util.Map;

public interface HistoryRepository {

    void createNewHistory(int userId);

    void addHistoryRecord(int userId, ExpressionRecord record);

    List<ExpressionRecord> getHistoryById(int userId);

    Map<Integer, List<ExpressionRecord>> getAllHistory();

}
