package pl.edu.zse.ListaZadan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.ListaZadan.model.Zadanie;
import pl.edu.zse.ListaZadan.repository.ZadanieRepository;

import java.util.List;

@Service
public class ZadanieService implements IZadanieService {

    private final ZadanieRepository zadanieRepository;


    @Autowired
    public ZadanieService(ZadanieRepository zadanieRepository) {
        this.zadanieRepository = zadanieRepository;
    }

    @Override
    public void addZadanie(Zadanie zadanie) {
        zadanieRepository.save(zadanie);
    }

    @Override
    public List<Zadanie> getAllZadania() {
        return zadanieRepository.findAll();
    }

    @Override
    public void removeZadanie(Zadanie zadanie) {
        zadanieRepository.delete(zadanie);
    }

    @Override
    public void removeZadanieById(Long id) {
        zadanieRepository.deleteById(id);
    }

    @Override
    public void editZadanie(Zadanie zadanie) {
        if(zadanieRepository.existsById(zadanie.getId())) zadanieRepository.save(zadanie);
    }

    @Override
    public void removeZadanieById(Integer id) {

    }
}
