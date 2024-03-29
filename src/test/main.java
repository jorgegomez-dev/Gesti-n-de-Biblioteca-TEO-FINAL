package test;

import validaciones.Validaciones;
import menu.Menu;
import daoimpl.*;
import domain.*;
import java.util.*;

/**
 *
 * @author Grupo 4 - ESBA - POO 2023 
 * Alumnos: Campos, Juan Pablo / Grimalt, Maria Valeria / Gomez, Jorge Miguel
 * 
 */
public class main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menues = new Menu();
        Validaciones validar = new Validaciones();

        //----------------------------------------------------------------------------------------
        // LIBROS PRECARGADOS ********************************************************************
        LibroDAOimpl libroDAO = new LibroDAOimpl();

        //1. Creacion de instancia de clase libros mediante constructor sin parametros y llenado por notacion de punto
        Libro libro1 = new Libro();
        libro1.setAnio(1978);
        libro1.setAutorApellido("King");
        libro1.setAutorNombre("Stephen");
        libro1.setEditorial("Americana");
        libro1.setGenero("Terror");
        libro1.setTitulo("IT");
        libro1.setEstado("Disponible");

        //2. Creacion de instancias de libros mediante constructor con parametros 
        Libro libro2 = new Libro("Cien Sonetos de Amor", "Poesia", "Seix Barral", 2021, "Pablo", "Neruda", "Disponible");
        Libro libro3 = new Libro("Biblia", "Religion", "Guttemberg", 2000, "NN", "Dios", "Disponible");
        Libro libro4 = new Libro("Tora", "Religion", "Nosesabe", 1956, "NN", "Dios", "Disponible");
        Libro libro5 = new Libro("Scream", "Terror", "Queseyo", 1996, "Sss", "Beck", "Disponible");
        Libro libro6 = new Libro("The Shinning", "Terror", "Planet", 1981, "Stephen", "King", "Disponible");

        //3. Llamada al metodo para agregar cada libro creado a la base de datos de la Biblioteca
        libroDAO.agregarLibroBiblioteca(libro1);
        libroDAO.agregarLibroBiblioteca(libro2);
        libroDAO.agregarLibroBiblioteca(libro3);
        libroDAO.agregarLibroBiblioteca(libro4);
        libroDAO.agregarLibroBiblioteca(libro5);
        libroDAO.agregarLibroBiblioteca(libro6);

        //----------------------------------------------------------------------------------------
        // SOCIOS PRECARGADOS ********************************************************************
        SocioDAOimpl socioDAO = new SocioDAOimpl();

        //1. Creacion de instancia de clase Socios mediante constructor con parametros
        Socio socio1 = new Socio("Juan", "Perez", "31190600", 11669578, "Av.Siempreviva 663");
        Socio socio2 = new Socio("Jose", "Lugones", "20150150", 1175856, "Calle Falsa 1234");
        Socio socio3 = new Socio("Ramon", "Ramone", "42600300", 11758566, "Calle Urticaria 5678");

        //2. Llamada al metodo para agregar cada socio creado a la base de datos de la Biblioteca
        socioDAO.agregarSocioBiblioteca(socio1);
        socioDAO.agregarSocioBiblioteca(socio2);
        socioDAO.agregarSocioBiblioteca(socio3);

        //----------------------------------------------------------------------------------------
        // RESERVAS PRECARGADAS ******************************************************************
        ReservaDAOimpl reservaDAO = new ReservaDAOimpl();

        //1. Llamada al metodo para generar una nueva reserva de un libro
        reservaDAO.generarReserva(socioDAO.getSocios(), libroDAO.getLibros(), 100005, 1002);
        reservaDAO.generarReserva(socioDAO.getSocios(), libroDAO.getLibros(), 100002, 1003);

        // FIN DE DATOS PRECARGADOS **************************************************************
        //----------------------------------------------------------------------------------------
        
        
        
        
        // INICIO CODIGO DEL SISTEMA DE GESTION 
        
        System.out.println("");
        menues.msjElijaOpcion();
        int menuP = 5; // Inicializo para Default (hay 4 case)

        do { //MENU PRINCIPAL
            menues.menuPrincipal();
            try {
                menuP = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("El dato ingresado no es valido.");
                menuP = 5; // Default y que quede atrapado en el Menu
            }

            switch (menuP) {

                case 0 ->
                    System.out.println("Gracias por usar nuestro sistema! Adios");
                case 1 -> {
                    int menuL = 11; // Inicializo para Default (hay 10 case)
                    
                    do { //MENU GESTION DE LIBROS
                        menues.msjElijaOpcion();
                        menues.menuLibros();
                        
                        try {
                            menuL = Integer.parseInt(in.nextLine());
                        } catch (Exception e) {
                            System.out.println("El dato ingresado no es valido.");
                            menuL = 11; // Default y que quede atrapado en el Menu
                        }
                        switch (menuL) {
                            case 0 ->
                                System.out.println("");
                            case 1 -> {
                                libroDAO.info(libroDAO.getLibros());
                                validar.pausa();
                                break;
                            }
                            case 2 -> {
                                libroDAO.busquedaAlfaPorTitulo(libroDAO.getLibros());
                                validar.pausa();
                                break;
                            }
                            case 3 -> {
                                libroDAO.busquedaAlfaPorGenero(libroDAO.getLibros());
                                validar.pausa();
                                break;
                            }
                            case 4 -> {
                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID del libro.");
                                    idLibro = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }
                                if (idLibro != 0) {
                                    libroDAO.busquedaLibroID(idLibro);
                                }
                                validar.pausa();
                                break;
                            }
                            case 5 -> {
                                System.out.println("Ingrese el Titulo del Libro: ");
                                String titulo = validar.validarTexto(in.nextLine());
                                libroDAO.busquedaPorTitulo(libroDAO.getLibros(), titulo);
                                validar.pausa();
                                break;
                            }
                            case 6 -> {
                                System.out.println("Ingrese el Apellido del Autor del Libro");
                                String autor = validar.validarTexto(in.nextLine());
                                libroDAO.busquedaPorApellidoAutor(libroDAO.getLibros(), autor);
                                validar.pausa();
                                break;
                            }
                            case 7 -> {
                                System.out.println("Ingrese el Genero del Libro.");
                                String genero = validar.validarTexto(in.nextLine());
                                libroDAO.busquedaPorGenero(libroDAO.getLibros(), genero);
                                validar.pausa();
                                break;
                            }
                            case 8 -> {

                                System.out.println("Ingrese el Titulo del libro.");
                                String titulo = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese el Genero del libro.");
                                String genero = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese la Editorial del libro.");
                                String editorial = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese el Nombre del Autor del libro.");
                                String nombreAutor = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese el Apellido del Autor del libro.");
                                String apellidoAutor = validar.validarTexto(in.nextLine());

                                String estado = "Disponible";

                                System.out.println("Ingrese el Año de publicacion.");
                                int anio = (validar.validarAnio(in.nextLine()));

                                Libro libroX = new Libro(titulo, genero, editorial, anio, nombreAutor, apellidoAutor, estado);
                                libroDAO.agregarLibroBiblioteca(libroX);
                                validar.pausa();
                                break;
                            }

                            case 9 -> {
                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID del libro:");
                                    idLibro = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }

                                if (idLibro != 0 && libroDAO.busquedaLibroID(idLibro) == 1) {
                                    
                                    System.out.println("");
                                    System.out.println("A continuacion ingrese los datos o deje en blanco si no hay modificaciones.");
                                    System.out.println("ATENCION: Cualquier ingreso de datos modificara los parametros del Libro");
                                    System.out.println("");
                                    System.out.println("Ingrese el Titulo del libro.");
                                    String titulo = validar.validarTextoConPermisos(in.nextLine());
                                    System.out.println("Ingrese el Genero del libro.");
                                    String genero = validar.validarTextoConPermisos(in.nextLine());
                                    System.out.println("Ingrese la Editorial del libro.");
                                    String editorial = validar.validarTextoConPermisos(in.nextLine());

                                    System.out.println("Ingrese el Año de publicacion.");
                                    int anio = (validar.validarAnio(in.nextLine()));

                                    System.out.println("Ingrese el Nombre del Autor del libro.");
                                    String nombreAutor = validar.validarTextoConPermisos(in.nextLine());
                                    System.out.println("Ingrese el Apellido del Autor del libro.");
                                    String apellidoAutor = validar.validarTextoConPermisos(in.nextLine());
                                    String estado = "";
                                    libroDAO.actualizarLibro(idLibro, titulo, genero, editorial, anio, nombreAutor, apellidoAutor, estado);

                                }
                                validar.pausa();
                                break;
                            }

                            case 10 -> {
                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID del libro:");
                                    idLibro = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }
                                libroDAO.eliminarLibro(idLibro);
                                validar.pausa();
                                break;
                            }

                            default -> {
                                System.out.println("No ha seleccionado una opcion valida");
                                validar.pausa();
                                break;
                            }
                        }
                    } while (menuL != 0);
                    break;
                }

                case 2 -> {

                    int menuS = 8; // Inicializo para Default (hay 7 case)

                    do { //MENU GESTION DE SOCIOS

                        menues.msjElijaOpcion();
                        menues.menuSocios();

                        try {
                            menuS = Integer.parseInt(in.nextLine());
                        } catch (Exception e) {
                            System.out.println("El dato ingresado no es valido.");
                            menuS = 8; // Default y que quede atrapado en el Menu
                        }

                        switch (menuS) {
                            case 0 ->
                                System.out.println("");
                            case 1 -> {
                                socioDAO.info(socioDAO.getSocios());
                                validar.pausa();
                                break;
                            }
                            case 2 -> {
                                long idSocio = 0;
                                try {
                                    System.out.println("Ingrese el ID del Socio.");
                                    idSocio = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }
                                if (idSocio != 0) {
                                    socioDAO.busquedaSocioID(idSocio);
                                }
                                validar.pausa();
                                break;
                            }
                            case 3 -> {
                                System.out.println("Ingrese el Apellido del Socio: ");
                                String apellido = validar.validarTexto(in.nextLine());
                                socioDAO.busquedaPorApellidoSocio(apellido);
                                validar.pausa();
                                break;
                            }

                            case 4 -> {
                                System.out.println("Ingrese el DNI del Socio (sin puntos ni espacios): ");
                                String dni = validar.validarNumDNI(in.nextLine());
                                socioDAO.busquedaPorDNI(dni);
                                validar.pausa();
                                break;
                            }
                            case 5 -> {
                                System.out.println("Ingrese el Nombre del nuevo Socio:");
                                String nombre = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese el Apellido del nuevo Socio:");
                                String apellido = validar.validarTexto(in.nextLine());
                                System.out.println("Ingrese el DNI:");
                                String dni = validar.validarNumDNI(in.nextLine());
                                System.out.println("Ingrese la Direccion:");
                                String dire = validar.validarDireccion(in.nextLine());

                                long tel = 0;
                                try {
                                    System.out.println("Ingrese un numero de telefono:");
                                    tel = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Se guardara como cero. Puede modificarlo actualizando el Socio.");
                                }

                                int select = socioDAO.verificarExistencia(nombre, apellido, dni);
                                if (select == 0) {
                                    Socio socioX = new Socio(nombre, apellido, dni, tel, dire);
                                    socioDAO.agregarSocioBiblioteca(socioX);
                                }
                                validar.pausa();
                                break;
                            }
                            case 6 -> {

                                long idSocio = 0;
                                try {
                                    System.out.println("Ingrese el ID del Socio:");
                                    idSocio = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }

                                if (idSocio != 0 && socioDAO.busquedaSocioID(idSocio) == 1) {
                                    System.out.println("");
                                    System.out.println("A continuacion ingrese los datos o deje en blanco si no hay modificaciones.");
                                    System.out.println("ATENCION: Cualquier ingreso de datos modificara los parametros del Socio");
                                    System.out.println("");
                                    System.out.println("Ingrese el Nombre:");
                                    String nombre = validar.validarTextoConPermisos(in.nextLine());
                                    System.out.println("Ingrese el Apellido:");
                                    String apellido = validar.validarTextoConPermisos(in.nextLine());
                                    System.out.println("Ingrese el DNI:");
                                    String dni = validar.validarNumDNIConPermisos(in.nextLine());
                                    System.out.println("Ingrese Direccion:");
                                    String dire = validar.validarDireccionConPermisos(in.nextLine());

                                    long telefono = 0;

                                    try {
                                        System.out.println("Ingrese el Telefono:");
                                        telefono = Long.parseLong(in.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("Este dato no es valido. Puede modificarlo posteriormente.");
                                    }

                                    socioDAO.actualizarSocio(idSocio, nombre, apellido, dni, telefono, dire);
                                }
                                validar.pausa();
                                break;

                            }
                            case 7 -> {
                                long idSocio = 0;
                                try {
                                    System.out.println("Ingrese el ID del Socio.");
                                    idSocio = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }
                                socioDAO.eliminarSocio(idSocio);
                                validar.pausa();
                                break;
                            }

                            default -> {
                                System.out.println("No ha seleccionado una opcion valida");
                                validar.pausa();
                                break;
                            }
                        }

                    } while (menuS != 0);
                    break;
                }

                case 3 -> {
                    int menuR = 7; // Inicializo para Default (hay 6 case)

                    do { //MENU GESTION DE RESERVAS

                        menues.msjElijaOpcion();
                        menues.menuReservas();

                        try {
                            menuR = Integer.parseInt(in.nextLine());
                        } catch (Exception e) {
                            System.out.println("El dato ingresado no es valido.");
                            menuR = 7; // Default y que quede atrapado en el Menu
                        }

                        switch (menuR) {
                            case 0 ->
                                System.out.println("");

                            case 1 -> {

                                long idSocio = 0;
                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID del Socio:");
                                    idSocio = Long.parseLong(in.nextLine());
                                    System.out.println("Ingrese el ID del Libro:");
                                    idLibro = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                }

                                if (idSocio != 0 && idSocio != 0) {
                                    reservaDAO.generarReserva(socioDAO.getSocios(), libroDAO.getLibros(), idLibro, idSocio);
                                }
                                validar.pausa();
                                break;

                            }
                            case 2 -> {

                                long idReserva = 0;
                                try {
                                    System.out.println("Ingrese el ID de la Reserva:");
                                    idReserva = Long.parseLong(in.nextLine());

                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                }

                                if (idReserva != 0) {
                                    reservaDAO.busquedaReservaID(idReserva);
                                }
                                validar.pausa();
                                break;

                            }

                            case 3 -> {

                                long idSocio = 0;
                                try {
                                    System.out.println("Ingrese el ID del Socio:");
                                    idSocio = Long.parseLong(in.nextLine());

                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                }

                                if (idSocio != 0) {
                                    reservaDAO.busquedaReservaIDSocio(idSocio);
                                }
                                validar.pausa();
                                break;
                            }

                            case 4 -> {

                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID del Libro:");
                                    idLibro = Long.parseLong(in.nextLine());

                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                }

                                if (idLibro != 0) {
                                    reservaDAO.busquedaReservaIDLibro(idLibro);
                                }
                                validar.pausa();
                                break;
                            }

                            case 5 -> {

                                long idReserva = 0;
                                long idSocio = 0;
                                long idLibro = 0;
                                try {
                                    System.out.println("Ingrese el ID de la Reserva:");
                                    idReserva = Long.parseLong(in.nextLine());
                                    System.out.println("Ingrese el ID del Socio:");
                                    idSocio = Long.parseLong(in.nextLine());
                                    System.out.println("Ingrese el ID del Libro:");
                                    idLibro = Long.parseLong(in.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Este dato no es valido.");
                                    System.out.println("Regreso al menu anterior.");
                                }
                                reservaDAO.eliminarReserva(socioDAO.getSocios(), libroDAO.getLibros(), idReserva, idSocio, idLibro);
                                validar.pausa();
                                break;
                            }

                            case 6 -> {
                                System.out.println("Las Reservas activas en este momento son:");
                                reservaDAO.info(reservaDAO.getReservas());
                                validar.pausa();
                            }

                            default -> {
                                System.out.println("No ha seleccionado una opcion valida");
                                validar.pausa();
                                break;
                            }

                        }

                    } while (menuR != 0);
                    break;
                }

                case 4 -> {
                    libroDAO.estadisticasLibros();
                    socioDAO.estadisticasSocios();
                    reservaDAO.estadisticasReservas();
                    validar.pausa();
                }

                default -> {
                    System.out.println("No ha seleccionado una opcion valida");
                    validar.pausa();
                    break;
                }
            }

        } while (menuP != 0);
    }

}
