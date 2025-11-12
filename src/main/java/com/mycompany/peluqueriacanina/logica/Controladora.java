package com.mycompany.peluqueriacanina.logica;
import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones,String nombreDuenio, String celDuenio, String alergico, String atenEsp) {
        //Creamos al dueño y le asignamos sus valores.
        Duenio duenio = new Duenio();
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
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

    public List<Mascota> traerMascotas() {
        //Le pedimos a la persistencia que nos traiga las mascotas.
        return controlPersis.traerMascotas();
        
        
    }

    public void borrarMascota(int id) {
        controlPersis.borrarMascota(id);
    }

    
    public Mascota traerMascota(int id) {
       return controlPersis.traerMascota(id);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        //A la mascota hay que asignarle los nuevos valores.
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);
        masco.setObservaciones(observaciones);
        
        //Modifico mascota.
        controlPersis.modificarMascota(masco);
        
        //Seteo nuevos valores del dueño.
        Duenio dueno=this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
       return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
       controlPersis.modificarDuenio(dueno);
    }

    
}
