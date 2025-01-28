/*
      @autor LuisGordillo
      @autor Jorge Alegre
*/

import java.util.Scanner;

public class GestionGeneral {
      public static void main(String[] args) {

            Biblioteca biblioteca = new Biblioteca();
            Libros libro1 = new Libros("La Sombra Del Viento", "Carlos Ruíz Zafón", "MISTERIO");
            Libros libro2 = new Libros("La piedra filosofal", "J.K. Rowling", "FANTASÍA");
            Libros libro3 = new Libros("Los pilares de la Tierra", "Ken Follett", "NOVELA HISTORICA");
            Libros libro4 = new Libros("Geronimo Stilton", "Elisabetta Dami", "LITERATURA INFANTIL");
            Libros libro5 = new Libros("El señor de los anillos", "J.R.R. TOLKIEN", "FANTASÍA");
            Libros libro6 = new Libros("Orgullo y prejuicio", "Jane Austen", "DRAMA");
            Libros libro7 = new Libros("El Principito", "Antoine de Saint-Exupéry", "LITERATURA INFANTIL");
            Libros libro8 = new Libros("La Odisea", "Homero", "NARRATIVA POÉTICA");

            Usuario admin = new Usuario("Luis", "admin");
            biblioteca.agregarUsuarioAdminInicial(admin);
            Usuario usuario = new Usuario("Jorge", "usuario");
            biblioteca.agregarUsuarioAdminInicial(usuario);
            
            biblioteca.agregarLibrosIniciales(libro1);
            biblioteca.agregarLibrosIniciales(libro2);
            biblioteca.agregarLibrosIniciales(libro3);
            biblioteca.agregarLibrosIniciales(libro4);
            biblioteca.agregarLibrosIniciales(libro5);
            biblioteca.agregarLibrosIniciales(libro6);
            biblioteca.agregarLibrosIniciales(libro7);
            biblioteca.agregarLibrosIniciales(libro8);

            String contraseñaAdmins="9123";
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("Para acceder a la biblioteca, por favor, ingrese su nombre de usuario:");
            String nombreUsuario = sc.nextLine();
            for(Usuario usuarioAct : biblioteca.getListaUsuario()){
                  if(usuarioAct.getNombre().equalsIgnoreCase(nombreUsuario)){
                        System.out.println("Ahora ingrese su contraseña:");
                        String contraseña = sc.nextLine();
                        if(contraseña.equals(contraseñaAdmins)){
                              Usuario actual = new Usuario(usuarioAct.getNombre(),usuarioAct.getRol());
                              System.out.println("Bienvenido "+nombreUsuario);
                              menu(actual, biblioteca);
                        }
                        else{
                              System.out.println("Contraseña incorrecta");
                        }
                  }
                  else{
                        System.out.println("Usuario no encontrado");
                  }
            }
            sc.close();
      }

      // Menú interactivo
      public static void menu(Usuario usuario, Biblioteca biblioteca) {
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
                  int opcion = Integer.parseInt(scanner.nextLine());

                  switch (opcion) {
                        case 1:
                              System.out.print("Introduce el criterio de búsqueda: ");
                              String criterio = scanner.nextLine();
                              biblioteca.buscarLibro(criterio);
                              break;
                        case 2:
                              biblioteca.mostrarLibrosDisponibles();
                              break;
                        case 3:
                              System.out.print("Introduce el título del libro a prestar: ");
                              scanner.nextLine();
                              String tituloPrestar = scanner.nextLine();
                              for (Libros libroPrestar : biblioteca.getListaLibros()) {
                                    if (libroPrestar.getTitulo().equals(tituloPrestar)) {
                                          biblioteca.prestarLibro(libroPrestar, usuario);
                                    }
                              }
                              break;
                        case 4:
                              System.out.print("Introduce el título del libro a devolver: ");
                              String tituloDevolver = scanner.nextLine();
                              for (Libros libroDevolver : biblioteca.getListaLibros()) {
                                    if (libroDevolver.getTitulo().equals(tituloDevolver)) {
                                          biblioteca.dejarLibro(libroDevolver, usuario);
                                    } else {
                                          System.out.println("Libro no encontrado.");
                                    }
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
                                    biblioteca.agregarLibro(new Libros(nuevoTitulo, nuevoAutor, nuevaCategoria),
                                                usuario);
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;
                        case 6:
                              if (usuario.getRol().equals("admin")) {
                                    System.out.print("Introduce el título del libro a eliminar: ");
                                    String tituloEliminar = scanner.nextLine();
                                    for (Libros libroEliminar : biblioteca.getListaLibros()) {
                                          if (libroEliminar.getTitulo().equals(tituloEliminar)) {
                                                biblioteca.eliminarLibro(libroEliminar, usuario);
                                          } else {
                                                System.out.println("Libro no encontrado.");
                                          }
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
                                    Usuario usuarioNuevo = new Usuario(nuevoNombre, nuevoRol);
                                    biblioteca.registrarUsuario(usuarioNuevo, usuario);
                              } else {
                                    System.out.println("No tienes permisos para esta opción.");
                              }
                              break;      
                        case 8:
                              if (usuario.getRol().equals("admin")) {
                                    biblioteca.mostrarLibrosPrestados();
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
            scanner.close();
      }

}
