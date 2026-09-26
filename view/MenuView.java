package view;
import controller.CarroController;
import controller.MotocicletaContoller;
import controller.PesadosController;
import controller.ReporteController;
import java.util.Scanner;
public class MenuView{
    Scanner sc = new Scanner(System.in);
    private  CarroController carroController;
    private  MotocicletaContoller motocicletaController;
    private  PesadosController pesadosController;
    private  ReporteController reporteController;
    private  CarroView carroView;
    private  MotocicletaView motocicletaView;
    private  PesadosView pesadosView;

    
    public MenuView() {
        carroController = new CarroController();
        motocicletaController = new MotocicletaContoller();
        pesadosController = new PesadosController();

        reporteController = new ReporteController(
            carroController,
            motocicletaController,
            pesadosController
        );

        carroView = new CarroView(carroController);
        motocicletaView = new MotocicletaView(motocicletaController);
        pesadosView = new PesadosView(pesadosController);
    }


    public void agregarVehiculo(){
        String placa;
        char tipoVehiculo;
        System.out.println("Ingrese la placa del vehiculo");
        placa = sc.nextLine().trim();

        tipoVehiculo = placa.charAt(0);

        if (tipoVehiculo == 'M' || tipoVehiculo == 'm') {
            motocicletaView.AgregarMotocicleta(placa);
        } else if (tipoVehiculo == 'P' || tipoVehiculo == 'p') {
            carroView.AgregarCarro(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            pesadosView.AgregarPesado(placa);
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
            carroView.BuscarCarroPlaca(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            pesadosView.BuscarPesadosPlaca(placa);
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
            carroView.CotizarCarro(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            pesadosView.CotizarPesados(placa);
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
            carroView.confirmarAlquiler(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            pesadosView.confirmarAlquiler(placa);
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
            carroView.registrarDevolucion(placa);
        } else if (tipoVehiculo == 'C' || tipoVehiculo == 'c') {
            pesadosView.registrarDevolucion(placa);
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
            System.out.println("Opción 6: Consultar flota de vehiculos");
            System.out.println("Opción 7: Consultar reporte generales");
            System.out.println("Opcion 8: Salir");
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
            case 6:
                reporteController.generarFlota();
                break;
            case 7:
                reporteController.generarReporteGenerales();
                break;
            case 8:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
        }while(opcion != 8);
    }
}