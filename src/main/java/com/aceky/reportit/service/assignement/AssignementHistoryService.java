package com.aceky.reportit.service.assignement;

import com.aceky.reportit.data.models.Report;
import com.aceky.reportit.data.payloads.response.MessageResponse;

import org.springframework.stereotype.Component;

@Component
public interface AssignementHistoryService {
    MessageResponse add(Report report ,Integer setter_id);
}
