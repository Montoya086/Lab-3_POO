/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Emoticon.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
public class Emoticon extends Post{
    public Emoticon(String nombre, String hora, String fecha, String hashtags, String emote){
        super(nombre, hora, fecha, hashtags, "Emoticon", emote);
    }
    
    
    /** 
     * @return String
     */
    public String getPost(){//devolver post
        String strcoment="";
        int ncoment=0;
        for(int i=0; i<comentarios.size();i++){
            ncoment=i+1;
            strcoment+="("+ncoment+") "+comentarios.get(i)+"\n";
        }
        return nombre+"   "+fecha+"  "+hora+"   Likes: "+nlikes+"\n"+hashtags+"\n("+tipo+")  "+mensaje+"\n ----->Comentarios: \n"+strcoment;
    }
}
