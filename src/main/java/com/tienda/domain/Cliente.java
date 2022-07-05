package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data //Genera internamente ciertos métodos,
//entre ellos, los getters y setters
@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;//Esto siempre se pone igual

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
    
    

}
