/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.service;


import com.udea.dao.CiudadDAO;
import com.udea.persistencia.Ciudad;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author JUANCARLOS
 */
@WebService(serviceName = "CiudadWS")
@XmlSeeAlso({Ciudad.class})
public class CiudadWS {

    /**
     * This is a sample web service operation
     */
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "RegistrarCiudad")
    public String RegistrarCiudad(@WebParam(name = "ciudad") String ciudad,
            @WebParam(name = "departamento") String departamento, 
            @WebParam(name = "temp_actual_centigrados") String temp_actual_centigrados, 
            @WebParam(name = "temp_actual_fahrenheit") String temp_actual_fahrenheit, 
            @WebParam(name = "humedad_actual") String humedad_actual, 
            @WebParam(name = "condensacion_actual") String condensacion_actual, 
            @WebParam(name = "presion_actual") String presion_actual, 
            @WebParam(name = "visibilidad_actual") String visibilidad_actual,
            @WebParam(name = "probabilidad_precipitacion") String probabilidad_precipitacion, 
            @WebParam(name = "Descripcion_proxtres") String Descripcion_proxtres, 
            @WebParam(name = "max_min_proxtres") String max_min_proxtres, 
            @WebParam(name = "precipitacion_proxtres") String precipitacion_proxtres,
            @WebParam(name = "viento_proxtres") String viento_proxtres, 
            @WebParam(name = "humedad_proxtres") String humedad_proxtres) {
        
        Ciudad p =new Ciudad(ciudad,departamento,temp_actual_centigrados,temp_actual_fahrenheit,humedad_actual,condensacion_actual,presion_actual,visibilidad_actual,probabilidad_precipitacion,Descripcion_proxtres,max_min_proxtres,precipitacion_proxtres,viento_proxtres,humedad_proxtres);
        CiudadDAO ciudadDAO=new  CiudadDAO();
        ciudadDAO.ingresarCiudad(p);
        return "Ciudad ingresada";
            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarCiudad")
    public String BuscarCiudad(@WebParam(name = "codigo") int codigo) {
        CiudadDAO ciudadDAO=new CiudadDAO();
        return ciudadDAO.consultarCiudad(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarCiudades")
    public List<Ciudad> ConsultarCiudades() {
        CiudadDAO ciudadDAO=new CiudadDAO();
        List<Ciudad>listaCiudades=ciudadDAO.verCiudads();
        return  listaCiudades;  
    }
}
