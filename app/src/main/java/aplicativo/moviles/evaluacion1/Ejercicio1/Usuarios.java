package aplicativo.moviles.evaluacion1.Ejercicio1;

public class Usuarios {
    private String usuario;
    private String password;

    public Usuarios(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    private String getUsuario() {
        return usuario;
    }

    public String isUserValidate(){
        if(usuario.equals("miguel") && password.equals("java")){
            return getUsuario();
        }else if(usuario.equals("carlos") && password.equals("android")){
            return getUsuario();
        }else{
            return null;
        }
    }

}
