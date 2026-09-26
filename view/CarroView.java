package view;

import controller.CarroController;
import java.util.Scanner;

public class CarroView{
    private CarroController carroController;
   
    Scanner sc = new Scanner(System.in);

    public CarroView(CarroController carroController) {
        this.carroController = carroController;
    }

    public void AgregarCarro(String placa){
        System.out.println("Ingrese la capacidad del carro");
        int capacidad = sc.nextInt();
        while (capacidad <= 0){
            System.out.println("La capacidad debe ser mayor a cero, vuelva a intentar");
            capacidad = sc.nextInt();
        }
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
        while (tarifaDiaria <= 0){
            System.out.println("La tarifa diaria debe ser mayor a cero, vuelva a intentar");
            tarifaDiaria = sc.nextFloat();
        }
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
        while (dias <=0){
            System.out.println("La cantidad de días tiene que ser mayor a 0, vuelva a intentar");
            dias = sc.nextInt();
        }
        sc.nextLine();
        carroController.CotizarCarro(placa, dias);
    }

    public void confirmarAlquiler(String placa){
        System.out.println("Ingrese la cantidad de dias a alquilar");
        int dias = sc.nextInt();
        while (dias <=0){
            System.out.println("La cantidad de días tiene que ser mayor a 0, vuelva a intentar");
            dias = sc.nextInt();
        }
        sc.nextLine();
        carroController.confirmarAlquiler(placa, dias);
    }

    public void registrarDevolucion(String placa){
        carroController.registrarDevolucion(placa);
    }


}