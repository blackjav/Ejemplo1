/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author javs
 */
public class Alumno {
    
    private String nombre;
    private String paterno;
    private int id;
    

    public Alumno() {
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", paterno=" + paterno + ", carrera=" + carrera + ", id=" + id + '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getId() {
        return id;
    }
    private String carrera;
    
    
    
}
