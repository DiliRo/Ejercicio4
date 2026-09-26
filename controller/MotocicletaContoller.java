package controller;

import java.util.ArrayList;
import model.Motocicleta;

public class MotocicletaContoller{
    private Motocicleta motocicleta;
    private  ArrayList<Motocicleta> listaMotocicletas;


    public MotocicletaContoller(){
        listaMotocicletas = new ArrayList<>();
    }

    public void AgregarMotocicleta(int cilindraje, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        motocicleta = new Motocicleta(cilindraje, placa, marca, modelo, tarifaDiaria, disponibilidad);
        listaMotocicletas.add(motocicleta);
    }

    public String BuscarMotocicletaPlaca(String placaBuscar){
        Boolean placa;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                return motocicleta.toString();
            }
        }
        return null;
    }

    
    public void Cotizarmotocicleta(String placaBuscar, int dias){
        Boolean placa;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler de motocicleta con placas:" + placaBuscar + "es de: " + motocicleta.calcularCostos(dias));
            }
        }
        System.out.println("No se encontro el motocicleta");
    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && motocicleta.getDisponibilidad()) {
                motocicleta.setDisponibilidad(false);
                System.out.println("¡Motocicleta alquilado!");
                System.out.println("Precio de alquiler por "+ dias + " es de: " + motocicleta.calcularCostos(dias));
            }else if (placa && !motocicleta.getDisponibilidad()) {
                System.out.println("Motocicleta no disponible");
            }
        }
        System.out.println("No se encontro el motocicleta");
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                motocicleta.setDisponibilidad(true);
                System.out.println("Motocicleta devuelto!");
            }
        }
        System.out.println("Motocicleta no encontrado");
    }


}