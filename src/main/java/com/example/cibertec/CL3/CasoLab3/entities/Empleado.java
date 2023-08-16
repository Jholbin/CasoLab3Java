package com.example.cibertec.CL3.CasoLab3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "empleado")
@Entity
public class Empleado  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String apellido;
    String salario;
    String puesto;

    public Empleado() {}
    
    public Empleado( String nombre, String apellido, String salario, String puesto
    ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.puesto = puesto;

        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }



        
}
