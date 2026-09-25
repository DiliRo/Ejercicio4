package model;

public class Carro extends Vehiculo{
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
}

