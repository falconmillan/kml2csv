/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;


import java.util.Iterator;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import static proyectos.Proyectos.ldep;

/**
 *
 * @author jcfalcon
 */
public class Consultas {
    private String basededatos;
    private String salida;

    public Consultas(String basededatos) {
        this.basededatos = basededatos;
    }

    public String getBasededatos() {
        return basededatos;
    }

    public void setBasededatos(String basededatos) {
        this.basededatos = basededatos;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public void consulta1(String nick){
     ODB  db;
     if(!basededatos.isEmpty()){
         db =ODBFactory.open(basededatos);
         ICriterion criterio = Where.equal("nick",nick);
         IQuery query = new CriteriaQuery(Empleado.class, criterio);
         Objects <Empleado> e = db.getObjects(query);
         Empleado dummy;
         if(e.size()==1){
             dummy=e.next();
             String datos="ID:"+dummy.getIde()+" NICK: "+dummy.getNick();
             datos=datos+" DEPARTAMENTO: "+dummy.getDep().getNombre()
                     +" CATEGORÍA: "+dummy.getCategoria();
             
             System.out.println(datos);
             Iterator cursor10=dummy.getProyectos().iterator();
             while(cursor10.hasNext()){
                 Proyecto p;
                 p=(Proyecto)cursor10.next();
                 String datapry= "\tNOMBRE_PROYECTO:"+p.getNombre()+
                         " DESCRIPCION: "+p.getDescripcion();
                 System.out.println(datapry);
                 
             }
         }else{
             System.out.println("Consulta1.Se esperaba un solo resultado.");
         }
         
         
         db.close();
     }else{
         System.out.println("Consulta1.Base de datos nula.");
     }
    }
}
