package com.tdl.ToDo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_no")
    private int categoryNo;
    private String categoryContent;

    @OneToMany(mappedBy = "category")
    private List<Todo> todoList = new ArrayList<>();
}
