


    public abstract class Guerrero {

    protected final String nombre;
    protected int edad;
    protected int fuerza;
    protected boolean herido;
    protected boolean muerto;

    public Guerrero(String nombre, int edad, int fuerza) {
        this.nombre = nombre;
        this.edad = edad;
        this.fuerza = fuerza;
        this.herido = false;
        this.muerto = false;
    }

    // Getters y setters para los atributos privados
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método para comprobar la edad dentro del rango permitido (15 a 60)
    protected boolean comprobarEdad(int edad) {
        return edad >= 15 && edad <= 60;
    }

    public void setEdad(int edad) {
        if (comprobarEdad(edad)) {
            this.edad = edad;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    // Método para comprobar la fuerza dentro del rango permitido (1 a 10)
    protected boolean comprobarFuerza(int fuerza) {
        return fuerza >= 1 && fuerza <= 10;
    }

    public void setFuerza(int fuerza) {
        if (comprobarFuerza(fuerza)) {
            this.fuerza = fuerza;
        }
    }

    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public boolean Muerto() {
        return fuerza <= 0;
    }
    
    public void Danio(int danio) {
        this.fuerza -= danio;
    }
    
}

