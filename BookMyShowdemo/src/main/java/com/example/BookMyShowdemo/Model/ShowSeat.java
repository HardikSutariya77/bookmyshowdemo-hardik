package com.example.BookMyShowdemo.Model;

import com.example.BookMyShowdemo.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;


    private int rate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;


    private boolean booked;


    private Date bookedDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Ticket ticket;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Show show;

}
