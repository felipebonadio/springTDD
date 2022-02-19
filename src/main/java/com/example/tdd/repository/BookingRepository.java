package com.example.tdd.repository;

import com.example.tdd.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {

    Optional<BookingModel> findByReserveName(String name);
}
