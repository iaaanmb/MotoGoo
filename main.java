import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaMotoGoo sistema = new SistemaMotoGoo();

        int opcion;

        do {

            System.out.println("\n===== MOTO GOO =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Ver motocicletas disponibles");
            System.out.println("3. Reservar motocicleta");
            System.out.println("4. Simular plan de pago");
            System.out.println("5. Ver reservas");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    sistema.registrarUsuario(scanner);
                    break;

                case 2:
                    sistema.mostrarMotos();
                    break;

                case 3:
                    sistema.reservarMoto(scanner);
                    break;

                case 4:
                    sistema.simularPago(scanner);
                    break;

                case 5:
                    sistema.mostrarReservas();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}