package com.example.BookMyShowdemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allottedSeat;

    private int amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Show show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL) //aa total seats che j aapni pase availabl che booking apvamate
    @JsonIgnore
    private List<ShowSeat> showSeats;
}
