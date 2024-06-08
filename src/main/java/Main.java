import java.io.BufferedReader; // permite leer texto de una entrada de caracteres de forma eficiente
import java.io.IOException; // para el manejo de errores
import java.io.InputStreamReader; // convierte el flujo de bytes en flujo de caracteres
import java.util.HashMap; // almacena registros de doctores, pacientes y citas
import java.util.Map; // interface map para almacenar identificadores unicos

class main { // almacena registros de doctores, pacientes y las citas en el programa
    private static Map<Integer, doctor> doctores = new HashMap<>();
    private static Map<Integer, paciente> pacientes = new HashMap<>();
    private static Map<Integer, cita> citas = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void mostrarMenu() { // muestra opciones disponibles en el programa para que el usuario seleccione
        System.out.println("****** Seleccione una opción: ****** \n");
        System.out.println("1. Registrar Doctor");
        System.out.println("2. Registrar Paciente");
        System.out.println("3. Crear Cita");
        System.out.println("4. Mostrar Cita");
        System.out.println("5. Cerrar Programa");
    }

    public static void registrarDoctor() { // registra un nuevo doctor en el programa
        try {
            System.out.print("Ingrese ID del Doctor: ");
            int idDoctor = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese el nombre del Doctor: ");
            String nombreDoctor = reader.readLine();
            System.out.print("Ingrese ID de la especialidad del Doctor (1: Cardiologia, 2: Neurologia, 3: Pediatria, 4: Dermatologia): ");
            int idEspecialidad = Integer.parseInt(reader.readLine());

            especialidad especialidad = null;
            doctor doctor = new doctor(idDoctor, nombreDoctor, especialidad);
            doctor.guardaRegistroDoctor(doctores);
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }

    public static void registrarPaciente() { // registra un nuevo paciente en el programa
        try {
            System.out.print("Ingrese ID del paciente: ");
            int idPaciente = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese el nombre del paciente: ");
            String nombrePaciente = reader.readLine();

            paciente paciente = new paciente(idPaciente, nombrePaciente);
            paciente.guardaRegistroPaciente(pacientes);
        } catch (IOException | NumberFormatException e) {
            System.out.println("El paciente ya existe en la base de datos. Por favor, intente nuevamente.");
        }
    }

    public static void crearCita() { // crea una vita en el programa
        try {
            System.out.print("Ingrese ID de la cita: ");
            int idCita = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese fecha y hora de la cita con el formato dia/mes/año y hora HH:mm : ");
            String fechaHora = reader.readLine();
            System.out.print("Ingrese el motivo de la cita: ");
            String motivo = reader.readLine();

            cita cita = new cita(idCita, fechaHora, motivo);
            cita.guardarCita(citas);
            cita.imprimirTicket();
        } catch (IOException | NumberFormatException e) { // manejo de errores en la captura de datos
            System.out.println("Error en la captura de datos. Por favor, intente nuevamente.");
        }
    }

    public static void mostrarCita() {
        try {
            System.out.print("Ingrese ID de la Cita: ");
            int idCita = Integer.parseInt(reader.readLine()); // Integer.parseInt permite convertir cadena de texto a numeros

            if (citas.containsKey(idCita)) { // comprueba si una clave esta dada de alta en el programa
                cita cita = citas.get(idCita);
                System.out.println("Cita ID: " + cita.getIdCita());
                System.out.println("Fecha y Hora: " + cita.getFechaHora());
                System.out.println("Motivo: " + cita.getMotivo());
            } else {
                System.out.println("Cita no encontrada.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }

    public static boolean autenticarUsuario() { // solicita usuario y contraseña y verifica si es correcto
        String nombreUsuario = "admin";
        String contrasena = "contraseña";
        try {
            System.out.print("Ingrese su nombre de usuario: ");
            String inputNombreUsuario = reader.readLine();
            System.out.print("Ingrese su contraseña: ");
            String inputContrasena = reader.readLine();

            return nombreUsuario.equals(inputNombreUsuario) && contrasena.equals(inputContrasena);
        } catch (IOException e) {
            System.out.println("Error en la captura de datos. Por favor, intente nuevamente.");
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        boolean autenticado = false;
        while (!autenticado) { // solicita las credenciales para acceder al programa hasta que el usuario capture los datos correctamente
            autenticado = autenticarUsuario();
            if (!autenticado) {
                System.out.println("Nombre de usuario o contraseña incorrectos. Por favor intente nuevamente.");
            }
        }

        while (true) { // ciclo while muestra el menu principal y permite ejecutar las opciones del programa
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(reader.readLine()); // Integer.parseInt permite convertir cadena de texto a numeros, convierte la opcion del texto del menu a numero
                switch (opcion) {
                    case 1:
                        registrarDoctor();
                        break;
                    case 2:
                        registrarPaciente();
                        break;
                    case 3:
                        crearCita();
                        break;
                    case 4:
                        mostrarCita();
                        break;
                    case 5:
                        System.out.println("Programa terminado.");
                        return;
                    default:
                        System.out.println("La opción no es válida.");
                }
            } catch (IOException | NumberFormatException e) { // para el manejo de errores en caso de que se capture otro numero
                System.out.println("Error en la captura de datos. Por favor, intente nuevamente.");
            }
        }
    }
} // clase main