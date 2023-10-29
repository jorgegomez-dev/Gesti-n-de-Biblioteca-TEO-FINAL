package dao;

import domain.Libro;
import java.util.List;

public interface LibroDAO {

    //3. Metodo Getter para obtener la lista de libros de la biblioteca por orden de id
    public List<Libro> getLibros();

    //4. Metodo para agregar un libro ya existente en la biblioteca y que este disponible para la reserva
    public void agregarLibroBiblioteca(Libro libro);

    //5. Metodo que permite ordenar alfabeticamente por Titulo a todos los libros y hacer una busqueda tipo Scroll
    public void busquedaAlfaPorTitulo(List<Libro> libros);

    //6. Metodo que permite ordenar alfabeticamente por Genero a todos los libros y hacer una busqueda tipo Scroll
    public void busquedaAlfaPorGenero(List<Libro> libros);

    //7. Metodo que permite buscar por coincidencia de cadenas un Titulo (Ignorando mayusculas y minusculas).
    public void busquedaPorTitulo(List<Libro> libros, String titulo);

    //8. Metodo que permite buscar por coincidencia de cadenas un Genero (Ignorando mayusculas y minusculas).
    public void busquedaPorGenero(List<Libro> libros, String genero);

    //9. Metodo que permite buscar por coincidencia de cadenas un Apellido de Autor (Ignorando mayusculas y minusculas).
    public void busquedaPorApellidoAutor(List<Libro> libros, String apellido);

    //10. Metodo que permite buscar un libro por ID
    public int busquedaLibroID(long id);

    //11. Metodo que permite Eliminar un libro
    public void eliminarLibro(long id);

    //12. Metodo que permite Actualizar un libro existente
    public void actualizarLibro(long id, String titulo, String genero, String editorial, int anio, String autorNombre, String autorApellido, String estado);

    //13. Metodo que muestra por pantalla la cantidad de Libros que tiene la Biblioteca
    public void estadisticasLibros();

    //14. Metodo que muestra la informacion pertinente a cada libro que este ingresado en la biblioteca
    public void info(List<Libro> libros);
}
