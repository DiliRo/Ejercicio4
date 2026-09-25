package model;

public class Motocicleta extends Vehiculo{
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
}
