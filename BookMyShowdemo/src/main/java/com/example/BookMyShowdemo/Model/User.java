package com.example.BookMyShowdemo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String mobile;

    private String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Ticket> tickets;
}
