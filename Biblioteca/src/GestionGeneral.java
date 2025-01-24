/*
      @autor LuisGordillo
      @autor Jorge Alegre
*/

import java.util.Scanner;

public class GestionGeneral {
      public static void main(String[] args) {

      Libros libro1 = new Libros("La Sombra Del Viento", "Carlos Ruíz Zafón", "MISTERIO");
      Libros libro2 = new Libros("La piedra filosofal", "J.K. Rowling", "FANTASÍA");
      Libros libro3 = new Libros("Los pilares de la Tierra", "Ken Follett", "NOVELA HISTORICA");
      Libros libro4 = new Libros("Geronimo Stilton","Elisabetta Dami","LITERATURA INFANTIL");
      Libros libro5 = new Libros("El señor de los anillos","J.R.R. TOLKIEN","FANTASÍA");
      Libros libro6 = new Libros("Orgullo y prejuicio","Jane Austen","DRAMA");
      Libros libro7 = new Libros("El Principito","Antoine de Saint-Exupéry","LITERATURA INFANTIL");
      Libros libro8 = new Libros("La Odisea","Homero","NARRATIVA POÉTICA");
   
      Usuario admin = new Usuario("Luis", "admin");
      Usuario usuario = new Usuario("Jorge", "usuario");

      admin.agregarLibro(libro1);
      admin.agregarLibro(libro3);

      usuario.agregarLibro(libro2);
      usuario.agregarLibro(libro5);
 }
    // Menú interactivo
      public void menu(Usuario usuario) {
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                  System.out.println("\n=== Menú de la Biblioteca ===");
                  System.out.println("1. Buscar libro");
                  System.out.println("2. Mostrar libros disponibles");
                  System.out.println("3. Prestar libro");
                  System.out.println("4. Devolver libro");

                  if (usuario.getRol().equals("admin")) {
                        System.out.println("5. Agregar libro");
                        System.out.println("6. Eliminar libro");
                        System.out.println("7. Registrar usuario");
                        System.out.println("8. Mostrar libros prestados");
                  }

                  System.out.println("0. Salir");
                  System.out.print("Elige una opción: ");
                  int opcion = scanner.nextInt();

                  switch (opcion) {
                        case 1:
                              System.out.print("Introduce el criterio de búsqueda: ");
                              String criterio = scanner.nextLine();
                              buscarLibro(criterio);
                              break;
                        case 2:
                              mostrarLibros();
                              break;
                        case 3:
                              System.out.print("Introduce el título del libro a prestar: ");
                              String tituloPrestar = scanner.nextLine();
                              Libros libroPrestar = Libro.stream()
                                          .filter(l -> l.getTitulo().equalsIgnoreCase(tituloPrestar)).findFirst()
                                          .orElse(null);
                              if (libroPrestar != null) {
                                    prestarLibro(libroPrestar, usuario);
                              } else {
                                    System.out.println("Libro no encontrado.");
                              }
                              break;
                        case 4:
                              System.out.print("Introduce el título del libro a devolver: ");
                              String tituloDevolver = scanner.nextLine();
                              Libro libroDevolver = libros.stream()
                                          .filter(l -> l.getTitulo().equalsIgnoreCase(tituloDevolver)).findFirst()
                                          .orElse(null);
                              if (libroDevolver != null) {
                                    devolverLibro(libroDevolver, usuario);
                              } else {
                                    System.out.println("Libro no encontrado.");
                              }
                              break;
                        case 5:
                              if (usuario.getRol().equals("admin")) {
                                    System.out.print("Introduce el título del nuevo libro: ");
                                    String nuevoTitulo = scanner.nextLine();
                                    System.out.print("Introduce el autor: ");
                                    String nuevoAutor = scanner.nextLine();
                                    System.out.print("Introduce la categoría: ");
                                    String nuevaCategoria = scanner.nextLine();
                                    agregarLibro(new Libro(nuevoTitulo, nuevoAutor, nuevaCategoria), usuario);
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;
                        case 6:
                              if (usuario.getRol().equals("admin")) {
                                    System.out.print("Introduce el título del libro a eliminar: ");
                                    String tituloEliminar = scanner.nextLine();
                                    Libro libroEliminar = libros.stream()
                                                .filter(l -> l.getTitulo().equalsIgnoreCase(tituloEliminar)).findFirst()
                                                .orElse(null);
                                    if (libroEliminar != null) {
                                          eliminarLibro(libroEliminar, usuario);
                                    } else {
                                          System.out.println("Libro no encontrado.");
                                    }
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;
                        case 7:
                              if (usuario.getRol().equals("admin")) {
                                    System.out.print("Introduce el nombre del nuevo usuario: ");
                                    String nuevoNombre = scanner.nextLine();
                                    System.out.print("Introduce el rol (admin/usuario): ");
                                    String nuevoRol = scanner.nextLine();
                                    registrarUsuario(new Usuario(nuevoNombre, nuevoRol), usuario);
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;
                        case 8:
                              if (usuario.getRol().equals("admin")) {
                                    mostrarLibrosPrestados();
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;
                        case 0:
                              salir = true;
                              System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                              break;
                        default:
                              System.out.println("Opción no válida.");
                              break;
                  }
            }
      }
 
}
