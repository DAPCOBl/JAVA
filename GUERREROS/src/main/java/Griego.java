

public class Griego extends Guerrero{
    
    public Griego(String nombre, int edad, int fuerza) {
        super(nombre, edad, fuerza);
        if (!comprobarEdad(edad)) {
            setEdad(25);
        }
        if (!comprobarFuerza(fuerza)) {
            setFuerza(5);
        }
    }

    public Griego() {
            super("GuerreroX", 15, 1);
    }

    public Griego(Guerrero guerrero, String nuevoNombre) {
        super(nuevoNombre, guerrero.getEdad(), guerrero.getFuerza());
    }
    
}


