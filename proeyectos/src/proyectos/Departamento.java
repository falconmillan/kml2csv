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
public class Departamento {
    private int idd;
    private String nombre;
    private List <Empleado> empleados;

    public Departamento() {
        this.empleados = new ArrayList<>();
    }
    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    public List<Empleado> jefes(){
        List<Empleado> r= new ArrayList();
        for(Empleado x: this.empleados){
            if(x.getCategoria().compareTo("jefe")==0)r.add(x);
        }
        return r;
    }
}
