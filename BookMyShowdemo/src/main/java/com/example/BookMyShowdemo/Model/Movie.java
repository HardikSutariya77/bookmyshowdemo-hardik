package com.example.BookMyShowdemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;


    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Show> shows;


}
