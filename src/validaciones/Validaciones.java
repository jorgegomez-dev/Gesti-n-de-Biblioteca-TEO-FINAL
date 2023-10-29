package validaciones;

import java.util.Scanner;

/* 1. En esta clase colocamos los metodos de validacion de entradas (finalmente solo fue para evitar que el usuario 
      dejase campos vacios de Strings (para evitar que se creen objetos instanciados con campos sin completar). 
      Los posibles errores por causa de ingreso de textos en campos reservados para numeros, los controlamos con estructuras
      try / catch atrapando sobre todo los errores de NumberFormatException, directamente en Main.
 */
public class Validaciones {

    Scanner in = new Scanner(System.in);

    public Validaciones() {
    }

    //1. Metodo para validar entradas de texto y que no queden vacias a la hora de crear nuevas Instancias de Clases
    //   No queremos que se permita crear nuevos objetos sin que esten todos los datos completos.
    public boolean validarCampoVacio(String texto) {

        boolean band = false;

        if (texto.isEmpty()) {
            band = true;
        }
        return band;
    }

    //2. Metodo para validar DNI
    //   Explicacion de la Expresion Regular (REGEX) 
    //   [0-9] <-- Solo se admiten numeros del 0 al 9
    //   {8}   <-- Hasta 8 caracteres (que es lo que tiene un DNI)
    public String validarNumDNI(String texto) {

        while (validarCampoVacio(texto) == true || !texto.matches("[0-9]{8}")) {

            System.out.println("'" + texto + "', " + "no es un DNI valido.");
            System.out.println("Ingrese solo (8) numeros sin puntos ni comas: ");
            texto = in.nextLine();
        }
        return texto;
    }

    //3. Metodo para validar Texto (Apellidos, Nombres, Titulos, Etc)
    //   Explicacion de la Expresion Regular (REGEX) 
    //   [a-zA-Z\\s] <-- Solo se admiten letras de la A a la Z (tanto en mayusculas como Minusculas) y espacios
    //   *        <-- No hay limite de caracteres
    public String validarTexto(String texto) {

        while (validarCampoVacio(texto) == true || !texto.matches("[a-zA-Z\\s]*")) {

            System.out.println("'" + texto + "', " + "no es un Texto valido.");
            System.out.println("Ingrese solo Letras (sin numeros, caracteres especiales o espacios): ");
            texto = in.nextLine();
        }
        return texto;
    }

    //4. Metodo para validar Direccion del Socio
    //   Explicacion de la Expresion Regular (REGEX)
    //   ^            <-- Inicio de la Cadena
    //   [a-zA-Z\\s]  <-- Solo se admiten letras de la A a la Z (tanto en mayusculas como Minusculas) y espacios
    //   +            <-- se agregan terminos diferentes
    //   [0-9]        <-- Solo se admiten numeros del 0 al 9
    //   {1,5         <-- Minimo 1 numero y Maximo 5
    //   $            <-- Fin de la Cadena
    public String validarDireccion(String texto) {

        while (validarCampoVacio(texto) == true || !texto.matches("^[a-zA-Z\\s]+[0-9]{1,5}$")) {

            System.out.println("'" + texto + "', " + "no es un Texto valido.");
            System.out.println("Ingrese Calle/Avenida (solo Letras) + Altura (Max. 5 numeros): ");
            texto = in.nextLine();
        }
        return texto;
    }

    /* -------------------------------------------------------------------------------------------------------
       VALIDACIONES ESPECIALES para la actualizacion de datos, permitiendo espacios en blanco o salto de linea
       en los casos en que no querramos modificar parametros existentes.
       -------------------------------------------------------------------------------------------------------*/
    //5. Metodo para validar Texto con Permiso para ingresar Saltos de Linea (Enter)
    public String validarTextoConPermisos(String texto) {

        if (validarCampoVacio(texto) != true) {

            while (!texto.matches("[a-zA-Z]*")) {
                System.out.println("'" + texto + "', " + "no es un Texto valido.");
                System.out.println("Ingrese solo Letras (sin numeros, caracteres especiales o espacios): ");
                texto = in.nextLine();
            }
        }
        return texto;
    }

    //6. Metodo para validar DNI con Permiso para ingresar Saltos de Linea (Enter)
    public String validarNumDNIConPermisos(String texto) {

        if (validarCampoVacio(texto) != true) {

            while (!texto.matches("[0-9]{8}")) {

                System.out.println("'" + texto + "', " + "no es un DNI valido.");
                System.out.println("Ingrese solo (8) numeros sin puntos ni comas: ");
                texto = in.nextLine();
            }
        }
        return texto;
    }

    //7. Metodo para validar Direcciones con Permiso para ingresar Saltos de Linea (Enter)
    public String validarDireccionConPermisos(String texto) {

        if (validarCampoVacio(texto) != true) {

            while (!texto.matches("^[a-zA-Z\\s]+[0-9]{1,5}$")) {
                System.out.println("'" + texto + "', " + "no es un Texto valido.");
                System.out.println("Ingrese Calle/Avenida (solo Letras) + Altura (5 numeros): ");
                texto = in.nextLine();
            }
        }
        return texto;
    }

    //8. Metodo para validar Año
    //   Explicacion de la Expresion Regular (REGEX) 
    //   [0-9] <-- Solo se admiten numeros del 0 al 9
    //   {4}   <-- Hasta 4 caracteres (que es lo que tiene un Año)
    public int validarAnio(String anio) {

        while (validarCampoVacio(anio) == true || !anio.matches("[0-9]{4}")) {

            System.out.println("'" + anio + "', " + "no es un Año valido.");
            System.out.println("Ingrese solo (4) numeros sin puntos ni comas: ");
            anio = in.nextLine();
        }

        return Integer.parseInt(anio);
    }

    //8. Metodo para validar Año Con Permiso para ingresar Saltos de Linea (Enter)
    //   Explicacion de la Expresion Regular (REGEX) 
    //   [0-9] <-- Solo se admiten numeros del 0 al 9
    //   {4}   <-- Hasta 4 caracteres (que es lo que tiene un Año)
    public int validarAnioConPermisos(String anio) {

        if (validarCampoVacio(anio) != true) {

            while (!anio.matches("[0-9]{4}")) {

                System.out.println("'" + anio + "', " + "no es un Año valido.");
                System.out.println("Ingrese solo (4) numeros sin puntos ni comas: ");
                anio = in.nextLine();
            }
        }

        return Integer.parseInt(anio);
    }

    //9. Metodo para generar una pausa en el programa, que permita al usuario leer los resultados en pantalla antes de volver al menu
    public void pausa() {
        System.out.println("Presione la tecla Enter para continuar...");
        in.nextLine();
    }
}
