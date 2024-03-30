package br.com.fiap.hubhotels.quarto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    @Transactional
    void deleteByHotelId(Long hotelId);
 }