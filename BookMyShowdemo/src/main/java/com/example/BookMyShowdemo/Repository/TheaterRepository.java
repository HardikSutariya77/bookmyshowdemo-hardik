package com.example.BookMyShowdemo.Repository;

import com.example.BookMyShowdemo.Model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}
