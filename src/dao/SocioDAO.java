package dao;

import domain.Socio;
import java.util.List;

public interface SocioDAO {

    //3. Metodo Getter para obtener la lista de Socios de la biblioteca por orden de id
    public List<Socio> getSocios();

    //4. Metodo que permite Agregar un Socio de Biblioteca
    public void agregarSocioBiblioteca(Socio socio);

    //5. Metodo que permite buscar por coincidencia de cadenas un Apellido de Socio (Ignorando mayusculas y minusculas).
    public void busquedaPorApellidoSocio(String apellido);

    //6. Metodo que permite buscar un Socio por ID
    public int busquedaSocioID(long id);

    //7. Metodo que permite buscar un Socio por DNI
    public void busquedaPorDNI(String dni);

    //8. Metodo que Verifica que al cargarse un Socio no se encuentre repetido
    public int verificarExistencia(String nombre, String apellido, String dni);

    //9. Metodo que permite Actualizar un Socio Existente
    public void actualizarSocio(long id, String nombre, String apellido, String dni, long telefono, String dire);

    //10. Metodo que permite Eliminar un Socio
    public void eliminarSocio(long id);

    //11. Metodo que muestra por pantalla la cantidad de Socios Historicos y Activos que tiene la Biblioteca
    public void estadisticasSocios();
    
    //14. Metodo que muestra la informacion pertinente a cada socio que este ingresado en la biblioteca
    public void info(List<Socio> socios);
}
