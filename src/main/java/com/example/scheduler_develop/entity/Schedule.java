package com.example.scheduler_develop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    //사용자 : 일정 = 1:N
    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User user;

    public Schedule(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

    //parameter가 있는 생성자를 만들면 기본 생성자도 만들어줘야함
    public Schedule() {}

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
