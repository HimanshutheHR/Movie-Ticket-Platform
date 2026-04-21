package com.hr.movieticket.bookings.repository;

import com.hr.movieticket.bookings.entity.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM ShowSeat s WHERE s.id IN :ids")
    List<ShowSeat> findSeatsForUpdate(@Param("ids") List<Long> ids);
}
