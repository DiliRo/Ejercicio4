package controller;

import java.util.ArrayList;
import model.Pesado;

public class PesadosController{
    private Pesado pesado;
    private  ArrayList<Pesado> listaPesados;


    public PesadosController(){
        listaPesados = new ArrayList<>();
    }

    public void AgregarPesado(float capacidadCarga, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
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
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler del vehiculo pesado con placas:" + placaBuscar + "es de: " + pesado.calcularCostos(dias));
            }
        }
        System.out.println("No se encontro el vehiculo pesado");
    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && pesado.getDisponibilidad()) {
                pesado.setDisponibilidad(false);
                System.out.println("¡Vehiculo pesado alquilado!");
                System.out.println("Precio de alquiler por "+ dias + " es de: " + pesado.calcularCostos(dias));
            }else if (placa && !pesado.getDisponibilidad()) {
                System.out.println("Vehiculo pesado no disponible");
            }
        }
        System.out.println("No se encontro el vehiculo pesado");
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        for (Pesado pesado : listaPesados) {
            placa = pesado.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                pesado.setDisponibilidad(true);
                System.out.println("Vehiculo pesado devuelto!");
            }
        }
        System.out.println("Vehiculo pesado no encontrado");
    }


}