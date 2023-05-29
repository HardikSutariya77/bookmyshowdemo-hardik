package com.example.BookMyShowdemo.Repository;

import com.example.BookMyShowdemo.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
