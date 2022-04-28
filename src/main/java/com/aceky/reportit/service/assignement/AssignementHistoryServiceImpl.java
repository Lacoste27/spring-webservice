package com.aceky.reportit.service.assignement;

import java.time.LocalDateTime;

import com.aceky.reportit.data.models.AssignementHistories;
import com.aceky.reportit.data.models.Report;
import com.aceky.reportit.data.payloads.response.MessageResponse;
import com.aceky.reportit.data.repositories.AssignementHistoriesRepository;
import com.aceky.reportit.data.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignementHistoryServiceImpl implements AssignementHistoryService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignementHistoriesRepository assignementHistoriesRepository;

    @Override
    public MessageResponse add(Report report , Integer setter_id) {
        AssignementHistories assignementHistories = new AssignementHistories();
        assignementHistories.setReport(report);
        LocalDateTime created_at = LocalDateTime.now();
        assignementHistories.setReport(report);
        assignementHistories.setUser(userRepository.findById(setter_id).get());
        assignementHistories.setCreated_at(created_at);
        assignementHistories.setSetted_to(report.getState());
        assignementHistoriesRepository.save(assignementHistories);
        return new MessageResponse("Assignement histories");
    }

}
