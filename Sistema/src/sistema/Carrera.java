/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author Fernando
 */
public class Carrera {
    private int id;
    private String nombre;

    public Carrera() {
        this.id = id;
        this.nombre = nombre;
    }
   

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return getNombre().trim();
    }
     
}
