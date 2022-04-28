package com.aceky.reportit.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    private String name;
    // @JsonManagedReference
    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
    // "region")
    // private Set<Report> report;
}
