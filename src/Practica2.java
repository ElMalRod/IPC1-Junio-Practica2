package src;

import java.util.*;

public class Practica2 {

    //* Declaramos las variables globales */
    Random Aleatoreo = new Random();
    Scanner sc = new Scanner(System.in);

    int PosicionPelicula = 2;
    int PosicionCliente = 2;
    int TotalCliente = 3;
    int TotalPeli = 3;
    int Suspenso = 0, Accion = 0, Infantil = 0, Prestada = 0;
    int RegistroPrestada[] = new int[100];

    String NombreCliente[] = new String[100];
    int IdCliente[] = new int[100];
    int Tel[] = new int[100];
    boolean PrestamoCliente[] = new boolean[100];

    String NombrePelicula[] = new String[100];
    String Categoria[] = new String[6];
    int IdPelicula[] = new int[100];
    int[] Anio = new int[100];
    boolean Disponible[] = new boolean[100];

    int Idpeliculaprestada[] = new int[100];
    int Idclienteprestado[] = new int[100];
    int Dias[] = new int[100];

    public static void main(String[] args) {

        Practica2 eje = new Practica2();
    }

    /*Metodo Principal que inicializa  los arreglos y el Menu*/
    public Practica2() {
        InicializadorCliente();
        inicializadorPeli();
        Menu();
    }

    /*Metodo Menu contiene la mayor parte de los metodos y es lo primero que
    visualiza el usuario*/
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
                    Devolucion();
                    break;

                case 3:
                    MostrarPeli();
                    break;
                case 4:
                    AgregarPeli();
                    break;
                case 5:
                    OrdenPeli();
                    break;
                case 6:
                    AgregarCliente();
                    break;
                case 7:
                    MostrarCliente();
                    break;
                case 8:
                    MenuReportes();
                    break;

                default:
                    System.out.println("Solo números entre 1 y 8");
            }

        }

    }

    /*Metodo Para Agregar Nuevas peliculas al Arreglo*/
    public void AgregarPeli() {
        PosicionPelicula++;
        System.out.println("Ingrese Nombre de la Pelicula:");
        NombrePelicula[PosicionPelicula] = sc.next();
        System.out.println("Ingrese Categoria: ");
        Categoria[PosicionPelicula] = sc.next();
        IdPelicula[PosicionPelicula] = TotalPeli + 1;
        System.out.println("Id Agregado");
        System.out.println("Ingrese Año: ");
        Anio[PosicionPelicula] = sc.nextInt();
        Disponible[PosicionPelicula] = true;
        TotalPeli++;
    }

    /*Metodo Para Visualizar las peliculas del Arreglo*/
    public void MostrarPeli() {
        for (int i = 0; i <= PosicionPelicula; i++) {
            System.out.println("NO." + (i + 1) + " ");
            System.out.println("Pelicula: " + NombrePelicula[i]);
            System.out.println("Categoria: " + Categoria[i]);
            System.out.println("ID: " + IdPelicula[i]);
            System.out.println("Año: " + Anio[i]);
            if (Disponible[i] == true) {
                System.out.println("Disponiblirdad: Disponible");
            } else {
                System.out.println("Disponiblirdad: NO Disponible");
            }
            System.out.println("------------------------------------");

        }
    }

    /*Inicializadores
    existe el de Pelicula y el del cliente unicamente contienen los primeros datos
    de los arrglos y son llamados al inicio para que se carguen los datos ya credos*/
    public void inicializadorPeli() {
        NombrePelicula[0] = "Up!";
        Categoria[0] = "Infantil";
        IdPelicula[0] = 1;
        Anio[0] = 2000;
        Disponible[0] = true;

        NombrePelicula[1] = "Avengers";
        Categoria[1] = "Accion";
        IdPelicula[1] = 2;
        Anio[1] = 2013;
        Disponible[1] = true;

        NombrePelicula[2] = "IT";
        Categoria[2] = "Suspenso";
        IdPelicula[2] = 3;
        Anio[2] = 1998;
        Disponible[2] = true;

    }

    /*Metodo Para Agregar nuevos clientes al Arreglo */
    public void AgregarCliente() {
        PosicionCliente++;
        System.out.println("Ingrese su nombre Nombre: ");
        NombreCliente[PosicionCliente] = sc.next();
        IdCliente[PosicionCliente] = TotalCliente + 1;
        System.out.println("Ingrese su Numero de Telefono: ");
        Tel[PosicionCliente] = sc.nextInt();
        PrestamoCliente[PosicionCliente] = false;
        TotalCliente++;
    }

    /*Metodo Para Visualizar los CLientes del Arreglo*/
    public void MostrarCliente() {
        for (int i = 0; i <= PosicionCliente; i++) {
            System.out.println("NO-" + (i + 1));
            System.out.println("Nombre: " + NombreCliente[i]);
            System.out.println("ID: " + IdCliente[i]);
            System.out.println("No.Telefonico: " + Tel[i]);
            if (PrestamoCliente[i] == false) {
                System.out.println("Disponiblirdad: Sin Peliculas");
            } else {
                System.out.println("Disponiblirdad: Pelicula en propiedad: " + Idpeliculaprestada[i]);
            }
            System.out.println("------------------------------------");

        }

    }

    /*Inicializadores
    existe el de Pelicula y el del cliente unicamente contienen los primeros datos
    de los arrglos y son llamados al inicio para que se carguen los datos ya credos*/
    public void InicializadorCliente() {
        IdCliente[0] = 1;
        NombreCliente[0] = "Oliver Sierra";
        Tel[0] = 45123698;
        PrestamoCliente[0] = false;

        IdCliente[1] = 2;
        NombreCliente[1] = "Emilio Maldonado";
        Tel[1] = 35396898;
        PrestamoCliente[1] = false;

        IdCliente[2] = 3;
        NombreCliente[2] = "Bryan Santos";
        Tel[2] = 34546899;
        PrestamoCliente[2] = false;

    }

    /*Metodo que funciona para escoger cliente el cual es utilizado en la prestacion
    de peliculas para identtificar al cliente*/
    public void EscogerCliente() {
        MostrarCliente();
        int seleccion;
        System.out.println("Seleccione Cliente:");
        seleccion = sc.nextInt();
        for (int i = 0; i <= PosicionCliente; i++) {
            if (seleccion == IdCliente[i]) {
                System.out.println(NombreCliente[i] + " Inicio sesion");
                PrestamoCliente[i] = true;
                Idclienteprestado[i] = IdCliente[i];
            }
        }
    }

    /*Metodo qie funciona para escoger pelicula el cual es utilizado en el prestamo
    para identificar la pelicual y a que usuario es prestada*/
    public void EscogerPelicula() {
        int seleccion;
        MostrarPeli();
        System.out.println("Seleccione Pelicula:");
        seleccion = sc.nextInt();
        for (int i = 0; i <= PosicionPelicula; i++) {
            if (seleccion == IdPelicula[i]) {
                System.out.println(NombrePelicula[i] + " Prestada");
                Disponible[i] = false;
                Idpeliculaprestada[i] = IdPelicula[i];
                RegistroPrestada[i]++;

            }

        }
        Prestada++;
    }

    /*Metodo que contiene dos funciones importantes y son utilizadas para este metodo*/
    public void Prestamo() {

        EscogerCliente();
        EscogerPelicula();

    }

    /*Metodo para devolver peliculas  identifica al usuario que va a devolver y tambien la pelicula
    que va devolver regrsando estas a su estado Disponible*/
    public void Devolucion() {
        MostrarCliente();
        int seleccion;
        int seleccion2;
        int i;
        System.out.println("Seleccione Cliente:");
        seleccion = sc.nextInt();
        for (i = 0; i <= 1; i++) {
            if (seleccion == IdCliente[i]) {
                System.out.println(NombreCliente[i] + " Inicio sesion");
                System.out.println(NombrePelicula[i] + " En propiedad");
            }
            System.out.println("Devolver Pelicula:");
            System.out.println("1. Si   2. NO");
            seleccion2 = sc.nextInt();
            if (seleccion2 == 1) {
                PrestamoCliente[i] = false;
                Disponible[i] = true;

            } else {
                System.out.println("");
            }

        }
    }

    public void OrdenPeli() {
        System.out.println("Categorias:");
        for (int i = 0; i <= PosicionPelicula; i++) {
            if (Categoria[i] == "Accion") {
                System.out.println("Accion");
                System.out.println(NombrePelicula[i]);
            }
            if (Categoria[i] == "Suspenso") {
                System.out.println("Suspenso:");
                System.out.println(NombrePelicula[i]);
            }
            if (Categoria[i] == "Infatil") {
                System.out.println("Infantil");
                System.out.println(NombrePelicula[i]);
            }
        }

    }

    /*Metodo del Menu de reportes*/
    public void MenuReportes() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Cantidad de Peliculas por categoria");
            System.out.println("2. Peliculas por categoria");
            System.out.println("3. Peliculas y cantidad de veces prestada");
            System.out.println("4. Pelicula mas prestada");
            System.out.println("5. Pelicula menos prestada");
            System.out.println("6. Regresar");
            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();
            /*Switch para ingresar a las opciones del menu de reportes
            en cada case va la logica para ya no inclir mas metodos*/
            switch (opcion) {
                case 1:
                    System.out.println("Categorias:");
                    for (int i = 0; i <= PosicionPelicula; i++) {
                        if (Categoria[i] == "Accion") {
                            Accion++;
                        }
                    }
                    for (int i = 0; i <= PosicionPelicula; i++) {
                        if (Categoria[i] == "Suspenso") {
                            Suspenso++;
                        }
                    }
                    for (int i = 0; i <= PosicionPelicula; i++) {
                        if (Categoria[i] == "Infantil") {
                            Infantil++;
                        }
                    }
                    System.out.println("Accion");
                    System.out.println(Accion);
                    System.out.println("Suspenso:");
                    System.out.println(Suspenso);
                    System.out.println("Infantil:");
                    System.out.println(Infantil);
                    break;
                case 2:
                    System.out.println("Categorias:");
                    for (int i = 0; i <= PosicionPelicula; i++) {
                        if (Categoria[i] == "Accion") {
                            System.out.println("Accion");
                            System.out.println(NombrePelicula[i]);
                        }
                        if (Categoria[i] == "Suspenso") {
                            System.out.println("Suspenso:");
                            System.out.println(NombrePelicula[i]);
                        }
                        if (Categoria[i] == "Infatil") {
                            System.out.println("Infantil");
                            System.out.println(NombrePelicula[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Peliculas Prestadas");
                    for (String Aux : NombrePelicula) {
                        System.out.println(Aux);
                    }
                    System.out.println("Prestamos:" + Prestada);
                    break;
                case 4:
                    for (int i = 0; i < TotalPeli; i++) {
                        for (int j = 0; j < TotalPeli; j++) {
                            if (RegistroPrestada[i] > RegistroPrestada[j]) {
                                System.out.println(NombrePelicula[i]);
                            }

                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < TotalPeli; i++) {
                        for (int j = 0; j < TotalPeli; j++) {
                            if (RegistroPrestada[i] < RegistroPrestada[j]) {
                                System.out.println(NombrePelicula[i]);
                            }

                        }
                    }
                    break;
                case 6:
                    Menu();
                    break;

                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }

    }

}
