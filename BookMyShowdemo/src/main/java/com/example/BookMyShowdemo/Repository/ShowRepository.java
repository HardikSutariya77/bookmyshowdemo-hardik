package com.example.BookMyShowdemo.Repository;

import com.example.BookMyShowdemo.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
