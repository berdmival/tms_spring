package by.tms.spring.application.service;

import by.tms.spring.application.model.expression.ExpressionRecord;
import by.tms.spring.application.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("historyService")
public class CalcHistoryService implements HistoryService {

    final HistoryRepository historyRepository;

    @Autowired
    public CalcHistoryService(@Qualifier("historyRepository") HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void createHistoryForUser(Integer userId) {
        historyRepository.createNewHistory(userId);
    }

    @Override
    public void addRecordForUsersHistory(Integer userId, ExpressionRecord record) {
        historyRepository.addHistoryRecord(userId, record);
    }

    @Override
    public List<ExpressionRecord> getUserHistory(Integer userId) {
        return historyRepository.getHistoryById(userId);
    }

    @Override
    public Map<Integer, List<ExpressionRecord>> getHistoryForAllUsers() {
        return historyRepository.getAllHistory();
    }
}
