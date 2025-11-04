package com.mycompany.peluqueriacanina.logica;
import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String celDuenio, String alergico, String atenEsp) {
        //Creamos al dueño y le asignamos sus valores.
        Duenio duenio = new Duenio();
        duenio.setCelDuenio(celDuenio);
        
        //Creamos a la mascota y le asignamos los valores.
        Mascota masco = new Mascota();
        masco.setRaza(raza);
        masco.setNombre(nombreMasco);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setUnDuenio(duenio);
        controlPersis.guardar(duenio,masco);
    }
}
