import java.util.Calendar;
import java.util.ArrayList;
import java.time.format.*;
import java.time.LocalTime;
public class QueOndaMano {
    ArrayList<Post> posts = new ArrayList<>(); 
    Calendar cal = Calendar.getInstance();
    DateTimeFormatter f= DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.now();
    String[] emotes={":-)",":^)","^_^",":,-)",";)",":-|",":-P",":-(",":-/","B)","O_o",":O",">.<"};
    public QueOndaMano(){

    }
    public void newPost_txt(String texto, String hash, String nombre){
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Texto(nombre, hora, fecha, hash, texto));
    }
    public void newPost_multimd(String link, String hash, String nombre, String caract, String tipo){
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Multimedia(nombre, hora, fecha, hash, link, tipo, caract));
    }
    public void newPost_emote(int nemote, String hash, String nombre){
        String fecha = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        String hora = time.format(f)+"";
        posts.add(new Emoticon(nombre, hora, fecha, hash, emotes[nemote]));
    }
    public int getNemotes(){
        return emotes.length;
    }
    public String getPosts(){
        String strpost="";
        for(int i=0;i<posts.size();i++){
            strpost+="("+i+") "+posts.get(i).getPost()+"\n\n";
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
    

}
