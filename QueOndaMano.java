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
    
    /** 
     * @param texto
     * @param hash
     * @param hora
     * @param fecha
     */
    public void newPost_txt(String texto, String hash, String nombre){//creacion de post de texto
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);//fecha
        String hora = time.format(f)+"";//hora
        posts.add(new Texto(nombre, hora, fecha, hash, texto));
    }
    
    /** 
     * @param link
     * @param hash
     * @param nombre
     * @param caract
     * @param hora
     * @param fecha
     */
    public void newPost_multimd(String link, String hash, String nombre, String caract, String tipo){//creacion de post de multimedia
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);//fecha
        String hora = time.format(f)+"";//hora
        posts.add(new Multimedia(nombre, hora, fecha, hash, link, tipo, caract));
    }
    
    /** 
     * @param nemote
     * @param hash
     * @param hora
     * @param fecha
     * @param hash
     * @param criterio
     */
    public void newPost_emote(int nemote, String hash, String nombre){//creacion de post de emotes
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);//fecha
        String hora = time.format(f)+"";//hora
        posts.add(new Emoticon(nombre, hora, fecha, hash, emotes[nemote]));
    }
    
    /** 
     * @param criterio
     * @return int
     */
    public int getNemotes(){//numero de emotes
        return emotes.length;
    }
    
    /** 
     * @param criterio
     * @return int
     */
    public int getNposts(){//numero de posts
        return posts.size();
    }
    
    /** 
     * @param criterio
     * @return String
     */
    public String getPosts(String criterio, String busqueda){//busqueda por criterios
        String strpost="";
        if(criterio.equals("NA")){//sin criterio
            for(int i=0;i<posts.size();i++){
                strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
            }
        }else if(criterio.equals("HASH")){//por hashtags
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_hashtags().contains(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }else if(criterio.equals("DATE")){//por fecha
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_fecha().equals(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }else if(criterio.equals("HOUR")){//por hora
            for(int i=0;i<posts.size();i++){
                if(posts.get(i).get_hora().equals(busqueda)){
                    strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
                }
            }
        }
        return strpost;
    }
    
    /** 
     * @return String
     */
    public String getEmotes(){//mostrar emotes
        String stremotes="";
        for(int i=0;i<emotes.length;i++){
            stremotes+="("+i+") "+ emotes[i]+"\n";
        }
        return stremotes;
    }
    public void comentar(int index, String coment){//añadir comentario
        posts.get(index).set_comentario(coment);
    }
    public void dar_like(int index){//agregar like
        posts.get(index).add_like();
    }
    public String reproducir(int index){//reproducir
        String reprod= "";
        String tipo = posts.get(index).get_tipo();
        if(tipo.equals("Imagen")){//imagen
            reprod="Estoy mostrando la imagen: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Video")){//video
            reprod="Estoy mostrando el video: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Audio")){//audio
            reprod="Estoy mostrando el audio: "+posts.get(index).get_mensaje()+" Con: \n"+posts.get(index).get_desc();
        }else if(tipo.equals("Texto")){//texto
            reprod=posts.get(index).get_mensaje();
        }else if(tipo.equals("Emoticon")){//emoticon
            reprod=posts.get(index).get_mensaje();
        }

        return reprod;
    }

}
