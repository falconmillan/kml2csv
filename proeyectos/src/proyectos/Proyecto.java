package proyectos;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author medio
 */
public class Proyecto {
    private int idp;
    private String nombre;
    private String descripcion;
    private boolean acabado;
    private List <Empleado> empleados;

    public Proyecto() {
        this.empleados = new ArrayList<>();
    }

    public boolean isAcabado() {
        return acabado;
    }

    public void setAcabado(boolean acabado) {
        this.acabado = acabado;
    }

    /**
     * @return the idp
     */
    public int getIdp() {
        return idp;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the empleados
     */
    public List <Empleado> getEmpleados() {
        return empleados;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    /*
    @param objeto de la clase Empleado
    @return true si el empleado participa del proyecto. false en caso contrario.
    */
    public boolean isEmpleado(Empleado e){
        boolean r=false;
        for(Empleado x :this.empleados){
            if(x.getIde()==e.getIde())r=true;
        }
        return r;
    }
}
