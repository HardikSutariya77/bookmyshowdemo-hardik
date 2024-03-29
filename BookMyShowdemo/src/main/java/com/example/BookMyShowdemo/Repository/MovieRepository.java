package com.example.BookMyShowdemo.Repository;

import com.example.BookMyShowdemo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    boolean existsByName(String name);
}
