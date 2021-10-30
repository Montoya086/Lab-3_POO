import java.util.ArrayList;

public abstract class Post {
    protected ArrayList<String> comentarios = new ArrayList<>();
    protected String nombre;
    protected String fecha;
    protected String hora;
    protected String hashtags;
    protected int nlikes;
    protected String tipo;
    protected String mensaje;
    protected String desc;
    public Post(String nombre, String hora, String fecha, String hashtags, String tipo, String mensaje){
        this.nombre=nombre;
        this.hora=hora;
        this.fecha=fecha;
        this.hashtags=hashtags;
        this.tipo=tipo;
        this.mensaje = mensaje;
    }
    abstract public String getPost();
}
