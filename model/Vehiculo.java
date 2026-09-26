package model;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private float tarifaDiaria;
    private Boolean disponibilidad;

    public Vehiculo(String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
        this.disponibilidad = disponibilidad;

    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public float getTarifaDiaria(){
        return tarifaDiaria;
    }

    public void setTarifaDiaria(float tarifaDiaria){
        this.tarifaDiaria = tarifaDiaria;
    }

    public Boolean getDisponibilidad(){
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    
}