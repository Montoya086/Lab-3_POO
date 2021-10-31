/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Texto.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
public class Texto extends Post {
    public Texto(String nombre, String hora, String fecha, String hashtags, String mensaje){
        super(nombre, hora, fecha, hashtags, "Texto", mensaje);
    }
    public String getPost(){
        String strcoment="";
        int ncoment=0;
        for(int i=0; i<comentarios.size();i++){
            ncoment=i+1;
            strcoment+="("+ncoment+") "+comentarios.get(i)+"\n";
        }
        return nombre+"   "+fecha+"  "+hora+"   Likes: "+nlikes+"\n"+hashtags+"\n("+tipo+")  "+mensaje+"\n ----->Comentarios: \n"+strcoment;
    }
}
