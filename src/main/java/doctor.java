import java.util.Map;

public class doctor {
    private int idDoctor;
    private String nombreDoctor;
    private especialidad especialidad;

    public doctor(int idDoctor, String nombreDoctor, especialidad especialidad) { // se inicializa constructor doctor
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
    }

    // getters para tomar valores de los atributos de doctor, y setters para guardar valores de doctor
    public int getId() {
        return idDoctor;
    }

    public void setId(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void guardaRegistroDoctor(Map<Integer, doctor> doctores) { // guarda en el mapa el registro de doctores
        if (doctores.containsKey(this.idDoctor)) {
            System.out.println("Doctor ya existe en la base de datos");
        } else {
            doctores.put(this.idDoctor, this);
            System.out.println("Doctor guardado exitosamente en la base de datos");
        }
    }
}  //clase doctor