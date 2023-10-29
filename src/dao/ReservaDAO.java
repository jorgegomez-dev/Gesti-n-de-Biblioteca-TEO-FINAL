package dao;

import domain.*;
import java.util.List;

public interface ReservaDAO {

    //3. Metodo Getter para obtener la lista de Reservas de la biblioteca por orden de id
    public List<Reserva> getReservas();

    //4. Metodo para generar una nueva reserva
    public void generarReserva(List<Socio> socios, List<Libro> libros, long idLibro, long idSocio);

    //5. Metodo para buscar una reserva por id
    public void busquedaReservaID(long id);

    //6. Metodo para buscar una reserva por id del Socio
    public void busquedaReservaIDSocio(long id);

    //7. Metodo para buscar una reserva por id del Libro
    public void busquedaReservaIDLibro(long id);

    //8. Metodo para eliminar Reserva y actualizar el estado del Socio y del Libro
    public void eliminarReserva(List<Socio> socios, List<Libro> libros, long idReserva, long idSocio, long idLibro);

    //9. Metodo que muestra por pantalla la cantidad de Reservas Historicas y la cantidad de Reservas activas
    public void estadisticasReservas();

    //10. Metodo que muestra la informacion pertinente a cada reserva que este ingresado en la biblioteca
    public void info(List<Reserva> reservas);
}
