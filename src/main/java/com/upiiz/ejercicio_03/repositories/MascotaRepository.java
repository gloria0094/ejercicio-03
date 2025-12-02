package com.upiiz.ejercicio_03.repositories;
import com.upiiz.ejercicio_03.models.Mascota;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface MascotaRepository {

    public List<Mascota> findAll();
    public Mascota getMascota(int id);
    public void save(Mascota mascota);
    public void delete(int id);
    public void update(Mascota mascota);
}

