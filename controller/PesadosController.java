package controller;

import java.util.ArrayList;
import model.Pesado;

public class PesadosController{
    private Pesado pesado;
    private double ingresosPesados = 0;
    private  ArrayList<Pesado> listaPesados;


    public PesadosController(){
        listaPesados = new ArrayList<>();
    }

    public void AgregarPesado(float capacidadCarga, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        if (placa.isEmpty()){
            System.out.println("La placa no puede estar vacía");
            return;
        }
        
        if (BuscarPesadoPlaca(placa) != null){
            System.out.println("La placa registrada ya existe: " + placa);
            return;
        }
        
        pesado = new Pesado(capacidadCarga, placa, marca, modelo, tarifaDiaria, disponibilidad);
        listaPesados.add(pesado);
    }

    public String BuscarPesadoPlaca(String placaBuscar){
        Boolean placa;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                return pesado.toString();
            }
        }
        return null;
    }

    
    public void CotizarPesado(String placaBuscar, int dias){
        Boolean placa;
        Boolean encontrado = false;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler del vehiculo pesado con placas:" + placaBuscar + "es de: " + pesado.calcularCostos(dias));
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el vehículo pesado");
        }
    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        Boolean encontrado = false;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && pesado.getDisponibilidad()) {
                pesado.setDisponibilidad(false);
                System.out.println("¡Vehiculo pesado alquilado!");
                System.out.println("Precio de alquiler por "+ dias +"días" + " es de: " + pesado.calcularCostos(dias));
                ingresosPesados += pesado.calcularCostos(dias);
                encontrado = true;
            }else if (placa && !pesado.getDisponibilidad()) {
                System.out.println("Vehiculo pesado no disponible");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el vehículo pesado");
        }
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        Boolean encontrado = false;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
             if (placa && !pesado.getDisponibilidad()) {
                pesado.setDisponibilidad(true);
                System.out.println("¡Vehículo pesado devuelto!");
                encontrado = true;
            }else if (placa && pesado.getDisponibilidad()){
                System.out.println("Vehículo pesado ya disponible, no estaba alquilado");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Vehículo pesado no encontrado");
        }
    }

    public void listarPesados(){
        if (listaPesados.isEmpty()) {
            System.out.println("No hay vehiculos pesados registrados");
        } else {
            System.out.println("Lista de vehiculos pesados:");
            for (Pesado pesado : listaPesados) {
                System.out.println(pesado.toString());
            }
        }
    } 

    public double getIngresosPesados() {
        return ingresosPesados;
    }

    public int getCantidadPesados() {
        return listaPesados.size();
    }

    public int getCantidadPesadosDisponibles() {
        int cantidadDisponibles = 0;
        for (Pesado pesado : listaPesados) {
            if (pesado.getDisponibilidad()) {
                cantidadDisponibles++;
            }
        }
        return cantidadDisponibles;
    }

    public int getCantidadPesadosAlquiladas() {
        int cantidadAlquiladas = 0;
        for (Pesado pesado : listaPesados) {
            if (!pesado.getDisponibilidad()) {
                cantidadAlquiladas++;
            }
        }
        return cantidadAlquiladas;
    }
}