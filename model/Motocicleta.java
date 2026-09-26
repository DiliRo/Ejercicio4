package model;

import interfaces.Alquilable;

public class Motocicleta extends Vehiculo implements Alquilable{
    private int cilindraje;

    public Motocicleta(int cilindraje, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        super(placa, marca, modelo, tarifaDiaria, disponibilidad);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje(){
        return cilindraje;
    }

    public void setCilindraje(int cilindraje){
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularCostos(int dias){
        double subtotal = 0.0;
        double total = 0.0;

        subtotal = getTarifaDiaria() * dias;

        if (this.cilindraje > 250) {
            subtotal = subtotal + 75.00;
            return total;
        }else{
            return total;
        }
    }

    @Override
    public String toString(){
        return "Carro{"+ "marca:" + getMarca() +"modelo:" + getModelo() + "placa:" +getPlaca()  + "cilindraje:" + this.cilindraje + ", tarifa:" + getTarifaDiaria() +", disponibilidad:" + (getDisponibilidad() ? "Disponible" : "No disponible") + '}';
    }
}
