public class Usuario {

        String nombre;
        String rol;
        boolean prestadoActivo;

        private String rolDefecto = "usuario";
        private String prestadoDefecto = "false";

        public Usuario(String nombre, String rol){
            this.nombre = nombre;
            this.rol = comprobarRol(rol);
            this.prestadoActivo = prestadoDefecto;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public String getNombre(){
            return this.nombre;
        }

        public void setRol(String rol){
            this.rol = comprobarRol(rol);
        }

        public String getRol(){
            return this.rol;
        }

        public void setPrestadoActivo(boolean Prestado){
            this.prestadoActivo = Prestado;
        }

        public boolean getPrestadoActivo(){
            return this.prestadoActivo;
        }

        public String comprobarRol(String rol){
            String rolAct;
            if(!rol.equals("usuario") || !rol.equals("admin")){
                rolAct = rolDefecto;
            }
            else{
                rolAct = rol;
            }

            return rolAct;
        }


        @Override
        public String toString() {
            return "{" +
                " nombre='" + getNombre() + "'" +
                ", rol='" + getRol() + "'" +
                ", prestadoActivo='" + getPrestadoActivo() + "'" +
                ", rolDefecto='" + getRolDefecto() + "'" +
                ", prestadoDefecto='" + getPrestadoDefecto() + "'" +
                "}";
        }

}
