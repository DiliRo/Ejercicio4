package model;

import interfaces.Alquilable;

public class Carro extends Vehiculo implements Alquilable{
    private int capacidad;
    private Boolean automatico;

    public Carro(int capacidad, Boolean automatico, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        super(placa, marca, modelo, tarifaDiaria, disponibilidad);
        this.capacidad = capacidad;
        this.automatico = automatico;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public Boolean getAutomatico(){
        return automatico;
    }

    public void setAutomatico(Boolean automatico){
        this.automatico = automatico;
    }

    
    @Override
    public double calcularCostos(int dias){
        double subtotal = 0.0;
        double total = 0.0;

        subtotal = getTarifaDiaria() * dias;

        if(this.automatico){
            total = subtotal + 50.00;
            return total;
        }else{
            total = subtotal;
            return total;
        }
    }

    @Override
    public String toString(){
        return "Carro{"+ "marca:" + getMarca() +"modelo:" + getModelo() + "placa:" +getPlaca()  + ", capacidad:" + capacidad + ", transmisión:" + (automatico ? "Automática" : "Manual") + ", tarifa:" + getTarifaDiaria() +", disponibilidad:" + (getDisponibilidad() ? "Disponible" : "No disponible") + '}';
    }
}

