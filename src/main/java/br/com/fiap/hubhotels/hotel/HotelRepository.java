package br.com.fiap.hubhotels.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel, Long> { 

    @Query("SELECT u.usuario.id, COUNT(u) FROM Hotel u GROUP BY u.usuario.id")
    List<Object[]> countHotelsPerUser();

}