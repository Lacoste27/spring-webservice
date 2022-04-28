package com.aceky.reportit.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import com.aceky.reportit.data.payloads.request.AssignementHistoriesRequest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "assignementHistories")
public class AssignementHistories {
    @Id
    @GeneratedValue(generator = "increment")
    Integer id;
    @OneToOne
    @JoinColumn(name = "report_id")
    Report report;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    LocalDateTime created_at;
    Integer setted_to;
    public static AssignementHistories from(AssignementHistoriesRequest assignementHistories) {
        AssignementHistories assingnement = new AssignementHistories();
        assingnement.setCreated_at(assignementHistories.getDate());
        assingnement.setSetted_to(assignementHistories.getSetted_to());
        return assingnement;
    }
}
