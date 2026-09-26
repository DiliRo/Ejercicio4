package controller;

public class ReporteController {
    private final CarroController carroController;
    private final MotocicletaContoller motocicletaController;
    private final PesadosController pesadosController;
   

    public ReporteController(CarroController carroController, MotocicletaContoller motocicletaController, PesadosController pesadosController) {
        this.carroController = carroController;
        this.motocicletaController = motocicletaController;
        this.pesadosController = pesadosController;

    }

    
    public double getIngresosTotales() {
    return carroController.getIngresosCarros()
        + motocicletaController.getIngresosMotocicletas()
        + pesadosController.getIngresosPesados();
    }

    public int getCantidadVehiculos() {
        return carroController.getCantidadCarros() + motocicletaController.getCantidadMotocicletas() + pesadosController.getCantidadPesados();
    }

    public int getCantidadVehiculosDisponibles() {
        return carroController.getCantidadCarrosDisponibles() + motocicletaController.getCantidadMotocicletasDisponibles() + pesadosController.getCantidadPesadosDisponibles();
    }

    public int getCantidadVehiculosAlquilados() {
        return carroController.getCantidadCarrosAlquiladas() + motocicletaController.getCantidadMotocicletasAlquiladas() + pesadosController.getCantidadPesadosAlquiladas();
    }

    public void generarFlota() {
        System.out.println("Reporte de Vehiculos:");
        System.out.println("---------------------");
        System.out.println("Carros:");
        carroController.listarCarros();
        System.out.println("---------------------");
        System.out.println("Motocicletas:");
        motocicletaController.listarMotocicletas();
        System.out.println("---------------------");
        System.out.println("Pesados:");
        pesadosController.listarPesados();
    }

    public void generarReporteGenerales(){
        System.out.println("Reporte generales:");
        System.out.println("---------------------");
        System.out.println("Ingresos por Carros: " + carroController.getIngresosCarros());
        System.out.println("Ingresos por Motocicletas: " + motocicletaController.getIngresosMotocicletas());
        System.out.println("Ingresos por Pesados: " + pesadosController.getIngresosPesados());
        System.out.println("---------------------");
        System.out.println("Ingresos Totales: " + getIngresosTotales());
        System.out.println("Cantidad de Vehiculos: " + getCantidadVehiculos());
        System.out.println("Cantidad de Vehiculos Disponibles: " + getCantidadVehiculosDisponibles());
        System.out.println("Cantidad de Vehiculos Alquilados: " + getCantidadVehiculosAlquilados());
    }
}