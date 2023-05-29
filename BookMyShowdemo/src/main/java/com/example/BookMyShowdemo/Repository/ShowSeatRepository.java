package com.example.BookMyShowdemo.Repository;

import com.example.BookMyShowdemo.Model.Show;
import com.example.BookMyShowdemo.Model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
}
