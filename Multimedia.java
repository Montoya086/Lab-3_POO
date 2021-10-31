/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Multimedia.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
public class Multimedia extends Post{
    public Multimedia(String nombre, String hora, String fecha, String hashtags, String mensaje, String tipo, String caract){
        super(nombre, hora, fecha, hashtags, tipo, mensaje);
        desc = caract;
    }
    public String getPost(){
        String strcoment="";
        int ncoment=0;
        for(int i=0; i<comentarios.size();i++){
            ncoment=i+1;
            strcoment+="("+ncoment+") "+comentarios.get(i)+"\n";
        }
        return nombre+"   "+fecha+"  "+hora+"   Likes: "+nlikes+"\n"+hashtags+"\n("+tipo+")  "+mensaje+"\n"+desc+"\n ----->Comentarios: \n"+strcoment;
    }
}
