
import java.util.Random;
import java.util.Scanner;

public class NewMain1 {

    public static void main(String[] args) throws InterruptedException {
        int cantidadGue;
        Scanner sc = new Scanner(System.in);

        cantidadGue = 0;
        int res = 0;
        do {

            do {

                try {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("¿Cuantos guerreros pelearan?");
                    System.out.println("------------------------------------------------------------------");
                    cantidadGue = sc.nextInt();
                } catch (Exception ex) {
                    System.out.print("Un error se produjó: " + ex.getMessage());
                }

            } while (cantidadGue % 2 != 0);

            Guerrero[] griegos = new Guerrero[cantidadGue / 2];
            Guerrero[] troyanos = new Guerrero[cantidadGue / 2];

            for (int i = 0; i < cantidadGue / 2; i++) {
                System.out.println("\n***********************");
                System.out.println("Regristar griegos");
                System.out.println("***********************");
                Thread.sleep(1 * 1000);
                griegos[i] = RegistroGriegos();

                System.out.println("\n***********************");
                System.out.println("Regristar troyano");
                System.out.println("***********************");
                Thread.sleep(1 * 1000);
                troyanos[i] = RegistroTroyano();
            }

            Pelea(griegos, troyanos);
            
            try{
            System.out.println("Desea volver a empezar");
            System.out.println("1 = NO");
            System.out.println("2 = SI");
            res = sc.nextInt();
            } catch (Exception ex) {
                    System.out.print("Un error se produjó: " + ex.getMessage());
                }
        } while (res <1 || res >1);
    }

    private static Guerrero RegistroTroyano() {
        Troyano troyano = null;
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear guerrero personalizado.");
            System.out.println("2. Crear guerrero con valores existentes.");
            System.out.println("3. Copiar un guerrero existente.");

            opcion = sc.nextInt();

        } while (opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del troyano:");
                String nombre = sc.next();
                System.out.println("Ingrese la edad :");
                int edad = sc.nextInt();
                System.out.println("Ingrese la fuerza :");
                int fuerza = sc.nextInt();

                troyano = new Troyano(nombre, edad, fuerza);
                break;
            case 2:
                troyano = new Troyano();
                break;
            case 3:
                Guerrero guerreroExistente = new Guerrero("GuerreroExistente", 30, 7) {
                };

                System.out.println("Ingrese el nombre del nuevo troyano:");
                String nuevoNombre = sc.next();
                troyano = new Troyano(guerreroExistente, nuevoNombre);
                break;
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Se ha creado el siguiente guerrero Troyano:");
        System.out.println("Nombre: " + troyano.getNombre());
        System.out.println("Edad: " + troyano.getEdad());
        System.out.println("Fuerza: " + troyano.getFuerza());
        System.out.println("-------------------------------------------------------------------");
        return troyano;
    }

    private static Guerrero RegistroGriegos() {
        Griego griego = null;
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Selciona:");
            System.out.println("1. Crear guerrero con valores personalizados.");
            System.out.println("2. Crear guerrero con valores predeterminados.");
            System.out.println("3. Copiar un guerrero existente como griego.");

            opcion = sc.nextInt();

        } while (opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del griego:");
                String nombre = sc.next();
                System.out.println("Ingrese la edad del griego:");
                int edad = sc.nextInt();
                System.out.println("Ingrese la fuerza del griego:");
                int fuerza = sc.nextInt();

                griego = new Griego(nombre, edad, fuerza);
                break;
            case 2:
                griego = new Griego();
                break;
            case 3:
                Guerrero guerreroExistente = new Guerrero("GuerreroExistente", 30, 7) {
                };

                System.out.println("Ingrese el nombre del nuevo griego:");
                String nuevoNombre = sc.next();
                griego = new Griego(guerreroExistente, nuevoNombre);
                break;
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Se ha creado el siguiente guerrero del bando de Grecia:");
        System.out.println("Nombre: " + griego.getNombre());
        System.out.println("Edad: " + griego.getEdad());
        System.out.println("Fuerza: " + griego.getFuerza());
        System.out.println("------------------------------------------------------------------");
        return griego;
    }

    private static void Pelea(Guerrero[] griegos, Guerrero[] troyanos) throws InterruptedException {
        Random random = new Random();
        int batallasGanadasGriegos = 0;
        int batallasGanadasTroyanos = 0;

        for (int i = 0; i < griegos.length; i++) {
            Guerrero guerreroGriego = griegos[i];
            Guerrero guerreroTroyano = troyanos[i];

            System.out.println("--------------------------COMBATE---------------------------------");
            System.out.println("------------------------------------------------------------------");
            int ini = random.nextInt(2) + 1;

            if (ini == 1) {
                while (!guerreroGriego.Muerto() && !guerreroTroyano.Muerto()) {
                    int danio = random.nextInt(10) + 1;
                    guerreroTroyano.Danio(danio);
                    System.out.println(guerreroGriego.getNombre() + " atacó a " + guerreroTroyano.getNombre() + " con " + danio + " puntos de daño.");

                    if (guerreroTroyano.Muerto()) {
                        System.out.println(guerreroTroyano.getNombre() + " ha sido derrotado.");
                        batallasGanadasGriegos++; // Incrementa el contador de victorias de los griegos
                        break;
                    }

                    danio = random.nextInt(10) + 1;
                    guerreroGriego.Danio(danio);
                    System.out.println(guerreroTroyano.getNombre() + " contraatacó a " + guerreroGriego.getNombre() + " con " + danio + " puntos de daño.");

                    if (guerreroGriego.Muerto()) {
                        System.out.println(guerreroGriego.getNombre() + " ha sido derrotado.");
                        batallasGanadasTroyanos++; // Incrementa el contador de victorias de los troyanos
                    }
                }
            } else {
                while (!guerreroTroyano.Muerto() && !guerreroGriego.Muerto()) {
                    int danio = random.nextInt(10) + 1;
                    guerreroGriego.Danio(danio);
                    System.out.println(guerreroTroyano.getNombre() + " atacó a " + guerreroGriego.getNombre() + " con " + danio + " puntos de daño.");

                    if (guerreroGriego.Muerto()) {
                        System.out.println(guerreroGriego.getNombre() + " ha sido derrotado.");
                        batallasGanadasTroyanos++; // Incrementa el contador de victorias de los griegos
                        break;
                    }

                    danio = random.nextInt(10) + 1;
                    guerreroTroyano.Danio(danio);
                    System.out.println(guerreroGriego.getNombre() + " contraatacó a " + guerreroTroyano.getNombre() + " con " + danio + " puntos de daño.");

                    if (guerreroTroyano.Muerto()) {
                        System.out.println(guerreroTroyano.getNombre() + " ha sido derrotado.");
                        batallasGanadasGriegos++; // Incrementa el contador de victorias de los troyanos
                    }

                }

            }

            // Mostrar el resultado final de las batallas
            System.out.println("""
                       \nRESULTADO DEL COMBATE:
                       Griegos ganadas: """ + batallasGanadasGriegos + "\n"
                    + "Troyanos ganadas: " + batallasGanadasTroyanos + "\n");
            Thread.sleep(2 * 1000);
            if (i != griegos.length - 1) {

                System.out.println("------------------------------------------------------------------");
                System.out.println("---------------------SIGUIENTE COMBATE----------------------------");
                System.out.println("------------------------------------------------------------------\n");
            } else {
                System.out.println("------------------------------------------------------------------");
                System.out.println("---------------------BATALLA TERMINADA----------------------------");
                System.out.println("------------------------------------------------------------------");
            }

        }

        if (batallasGanadasGriegos > batallasGanadasTroyanos) {
            System.out.println("******************************");
            System.out.println("LOS GRIEGOS GANARON LA BATALLA");
            System.out.println("******************************");
        } else {
            if (batallasGanadasGriegos == batallasGanadasTroyanos) {
                System.out.println("******************************");
                System.out.println("LA BATALLA FINALIZO SIN GANADOR");
                System.out.println("******************************");
            }
            System.out.println("******************************");
            System.out.println("LOS TROYANO GANARON LA BATALLA");
            System.out.println("******************************");
        }

    }

}
