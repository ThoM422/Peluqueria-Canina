package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import java.util.List;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa=new DuenioJpaController();
    MascotaJpaController mascotaJpa=new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //crear en la BD el dueño.
        duenioJpa.create(duenio);
        
        //crear en la BD la mascota.
        mascotaJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
       //Busca todos los registros de la tabla de datos y los trae.
        return mascotaJpa.findMascotaEntities();
    }
    
}
