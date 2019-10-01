package by.tms.spring.service;

import by.tms.spring.model.ExpressionRecord;

import java.util.List;
import java.util.Map;

public interface HistoryService {

    void createHistoryForUser(Integer userId);

    void addRecordForUsersHistory(Integer userId, ExpressionRecord record);

    List<ExpressionRecord> getUserHistory(Integer userId);

    Map<Integer, List<ExpressionRecord>> getHistoryForAllUsers();

}
