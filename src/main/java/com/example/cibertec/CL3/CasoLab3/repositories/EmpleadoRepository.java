package com.example.cibertec.CL3.CasoLab3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cibertec.CL3.CasoLab3.entities.Empleado;



public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
    
    List<Empleado> findAll();

}