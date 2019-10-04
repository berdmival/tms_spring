package by.tms.spring.repository;

import by.tms.spring.model.ExpressionRecord;

import java.util.List;
import java.util.Map;

public interface HistoryRepository {

    void createNewHistory(long userId);

    void addHistoryRecord(long userId, ExpressionRecord record);

    List<ExpressionRecord> getHistoryById(long userId);

    Map<Long, List<ExpressionRecord>> getAllHistory();

}
