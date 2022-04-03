package pl.edu.zse.ListaZadan.service;

import pl.edu.zse.ListaZadan.model.Zadanie;
import java.util.List;


public interface IZadanieService {
    void addZadanie(Zadanie zadanie);

    List<Zadanie> getAllZadania();

    void removeZadanie(Zadanie zadanie);

    void removeZadanieById(Long id);

    void editZadanie(Zadanie zadanie);

    void removeZadanieById(Integer id);
}
