public class Libros{
        String titulo;
        String autor;
        String categoria;
        boolean prestado;

        private final boolean prestadoDeterminado= false;
    
        public Libros(String titulo, String autor, String categoria) {
            this.titulo = titulo;
            this.autor = autor;
            this.categoria = categoria;
            this.prestado = prestadoDeterminado;
        }

        public void setTitulo(String Titulo){
            this.titulo = Titulo;
        }

        public String getTitulo(){
            return this.titulo;
        }

        public void setAutor(String Autor){
            this.autor = Autor;
        }

        public String getAutor(){
            return this.autor;
        }

        public void setCategoria(String Categoria){
            this.categoria = Categoria;
        }

        public String getCategoria(){
            return this.categoria;
        }

        public void setPrestado(boolean Prestado){
            this.prestado = Prestado;
        }

        public boolean getPrestado(){
            return this.prestado;
        }
    
        @Override
        public String toString() {
            String sino;
            if (prestado) {
                sino = "Sí";
            } 
            else {
                sino = "No";
            }
            return "Titulo: " + titulo + ", Autor: " + autor + ", Categoria: " + categoria + ", Prestado: " + sino;
        }
}
