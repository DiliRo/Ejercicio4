package model;

import interfaces.Alquilable;

public class Pesado extends Vehiculo implements Alquilable{
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

    @Override
    public double calcularCostos(int dias){
        double subtotal = 0.0;
        double total = 0.0;

        subtotal = getTarifaDiaria() * dias;

        total = subtotal + (this.capacidadCarga + dias);
        return total;
        
    }

    @Override
    public String toString(){
        return "Carro{"+ "marca:" + getMarca() +"modelo:" + getModelo() + "placa:" +getPlaca()  + "Capacidad de carga:" + this.capacidadCarga + " kg" + ", tarifa:" + getTarifaDiaria() +", disponibilidad:" + (getDisponibilidad() ? "Disponible" : "No disponible") + '}';
    }
}