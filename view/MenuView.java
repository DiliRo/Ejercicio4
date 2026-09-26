package view;
import java.util.Scanner;

public class MenuView{
    Scanner sc = new Scanner(System.in);
    CarroView carroView = new CarroView();
    MotocicletaView motocicletaView = new MotocicletaView();
    PesadosView pesadosView = new PesadosView();


    public void agregarVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();

        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.AgregarMotocicleta(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            pesadosView.AgregarPesado(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            carroView.AgregarCarro(placa);
        }
    }

    public void buscarVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();
        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.BuscarMotocilcetaPlaca(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            pesadosView.BuscarPesadosPlaca(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            carroView.BuscarCarroPlaca(placa);
        }
    }


    public void cotizarVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();
        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.Cotizarmotocicleta(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            pesadosView.CotizarPesados(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            carroView.CotizarCarro(placa);
        }
    }

    public void alquilarVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();
        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.confirmarAlquiler(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            pesadosView.confirmarAlquiler(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            carroView.confirmarAlquiler(placa);
        }
    }

    public void devolverVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();
        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.registrarDevolucion(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            pesadosView.registrarDevolucion(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            carroView.registrarDevolucion(placa);
        }
    }


    public void Menu(){
        int opcion = 0;
        
        do{
            System.out.println("----------------------- Rentamovil -----------------------");
            System.out.println("Opción 1: Agregar Vehiculo");
            System.out.println("Opción 2: Buscar Vehiculo por placa");
            System.out.println("Opción 3: Cotizar Vehiculo");
            System.out.println("Opción 4: Alquilar Vehiculo");
            System.out.println("Opción 5: Devolver Vehiculo");
            System.out.println("----------------------------------------------------------");
            opcion = sc.nextInt();
            sc.nextLine();
        switch (opcion) {
            case 1:
                agregarVehiculo();
                break;
            case 2:
                buscarVehiculo();
                break;
            case 3:
                cotizarVehiculo();
                break;
            case 4:
                alquilarVehiculo();
                break;
            case 5:
                devolverVehiculo();
                break;
            default:
                throw new AssertionError();
        }
        }while(opcion != 7);
    }
}