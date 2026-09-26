package view;

import controller.CarroController;
import java.util.Scanner;

public class CarroView{
   
    Scanner sc = new Scanner(System.in);
    CarroController carroController = new CarroController();

    public void AgregarCarro(String placa){
        System.out.println("Ingrese la capacidad del carro");
        int capacidad = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese si es automatico (1 para si, 0 para no)");
        Boolean automatico = sc.nextInt() == 1;
        sc.nextLine();

        System.out.println("Ingrese la marca del carro");
        String marca = sc.nextLine();

        System.out.println("Ingrese el modelo del carro");
        String modelo = sc.next();

        System.out.println("Ingrese la tarifa diaria del carro");
        float tarifaDiaria = sc.nextFloat();
        sc.nextLine();

        System.out.println("Ingrese si esta disponible (1 para si, 0 para no) ");
        Boolean disponibilidad = sc.nextInt() == 1;
        sc.nextLine();

        carroController.AgregarCarro(capacidad, automatico, placa, marca, modelo, tarifaDiaria, disponibilidad);
    }

    public void BuscarCarroPlaca(String placa){
        String resultado = carroController.BuscarCarroPlaca(placa);
        if (resultado != null) {
            System.out.println("Carro encontrado: " + resultado);
        } else {
            System.out.println("No se encontró el carro con la placa: " + placa);
        }
    }

    public void CotizarCarro(String placa){
        System.out.println("Ingrese la cantidad de dias a cotizar");
        int dias = sc.nextInt();
        sc.nextLine();
        carroController.CotizarCarro(placa, dias);
    }

    public void confirmarAlquiler(String placa){
        System.out.println("Ingrese la cantidad de dias a alquilar");
        int dias = sc.nextInt();
        sc.nextLine();
        carroController.confirmarAlquiler(placa, dias);
    }

    public void registrarDevolucion(String placa){
        carroController.registrarDevolucion(placa);
    }


}