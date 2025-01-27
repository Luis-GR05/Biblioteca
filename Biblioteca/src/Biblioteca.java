import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    private List<Libros> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libros libro, Usuario admin) {

        if (admin.getRol().equals("admin")) {
            libros.add(libro);
            System.out.println("Libro agregado " + libro);
        } else {
            System.out.println("Solo un administrador puede agregar libros.");
        }
    }

    public void eliminarLibro(Libros libro, Usuario admin) {
        if (admin.getRol().equals("admin")) {
            if (libros.remove(libro)) {
                System.out.println("Libro eliminado: " + libro);
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else {
            System.out.println("Solo un administrador puede eliminar libros.");
        }
    }

    public void buscarLibro(String criterio) {
        System.out.println("Resultados de búsqueda para: " + criterio);
        for (Libros libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                libro.getAutor().toLowerCase().contains(criterio.toLowerCase()) ||
                libro.getCategoria().toLowerCase().contains(criterio.toLowerCase())) {
                System.out.println(libro);
            }
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libros libro : libros) {
            if (!libro.getPrestado()) {
                System.out.println(libro);
            }
        }
    }

    public void prestarLibro(Libros libro, Usuario usuario, Usuario admin) {
        if (!libro.getPrestado()) {
            libro.setPrestado(true);
            usuario.prestadoActivo(libro);
            System.out.println("Libro prestado: " + libro);
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }

    public void dejarLibro(Libros libro, Usuario usuario, Usuario admin) {
        if (libro.getPrestado()) {
            libro.setPrestado(false);
            usuario.setPrestadoActivo(false);
            System.out.println("Libro devuelto: " + libro);
            } 
            else {
                System.out.println("El libro no está prestado.");
            }
    }


    public void registrarUsuario(Usuario usuario, Usuario admin) {
        if (admin.getRol().equals("admin")) {
            usuarios.add(usuario);
            System.out.println("Usuario registrado: " + usuario);
        } else {
            System.out.println("Solo un administrador puede registrar usuarios.");
        }
    }
}