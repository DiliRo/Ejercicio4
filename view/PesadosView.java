package view;

import controller.PesadosController;
import java.util.Scanner;

public class PesadosView{

    Scanner sc = new Scanner(System.in);
    PesadosController pesadosController = new PesadosController();

    public void AgregarPesado(String placa){
        System.out.println("Ingrese la capacidad de carga del vehiculo pesado (en kg, unicamente el numero)");
        int capacidadCarga = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la marca del vehiculo pesado");
        String marca = sc.nextLine();

        System.out.println("Ingrese el modelo del vehiculo pesado");
        String modelo = sc.next();

        System.out.println("Ingrese la tarifa diaria del vehiculo pesado");
        float tarifaDiaria = sc.nextFloat();
        sc.nextLine();

        System.out.println("Ingrese si esta disponible (1 para si, 0 para no) ");
        Boolean disponibilidad = sc.nextInt() == 1;
        sc.nextLine();

        pesadosController.AgregarPesado(capacidadCarga, placa, marca, modelo, tarifaDiaria, disponibilidad);
    }

    public void BuscarPesadosPlaca(String placa){
        String resultado = pesadosController.BuscarPesadoPlaca(placa);
        if (resultado != null) {
            System.out.println("Vehiculo pesado encontrado: " + resultado);
        } else {
            System.out.println("No se encontró el vehiculo pesado con la placa: " + placa);
        }
    }

     public void CotizarPesados(String placa){
        System.out.println("Ingrese la cantidad de dias a cotizar");
        int dias = sc.nextInt();
        sc.nextLine();
        pesadosController.CotizarPesado(placa, dias);
    }

    public void confirmarAlquiler(String placa){
        System.out.println("Ingrese la cantidad de dias a alquilar");
        int dias = sc.nextInt();
        sc.nextLine();
        pesadosController.confirmarAlquiler(placa, dias);
    }

    public void registrarDevolucion(String placa){
        pesadosController.registrarDevolucion(placa);
    }
}