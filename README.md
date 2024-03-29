# Gesti-n-de-Biblioteca-TEO-FINAL
TEO Final - POO 2023

## Informacion del TP

Materia: Programación Orientada a Objetos - B (ASC-POO-B)
Profesora: Carina Quiroga
Grupo 4:  - ESBA - POO 2023 
Alumnos: Campos, Juan Pablo / Grimalt, Maria Valeria / Gomez, Jorge Miguel

-------------------------------------------------------------------------------
SISTEMA de GESTION de BIBLIOTECA
El desarrollo es un sistema para una Biblioteca de libros fisicos. El usuario del mismo, sera el administrador 
de la biblioteca. Entre los requerimientos que debe cumplir el programa, estan:

    -> Carga de nuevos Libros al Stock General
    -> Eliminacion de Libros del Stock General
    -> Actualizacion de datos de Libros (Titulo, Autor, Año, Genero, etc)
    -> Acceso y Persistencia de Libros (en este caso no se trabajara con BD, pero simularemos el proceso con un Array Dinamico)
    -> Busqueda individual de Libros (por iD, Titulo o Autor)
    -> Busqueda general de Libros (por Autor o Genero)
    -> Carga de nuevos Socios a la Biblioteca (Alta nuevos socios)
    -> Eliminacion de Socios a la Biblioteca (Baja de socios)
    -> Actualizacion de datos de Socios (Nombre, Apellido, Direccion, Telefono, etc)
    -> Acceso y Persistencia de Socios (en este caso no se trabajara con BD, pero simularemos el proceso con un Array Dinamico)
    -> Busqueda individual de Socios (por iD, Apellido)
    -> Generar nuevas Reservas
    -> Eliminar Reservas
    -> Acceso y Persistencia de Reservas (en este caso no se trabajara con BD, pero simularemos el proceso con un Array Dinamico)
    -> Busqueda individual de Reservas (por iDreserva, iDsocio, iDlibro)
    -> Control de cantidad de Libros reservados por Socio (Max. 3)
    -> Estadisticas Generales (Socios, Libros, Reservas)
    * (Entendemos que podrian ampliarse notablemente estos requerimientos, pero por cuestiones de tiempo creemos
       que son suficientes para el fin del TP que se esta realizando).

-------------------------------------------------------------------------------
DESCRIPCION DEL PROYECTO JAVA
1. El proyecto esta dividido en 4 packages principales
    * domain: contiene las clases de las entidades mas importantes con las que vamos a trabajar (3 entidades principales)
      (Libro, Reserva y Socio). Ellas nos serviran para moldear las instancias de estas clases (los objetos).
    * dao: contiene las interfaces que contendran la declaracion de los metodos de acceso a datos que deben implementarse
    * daoimpl: contiene las clases que implementaran las interfaces y ademas tendran los datos (los ArrayList, que
      serviran para almacenar temporalmente los datos de testing. 
    * test: aqui colocamos el main, que nos servira para trabajar testeando el codigo
    * Ademas se encuentran los packages que contienen las clases de apoyo para generar Menues y Validaciones.
-------------------------------------------------------------------------------
INFORMACION IMPORTANTE
1. El Sistema ya cuenta con algunos Libros, Socios y Reservas Pre-cargados, para que sea mas facil el testing.

A continuacion detallamos la informacion:

LIBROS
------------------------------------------------------------------------------------------------------------
[id: 100001, Titulo: IT, Genero: Terror, Autor: King, Stephen, Año: 1978, Editorial: Americana, Estado: Disponible]
[id: 100002, Titulo: Cien Sonetos de Amor, Genero: Poesia, Autor: Neruda, Pablo, Año: 2021, Editorial: Seix Barral, Estado: Reservado]
[id: 100003, Titulo: Biblia, Genero: Religion, Autor: Dios, NN, Año: 2000, Editorial: Guttemberg, Estado: Disponible]
[id: 100004, Titulo: Tora, Genero: Religion, Autor: Dios, NN, Año: 1956, Editorial: Nosesabe, Estado: Disponible]
[id: 100005, Titulo: Scream, Genero: Terror, Autor: Beck, Sss, Año: 1996, Editorial: Queseyo, Estado: Reservado]
[id: 100006, Titulo: The Shinning, Genero: Terror, Autor: King, Stephen, Año: 1981, Editorial: Planet, Estado: Disponible]
------------------------------------------------------------------------------------------------------------

SOCIOS
------------------------------------------------------------------------------------------------------------
[id: 1001, Nombre: Juan, Apellido: Perez, DNI: 31190600, Telefono: 11669578, Direccion: Av.Siempreviva 663, Reservas Disponibles: 3]
[id: 1002, Nombre: Jose, Apellido: Lugones, DNI: 20150150, Telefono: 1175856, Direccion: Calle Falsa 1234, Reservas Disponibles: 2]
[id: 1003, Nombre: Ramon, Apellido: Ramone, DNI: 42600300, Telefono: 11758566, Direccion: Calle Urticaria 5678, Reservas Disponibles: 2]
------------------------------------------------------------------------------------------------------------

RESERVAS
------------------------------------------------------------------------------------------------------------
[Reserva ID: 101, Socio ID: 1002, Libro ID: 100005]
[Reserva ID: 102, Socio ID: 1003, Libro ID: 100002]
------------------------------------------------------------------------------------------------------------
