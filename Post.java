/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Post.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
import java.util.ArrayList;

public abstract class Post {
    protected ArrayList<String> comentarios;
    protected String nombre;
    protected String fecha;
    protected String hora;
    protected String hashtags;
    protected int nlikes;
    protected String tipo;
    protected String mensaje;
    protected String desc;
    public Post(String nombre, String hora, String fecha, String hashtags, String tipo, String mensaje){
        comentarios = new ArrayList<>();
        this.nombre=nombre;
        this.hora=hora;
        this.fecha=fecha;
        this.hashtags=hashtags;
        this.tipo=tipo;
        this.mensaje = mensaje;
        nlikes=0;
    }
    public void set_comentario(String comentario){
        comentarios.add(comentario);
    }
    public void add_like(){
        nlikes++;
    }
    public String get_hashtags(){
        return hashtags;
    }
    public String get_fecha(){
        return fecha;
    }
    public String get_hora(){
        return hora;
    }
    public String get_tipo(){
        return tipo;
    }
    public String get_mensaje(){
        return mensaje;
    }
    public String get_desc(){
        return desc;
    }
    abstract public String getPost();
    
}
