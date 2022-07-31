package com.Portfolio.Ariel.Repository;

import com.Portfolio.Ariel.Entity.Curso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcursoRepository extends JpaRepository<Curso, Integer> {

    public Optional<Curso> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
