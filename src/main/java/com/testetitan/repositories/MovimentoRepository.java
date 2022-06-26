package com.testetitan.repositories;

import com.testetitan.entities.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MovimentoRepository extends JpaRepository<Movimento,Integer> {

    Movimento findByPlaca(String placa);

    @Query(value = "SELECT * FROM movimento.movimento WHERE valor_pago = 0.0;", nativeQuery = true)
    List<Movimento> findParkedCars();

}
