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
public class Empleado {
    private int ide;
    private String nick;
    private String categoria;
    private int antiguedad;
    private Departamento dep;
    private List <Proyecto> proyectos;

    public Empleado() {
        this.proyectos = new ArrayList<>();
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    /*
    @param Objeto de la clase Proyecto
    @return true si l empleado participa en el proyecto p; false en otro caso.
    */
    public boolean isProyecto(Proyecto p){
        boolean r=false;
        for(Proyecto x : this.proyectos){
            if(x.getIdp()==p.getIdp())r=true;
        }
        return r;
    }
    }
    


       
 
   


