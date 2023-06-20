package unla.oo2.grupo24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_contenedor")
public class Contenedor extends Dispositivo {

    @Column(name="lleno",nullable=false)
    private boolean lleno;

    @Column(name="tipo",length=60,nullable=false)
    private String tipo;


    public Contenedor() {}




    public Contenedor(boolean lleno, String tipo) {
        super();
        this.lleno = lleno;
        this.tipo = tipo;

    }




    public String getTipo() {
        return tipo;
    }




    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




    public boolean isLleno() {
        return lleno;
    }

    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }









}