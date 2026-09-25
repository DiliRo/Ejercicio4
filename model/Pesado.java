package model;

public class Pesado extends Vehiculo{
    private float capacidadCarga;

    public Pesado(float capacidadCarga, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        super(placa, marca, modelo, tarifaDiaria, disponibilidad);
        this.capacidadCarga = capacidadCarga;
    }

    public float getCapacidadCarga(){
        return capacidadCarga;
    }

    public void getCapacidadCarga(float capacidadCarga){
        this.capacidadCarga = capacidadCarga;
    }
}