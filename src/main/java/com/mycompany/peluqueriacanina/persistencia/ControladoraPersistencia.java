package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    public void borrarMascota(int id) {
        try {
            mascotaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int id) {
        return mascotaJpa.findMascota(id);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   


    
    }
    
    

