

public class Troyano extends Guerrero {

    public Troyano(String nombre, int edad, int fuerza) {
        super(nombre, edad, fuerza);
        if (!comprobarEdad(edad)) {
            setEdad(25);
        }
        if (!comprobarFuerza(fuerza)) {
            setFuerza(5);
        }
    }

    public Troyano() {
            super("GuerreroX", 15, 1);
    }

    public Troyano(Guerrero guerrero, String nuevoNombre) {
        super(nuevoNombre, guerrero.getEdad(), guerrero.getFuerza());
    }

}
