/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

/**
 *
 * @author JUANCARLOS
 */
import com.udea.persistencia.Ciudad;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CiudadDAO {
    
    public void ingresarCiudad(Ciudad p){
         SessionFactory sf=null;
         Session session=null;
         Transaction tx=null;
         
         try{
         sf=HibernateUtil.getSessionFactory();
         session=sf.openSession();
         tx=session.beginTransaction();
         session.save(p);
         tx.commit();
         session.close();
         }catch(Exception e){
         tx.rollback();
         throw new RuntimeException("No se pudo guardar la Ciudad");
         }
    }
    
    
    
    public String consultarCiudad(int codigo){
         SessionFactory sf=HibernateUtil.getSessionFactory();
         Session session=sf.openSession();
         Ciudad p=(Ciudad) session.get(Ciudad.class, codigo);
         session.close();
         if(p!=null){
            return " La Ciudad de codigo " + p.getCodigo() + 
                    " cuyo nombre es " + p.getCiudad() + 
                    " en el departamento de " + p.getDepartamento() +
                    " tiene una temperatura actual de " + p.getTempActualCentigrados()+ 
                    " Grados centigrados y " + p.getTempActualFahrenheit()+
                    " Grados fahrenheit "+ p.getTempActualFahrenheit()+
                    " Humedad Actual: "+ p.getHumedadActual()+
                    " Condensacion : " +p.getCondensacionActual()+
                    " Presion actual: "+ p.getPresionActual()+
                    " Visibilidad de : "+ p.getVisibilidadActual()+
                    " Pronostico para los proximos tres dias : "+
                    " probabilidad precipitacion proximos tres dias : " +p.getPrecipitacionProxtres()+
                    " Descripcion proximos tres dias : " +p.getDescripcionProxtres()+
                    " Temperatura max_min proximos tres dias : " +p.getMaxMinProxtres()+
                    " precipitacion proximos tres dias :" +p.getPrecipitacionProxtres()+
                    " viento proximos tres dias : " +p.getVientoProxtres()+
                    " humedad proximos tres dias : " +p.getHumedadProxtres();

         }
         else {
           return "La Ciudad con codigo " + codigo + " no existe ";
         }
     }
    
     public List<Ciudad> verCiudads(){
       SessionFactory sf=HibernateUtil.getSessionFactory();
         Session session=sf.openSession();
        Query query= session.createQuery("from Ciudad");
        List<Ciudad> lista = query.list();
        return lista;
    }
    
    
    
    
}
