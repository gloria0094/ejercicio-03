package com.upiiz.ejercicio_03.services;
import com.upiiz.ejercicio_03.models.Mascota;
import com.upiiz.ejercicio_03.repositories.MascotaRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

//Extend - Herencia - Heredar las propiedades de otra clase
//Implements - Usar o implementar los métodos de otra clase
@Service
public class MascotasServices implements MascotaRepository {
    //Requerimos
    //1.- Acceso a una base de datos - Aun no
    //2.- Acceso a un listado en MEMORIA - Este si

    private List<Mascota> mascotas;
    private int lastId = 0;

    public MascotasServices() {
        //Evitar en NULL pointer Exception
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Pluto",5,"Mascota Mick"));
        mascotas.add(new Mascota(2,"Firulais",8,"Un perro muy noble"));
        mascotas.add(new Mascota(3,"Scoby Doo",8,"Perro miedoso que resuelve"));
        lastId=3;
    }

    @Override
    public void save(Mascota mascota) {
        lastId++;
        mascota.setId(lastId);
        mascotas.add(mascota);
    }

    @Override
    public List<Mascota> findAll() {
        return mascotas;
    }

    //Investigamos programacion FUNCIONAL
    @Override
    public Mascota getMascota(int id) {
        return mascotas.stream()
                .filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(int id) {
        mascotas.removeIf(m -> m.getId() == id);
    }

    @Override
    public void update(Mascota mascota) {
        //Como es por referencia, se actualiza en el listado de mascotas
        Mascota m = getMascota(mascota.getId());
        m.setNombre(mascota.getNombre());
        m.setEdad(mascota.getEdad());
        m.setObservaciones(mascota.getObservaciones());
    }
}