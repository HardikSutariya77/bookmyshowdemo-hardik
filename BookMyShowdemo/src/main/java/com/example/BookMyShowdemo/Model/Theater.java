package com.example.BookMyShowdemo.Model;

import com.example.BookMyShowdemo.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;

    private String address;

    @Enumerated(EnumType.STRING)
    private TheatreType theaterType;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)  //show e theater ni andar no show che j user nai nakki kare etle aapde json ignor karelu ch
    @JsonIgnore
    private List<Show> shows;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)  //theater banavti
    @JsonIgnore
    private List<TheaterSeat> theaterSeats;
}
