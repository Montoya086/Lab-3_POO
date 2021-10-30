public class Emoticon extends Post{
    public Emoticon(String nombre, String hora, String fecha, String hashtags, String emote){
        super(nombre, hora, fecha, hashtags, "Texto", emote);
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
