package com.ac2.lutadores.repositorio;

import com.ac2.lutadores.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LutadorRepository extends JpaRepository<Lutador, Integer> {
    @Query("select f Lutador l where vida > 0")
    List<Lutador> findAllVivos();

    @Query("select f Lutador l where vida = 0")
    List<Lutador> findAllMortos();
}