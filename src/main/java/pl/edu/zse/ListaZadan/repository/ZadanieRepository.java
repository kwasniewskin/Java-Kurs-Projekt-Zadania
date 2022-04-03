package pl.edu.zse.ListaZadan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.zse.ListaZadan.model.Zadanie;

public interface ZadanieRepository extends JpaRepository<Zadanie, Long> {

}
