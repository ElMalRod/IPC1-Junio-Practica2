package src;

import java.util.*;

public class Practica2 {

    Random Aleatoreo = new Random();
    Scanner sc = new Scanner(System.in);
    int contadorpeliculas = 3;
    int posiciones = 2;
    int posicionCliente = 0;

    String NombreCliente[] = new String[100];
    int IdCliente[] = new int[100];
    int Tel[] = new int[100];
    boolean PrestamoCliente[] = new boolean[100];

    String NombrePelicula[] = new String[100];
    String Categoria[] = new String[6];
    int IdPelicula[] = new int[100];
    int Ano[] = new int[100];
    boolean Disponible[] = new boolean[100];

    int Idpeliculaprestada[] = new int[100];
    int Idclienteprestado[] = new int[100];
    int Dias[] = new int[100];

    public static void main(String[] args) {

        Practica2 eje = new Practica2();
    }

    public Practica2() {

        NombrePelicula[0] = "Up!";
        NombrePelicula[1] = "Avengers";
        NombrePelicula[2] = "IT";

        Categoria[0] = "Infantil";
        Categoria[1] = "Accion";
        Categoria[2] = "Suspenso";

        IdPelicula[0] = 1;
        IdPelicula[1] = 2;
        IdPelicula[2] = 3;

        Ano[0] = 2000;
        Ano[1] = 2013;
        Ano[2] = 1998;

        Disponible[0] = true;
        Disponible[1] = true;
        Disponible[2] = true;
        Menu();
    }

    public void Menu() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Prestamo de Peliculas");
            System.out.println("2. Devolucion de Peliculas");
            System.out.println("3. Mostrar Peliculas");
            System.out.println("4. Ingresar Pelicula");
            System.out.println("5. Ordenar Peliculas");
            System.out.println("6. Ingresar Cliente");
            System.out.println("7. Mostrar Clientes");
            System.out.println("8. Reportes");

            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Prestamo();

                    break;
                case 2:

                    break;

                case 3:
                    MostrarPeli();
                    break;
                case 4:
                    AgregarPeli();
                    break;
                case 5:

                    break;
                case 6:
                    AgregarCliente();
                    break;
                case 7:
                    MostrarCliente();
                    break;
                case 8:
                    salir = true;
                    break;

                default:
                    System.out.println("Solo números entre 1 y 8");
            }

        }

    }

    public void AgregarPeli() {
        posiciones++;
        int num;
        System.out.println("Ingrese Nombre de la Pelicula:");
        NombrePelicula[posiciones] = sc.next();
        System.out.println("Ingrese Categoria: ");
        Categoria[posiciones] = sc.next();
        num = Aleatoreo.nextInt(100);
        for (int i = 0; i <= posiciones; i++) {
            if (IdPelicula[i] == num) {
                System.out.println("Id Agregado");

            } else if (IdPelicula[i] != num) {
                IdPelicula[posiciones] = num;
            }
        }

        System.out.println("Ingrese Año: ");
        Ano[posiciones] = sc.nextInt();
        Disponible[posiciones] = true;
    }

    public void MostrarPeli() {
        for (int i = 0; i <= posiciones; i++) {
            System.out.println("NO." + (i + 1) + " ");
            System.out.println("Pelicula: " + NombrePelicula[i]);
            System.out.println("Categoria: " + Categoria[i]);
            System.out.println("ID: " + IdPelicula[i]);
            System.out.println("Año: " + Ano[i]);
            if (Disponible[i] == true) {
                System.out.println("Disponiblirdad: Disponible");
            } else {
                System.out.println("Disponiblirdad: NO Disponible");
            }
            System.out.println("------------------------------------");

        }
    }

    public void AgregarCliente() {
        int num;
        System.out.println("Ingrese su nombre Nombre: ");
        NombreCliente[posicionCliente] = sc.next();
        num = Aleatoreo.nextInt(100);
        for (int i = 0; i <= posiciones; i++) {
            if (IdCliente[i] != num) {
                IdCliente[posiciones] = num;
            } else if (IdCliente[i] == num) {
                 System.out.println("Id copiado");
            }
        }
        System.out.println("Ingrese su Numero de Telefono: ");
        Tel[posicionCliente] = sc.nextInt();
        PrestamoCliente[posicionCliente] = false;
        posicionCliente++;
    }

    public void MostrarCliente() {
        for (int i = 0; i <= posicionCliente; i++) {
            System.out.println("NO-" + (i + 1));
            System.out.println("Nombre: " + NombreCliente[i]);
            System.out.println("ID: " + IdCliente[i]);
            System.out.println("No.Telefonico: " + Tel[i]);
            if (PrestamoCliente[i] == false) {
                System.out.println("Disponiblirdad: Sin Peliculas");
            } else {
                System.out.println("Disponiblirdad: Peliculas en propiedad");
            }
            System.out.println("------------------------------------");

        }

    }

    public void EscogerCliente() {
        MostrarCliente();
        int seleccion;
        System.out.println("Seleccione Cliente:");
        seleccion = sc.nextInt();
        for (int i = 0; i < posicionCliente; i++) {
            if (seleccion == IdCliente[i]) {
                System.out.println(NombreCliente[i] + " Incio sesion");
            }
        }
    }
    public void EscogerPelicula(){
         int seleccion;
         MostrarPeli();
        System.out.println("Seleccione Pelicula:");
        seleccion = sc.nextInt();
        for (int i = 0; i < posiciones; i++) {
            if (seleccion == IdPelicula[i]) {
                System.out.println(NombrePelicula[i] + "Prestada");
                Disponible[i] = false;
                PrestamoCliente[i] = true;
                
            }
        }
    }
    public void Prestamo() {
       
        EscogerCliente();
        EscogerPelicula();
     
    }

}
