/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: QueOndaMano.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
import java.util.Calendar;
import java.util.ArrayList;
import java.time.format.*;
import java.time.LocalTime;
public class QueOndaMano {
    ArrayList<Post> posts = new ArrayList<>(); 
    String[] emotes={":-)",":^)","^_^",":,-)",";)",":-|",":-P",":-(",":-/","B)","O_o",":O",">.<"};
    public QueOndaMano(){

    }
    public void newPost_txt(String texto, String hash, String nombre){
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Texto(nombre, hora, fecha, hash, texto));
    }
    public void newPost_multimd(String link, String hash, String nombre, String caract, String tipo){
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Multimedia(nombre, hora, fecha, hash, link, tipo, caract));
    }
    public void newPost_emote(int nemote, String hash, String nombre){
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Emoticon(nombre, hora, fecha, hash, emotes[nemote]));
    }
    public int getNemotes(){
        return emotes.length;
    }
    public int getNposts(){
        return posts.size();
    }
    public String getPosts(String criterio, String busqueda){
        String strpost="";
        if(criterio.equals("NA")){
            for(int i=0;i<posts.size();i++){
                strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
            }
        }else if(criterio.equals("HASH")){
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_hashtags().contains(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }else if(criterio.equals("DATE")){
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_fecha().equals(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }else if(criterio.equals("HOUR")){
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_hora().equals(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }
        return strpost;
    }
    public String getEmotes(){
        String stremotes="";
        for(int i=0;i<emotes.length;i++){
            stremotes+="("+i+") "+ emotes[i]+"\n";
        }
        return stremotes;
    }
    public void comentar(int index, String coment){
        posts.get(index).set_comentario(coment);
    }
    public void dar_like(int index){
        posts.get(index).add_like();
    }
    public String reproducir(int index){
        String reprod= "";
        String tipo = posts.get(index).get_tipo();
        if(tipo.equals("Imagen")){
            reprod="Estoy mostrando la imagen: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Video")){
            reprod="Estoy mostrando el video: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Audio")){
            reprod="Estoy mostrando el audio: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Texto")){
            reprod=posts.get(index).get_mensaje();
        }else if(tipo.equals("Emoticon")){
            reprod=posts.get(index).get_mensaje();
        }

        return reprod;
    }

}
