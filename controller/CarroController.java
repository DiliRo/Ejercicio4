package controller;

import java.util.ArrayList;
import model.Carro;

public class CarroController{
    private Carro carro;
    private double ingresosCarros = 0;
    
    private ArrayList<Carro> listaCarros;


    public CarroController(){
        listaCarros = new ArrayList<>();
    }

    public void AgregarCarro(int capacidad, Boolean automatico, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        if (placa.isEmpty()){
            System.out.println("La placa no puede estar vacía");
            return;
        }

        if (BuscarCarroPlaca(placa) != null){
            System.out.println("La placa registrada ya existe: " + placa);
            return;
        }

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
        Boolean encontrado = false;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler de carro con placas:" + placaBuscar + "es de: " + carro.calcularCostos(dias));
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el carro");
        }
        
    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        Boolean encontrado = false;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && carro.getDisponibilidad()) {
                carro.setDisponibilidad(false);
                System.out.println("¡Carro alquilado!");
                System.out.println("Precio de alquiler por "+ dias + "días" + " es de: " + carro.calcularCostos(dias));
                ingresosCarros += carro.calcularCostos(dias);
                encontrado = true;
            }else if (placa && !carro.getDisponibilidad()) {
                System.out.println("Carro no disponible");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el carro");
        }
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        Boolean encontrado = false;
        for (Carro carro : listaCarros) {
            placa = carro.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && !carro.getDisponibilidad()) {
                carro.setDisponibilidad(true);
                System.out.println("¡Carro devuelto!");
                encontrado = true;
            }else if (placa && carro.getDisponibilidad()){
                System.out.println("Carro ya disponible, no estaba alquilado");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Carro no encontrado");
        }
        
    }

    public void listarCarros(){
        if (listaCarros.isEmpty()) {
            System.out.println("No hay carros registrados");
        } else {
            System.out.println("Lista de carros:");
            for (Carro carro : listaCarros) {
                System.out.println(carro.toString());
            }
        }
    }

    public double getIngresosCarros() {
        return ingresosCarros;
    }


    public int getCantidadCarros() {
        return listaCarros.size();
    }

    public int getCantidadCarrosDisponibles() {
        int cantidadDisponibles = 0;
        for (Carro carro : listaCarros) {
            if (carro.getDisponibilidad()) {
                cantidadDisponibles++;
            }
        }
        return cantidadDisponibles;
    }

    public int getCantidadCarrosAlquiladas() {
        int cantidadAlquiladas = 0;
        for (Carro carro : listaCarros) {
            if (!carro.getDisponibilidad()) {
                cantidadAlquiladas++;
            }
        }
        return cantidadAlquiladas;
    }

}