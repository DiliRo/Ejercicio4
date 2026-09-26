package view;

import controller.MotocicletaContoller;
import java.util.Scanner;

public class MotocicletaView{
    private MotocicletaContoller motocicletaContoller;

    Scanner sc = new Scanner(System.in);

    public MotocicletaView(MotocicletaContoller motocicletaContoller) {
        this.motocicletaContoller = motocicletaContoller;
    }

    public void AgregarMotocicleta(String placa){
        System.out.println("Ingrese el cilindraje de la motocicleta");
        int cilindraje = sc.nextInt();
        while (cilindraje <= 0){
            System.out.println("El cilindraje debe ser mayor a cero, vuelva a intentar");
            cilindraje = sc.nextInt();
        }
        sc.nextLine();

        System.out.println("Ingrese la marca del motocicleta");
        String marca = sc.nextLine();

        System.out.println("Ingrese el modelo del motocicleta");
        String modelo = sc.next();

        System.out.println("Ingrese la tarifa diaria del motocicleta");
        float tarifaDiaria = sc.nextFloat();
        while (tarifaDiaria <= 0){
            System.out.println("La tarifa diaria debe ser mayor a cero, vuelva a intentar");
            tarifaDiaria = sc.nextFloat();
        }
        sc.nextLine();

        System.out.println("Ingrese si esta disponible (1 para si, 0 para no) ");
        Boolean disponibilidad = sc.nextInt() == 1;
        sc.nextLine();

        motocicletaContoller.AgregarMotocicleta(cilindraje, placa, marca, modelo, tarifaDiaria, disponibilidad);
    }

    public void BuscarMotocilcetaPlaca(String placa){
        String resultado = motocicletaContoller.BuscarMotocicletaPlaca(placa);
        if (resultado != null) {
            System.out.println("Motocicleta encontrado: " + resultado);
        } else {
            System.out.println("No se encontró la motocicleta con la placa: " + placa);
        }
    }


    public void Cotizarmotocicleta(String placa){
        System.out.println("Ingrese la cantidad de dias a cotizar");
        int dias = sc.nextInt();
        while (dias <=0){
            System.out.println("La cantidad de días tiene que ser mayor a 0, vuelva a intentar");
            dias = sc.nextInt();
        }
        sc.nextLine();
        motocicletaContoller.Cotizarmotocicleta(placa, dias);
    }

    public void confirmarAlquiler(String placa){
        System.out.println("Ingrese la cantidad de dias a alquilar");
        int dias = sc.nextInt();
        while (dias <=0){
            System.out.println("La cantidad de días tiene que ser mayor a 0, vuelva a intentar");
            dias = sc.nextInt();
        }
        sc.nextLine();
        motocicletaContoller.confirmarAlquiler(placa, dias);
    }

    public void registrarDevolucion(String placa){
        motocicletaContoller.registrarDevolucion(placa);
    }
}