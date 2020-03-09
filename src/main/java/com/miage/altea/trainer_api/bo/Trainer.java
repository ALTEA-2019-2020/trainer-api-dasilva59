package com.miage.altea.trainer_api.bo;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {

    @Id
    private String name;

    @ElementCollection
    private List<Pokemon> team;
    @Column
    private String password;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
    @Bean
    public String getPassword() {return this.password;
    }
    @Bean
    public void setPassword(String password) {this.password=password;
    }
}
