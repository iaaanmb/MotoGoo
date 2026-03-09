import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMotoGoo {

    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();

    public SistemaMotoGoo() {

        motos.add(new Moto("Yamaha", "FZ", 3000000));
        motos.add(new Moto("Honda", "CB125", 2800000));
        motos.add(new Moto("AKT", "NKD 125", 2200000));
    }

    public void registrarUsuario(Scanner scanner) {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, documento);
        usuarios.add(usuario);

        System.out.println("Usuario registrado correctamente.");
    }

    public void mostrarMotos() {

        System.out.println("\nMotocicletas disponibles:");

        for (int i = 0; i < motos.size(); i++) {
            Moto m = motos.get(i);
            System.out.println(i + " - " + m.marca + " " + m.modelo + " $" + m.precio);
        }
    }

    public void reservarMoto(Scanner scanner) {

        if (usuarios.isEmpty()) {
            System.out.println("Debe registrar un usuario primero.");
            return;
        }

        mostrarMotos();

        System.out.print("Seleccione la moto: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        Moto moto = motos.get(indice);

        System.out.print("Documento del usuario: ");
        String doc = scanner.nextLine();

        Usuario usuario = null;

        for (Usuario u : usuarios) {
            if (u.documento.equals(doc)) {
                usuario = u;
            }
        }

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        Reserva reserva = new Reserva(usuario, moto);
        reservas.add(reserva);

        System.out.println("Reserva realizada con éxito.");
    }

    public void simularPago(Scanner scanner) {

        System.out.print("Precio de la moto: ");
        double precio = scanner.nextDouble();

        System.out.print("Número de cuotas: ");
        int cuotas = scanner.nextInt();

        double cuota = precio / cuotas;

        System.out.println("Cada cuota sería de: $" + cuota);
    }

    public void mostrarReservas() {

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }

        for (Reserva r : reservas) {
            System.out.println(r.usuario.nombre + " reservó " + r.moto.marca + " " + r.moto.modelo);
        }
    }
}