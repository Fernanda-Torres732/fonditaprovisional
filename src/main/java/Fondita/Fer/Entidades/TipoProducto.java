package Fondita.Fer.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoProducto")
public class TipoProducto {

    public TipoProducto() {
    }

    public TipoProducto(int idTipo, String tipo, String descripcion) {
        this.idTipo = idTipo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Id
    private int idTipo;

    @Column(name = "tipo")
    private String tipo; 

    @Column(name = "descripcion")
    private String descripcion;

    public int getIdTipo() {
        return idTipo;
    }

    public void setId(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
