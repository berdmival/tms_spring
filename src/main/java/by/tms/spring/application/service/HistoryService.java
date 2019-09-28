package by.tms.spring.application.service;

import by.tms.spring.application.model.expression.ExpressionRecord;

import java.util.List;
import java.util.Map;

public interface HistoryService {

    void createHistoryForUser(Integer userId);

    void addRecordForUsersHistory(Integer userId, ExpressionRecord record);

    List<ExpressionRecord> getUserHistory(Integer userId);

    Map<Integer, List<ExpressionRecord>> getHistoryForAllUsers();

}
