package controller;

import java.util.ArrayList;
import model.Carro;

public class CarroController{
    private Carro carro;
    private  ArrayList<Carro> listaCarros;


    public CarroController(){
        listaCarros = new ArrayList<>();
    }

    public void AgregarCarro(int capacidad, Boolean automatico, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        carro = new Carro(capacidad, automatico, placa, marca, modelo, tarifaDiaria, disponibilidad);
        listaCarros.add(carro);
    }

    public String BuscarCarroPlaca(String placaBuscar){
        Boolean placa;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                return carro.toString();
            }
        }
        return null;
    }

    
    public void CotizarCarro(String placaBuscar, int dias){
        Boolean placa;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler de carro con placas:" + placaBuscar + "es de: " + carro.calcularCostos(dias));
            }
        }
        System.out.println("No se encontro el carro");
    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && carro.getDisponibilidad()) {
                carro.setDisponibilidad(false);
                System.out.println("¡Carro alquilado!");
                System.out.println("Precio de alquiler por "+ dias + " es de: " + carro.calcularCostos(dias));
            }else if (placa && !carro.getDisponibilidad()) {
                System.out.println("Carro no disponible");
            }
        }
        System.out.println("No se encontro el carro");
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                carro.setDisponibilidad(true);
                System.out.println("¡Carro devuelto!");
            }
        }
        System.out.println("Carro no encontrado");
    }


}