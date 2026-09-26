package controller;

import java.util.ArrayList;
import model.Motocicleta;

public class MotocicletaContoller{
    private Motocicleta motocicleta;
    private double ingresosMotocicletas = 0;
    private  ArrayList<Motocicleta> listaMotocicletas;


    public MotocicletaContoller(){
        listaMotocicletas = new ArrayList<>();
    }

    public void AgregarMotocicleta(int cilindraje, String placa, String marca, String modelo, float tarifaDiaria, Boolean disponibilidad){
        if (placa.isEmpty()){
            System.out.println("La placa no puede estar vacía");
            return;
        }

        if (BuscarMotocicletaPlaca(placa) != null){
            System.out.println("La placa registrada ya existe: " + placa);
            return;
        }
        
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
        Boolean encontrado = false;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa) {
                System.out.println("Precio de alquiler de motocicleta con placas:" + placaBuscar + "es de: " + motocicleta.calcularCostos(dias));
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro la motocicleta");
        }

    }

    public void confirmarAlquiler(String placaBuscar, int dias){
        Boolean placa;
        Boolean encontrado = false;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
            if (placa && motocicleta.getDisponibilidad()) {
                motocicleta.setDisponibilidad(false);
                System.out.println("¡Motocicleta alquilado!");
                System.out.println("Precio de alquiler por "+ dias + "días" + " es de: " + motocicleta.calcularCostos(dias));
                ingresosMotocicletas += motocicleta.calcularCostos(dias);
                encontrado = true;
            }else if (placa && !motocicleta.getDisponibilidad()) {
                System.out.println("Motocicleta no disponible");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro la motocicleta");
        }
    }


    public void registrarDevolucion(String placaBuscar){
        Boolean placa;
        Boolean encontrado = false;
        for (Motocicleta motocicleta : listaMotocicletas) {
            placa = motocicleta.getPlaca().equalsIgnoreCase(placaBuscar);
             if (placa && !motocicleta.getDisponibilidad()) {
                motocicleta.setDisponibilidad(true);
                System.out.println("¡Motocicleta devuelta!");
                encontrado = true;
            }else if (placa && motocicleta.getDisponibilidad()){
                System.out.println("Motocicleta ya disponible, no estaba alquilado");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Motocicleta no encontrada");
        }
    }

    public void listarMotocicletas(){
        if (listaMotocicletas.isEmpty()) {
            System.out.println("No hay motocicletas registradas");
        } else {
            System.out.println("Lista de carros:");
            for (Motocicleta motocicleta : listaMotocicletas) {
                System.out.println(motocicleta.toString());
            }
        }
    } 

    public double getIngresosMotocicletas() {
        return ingresosMotocicletas;
    }

    public int getCantidadMotocicletas() {
        return listaMotocicletas.size();
    }

    public int getCantidadMotocicletasDisponibles() {
        int cantidadDisponibles = 0;
        for (Motocicleta motocicleta : listaMotocicletas) {
            if (motocicleta.getDisponibilidad()) {
                cantidadDisponibles++;
            }
        }
        return cantidadDisponibles;
    }

    public int getCantidadMotocicletasAlquiladas() {
        int cantidadAlquiladas = 0;
        for (Motocicleta motocicleta : listaMotocicletas) {
            if (!motocicleta.getDisponibilidad()) {
                cantidadAlquiladas++;
            }
        }
        return cantidadAlquiladas;
    }


}