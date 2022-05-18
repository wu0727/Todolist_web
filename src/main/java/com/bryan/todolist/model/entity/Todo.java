package com.bryan.todolist.model.entity;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String task;

    @Column
    Integer status;

    @Column
    String createTime;

    @Column
    String updateTime;
}
