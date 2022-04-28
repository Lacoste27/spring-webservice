package com.aceky.reportit.data.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reportTypes")
public class ReportType {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    String name;
    String color;
    // @JsonManagedReference
    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
    // "type")
    // private Set<Report> report;

}
