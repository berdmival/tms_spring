package by.tms.spring.service;

import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("historyService")
public class CalcHistoryService implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public CalcHistoryService(@Qualifier("historyRepository") HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void createHistoryForUser(long userId) {
        historyRepository.createNewHistory(userId);
    }

    @Override
    public void addRecordForUsersHistory(long userId, ExpressionRecord record) {
        historyRepository.addHistoryRecord(userId, record);
    }

    @Override
    public List<ExpressionRecord> getUserHistory(long userId) {
        return historyRepository.getHistoryById(userId);
    }

    @Override
    public Map<Long, List<ExpressionRecord>> getHistoryForAllUsers() {
        return historyRepository.getAllHistory();
    }
}
