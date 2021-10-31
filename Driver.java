/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Driver.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
public class Driver {
    public static void main(String[] args) {
        QueOndaMano chat = new QueOndaMano();
        Vista v = new Vista();
        boolean salir=false;
        v.bienvenida();
        while(!salir){
            int r=0;
            while (r!=1&&r!=2&&r!=3&&r!=4&&r!=5&&r!=6&&r!=7&&r!=8&&r!=9){//verificar valido
                r=v.menu();
            }
            switch (r) {
                case 1://Hacer un post
                    String nombre="";
                    while(nombre==""){//elegir nombre
                        nombre=v.ingreso_nombre();
                    }
                    String hash="";
                    while(hash==""){//escribir hashtags
                        hash=v.ingreso_hash();
                    }
                    int r2=0;
                    while (r2!=1&&r2!=2&&r2!=3&&r2!=4){
                        r2=v.menu_post();
                    }

                    switch (r2) {
                        case 1://post de texto
                            String texto="";
                            while(texto==""||texto.length()>40){//escribir texto
                                texto=v.ingreso_texto();
                                if(texto.length()>40){
                                    v.separador();
                                    v.chars();
                                    v.separador();
                                }
                            }
                            chat.newPost_txt(texto, hash, nombre);//crear post de texto
                            v.separador();
                            v.post();
                            v.separador();
                            break;
                        case 2://multimedia
                            String link="";
                            while(link==""||!link.contains("https")||link.contains(" ")){//escribir url
                                link=v.ingreso_link();
                                if(!link.contains("https")||link.contains(" ")){//verificar url
                                    v.separador();
                                    v.link();
                                    v.separador();
                                }
                            }
                            String size="";
                            while(size==""){//escribir tamaño
                                size=v.ingreso_size();
                            }
                            int r3=0;
                            while (r3!=1&&r3!=2&&r3!=3&&r3!=4){
                                r3=v.menu_multimedia();//menu de eleccion de multimedia
                            }
                            switch (r3) {
                                case 1://imagen
                                    String format="";
                                    while(format==""){//escribir formato
                                        format=v.ingreso_format();
                                    }
                                    String res="";
                                    while(res==""){//escribir resolucion
                                        res=v.ingreso_resol();
                                    }
                                    String caract = "Formato: "+format+" Resolucion: "+res+" Tamaño: "+size+"kB";//caracteristicas
                                    chat.newPost_multimd(link, hash, nombre, caract, "Imagen");//Crear post
                                    v.separador();
                                    v.post();
                                    v.separador();
                                    break;
                                case 2://video
                                    String fps="";
                                    while(fps==""){//escribir fps
                                        fps=v.ingreso_fps();
                                    }
                                    String caract2 = "Framerate: "+fps+" Tamaño: "+size+"kB";//caracteristicas
                                    chat.newPost_multimd(link, hash, nombre, caract2, "Video");// crear post
                                    v.separador();
                                    v.post();
                                    v.separador();
                                    break;
                                case 3://audio
                                    String samplerate="";
                                    while(samplerate==""){//escribir samplerate
                                        samplerate=v.ingreso_sample();
                                    }
                                    String bit="";
                                    while(bit==""){//escribir bitdepth
                                        bit=v.ingreso_bit();
                                    }
                                    String caract3 = "SampleRate: "+samplerate+"kHz"+" BitDepth: "+bit+" Tamaño: "+size+"kB";//caracteristicas
                                    chat.newPost_multimd(link, hash, nombre, caract3, "Audio");// crear post
                                    v.separador();
                                    v.post();
                                    v.separador();
                                    break;
                                case 4://salir                                    
                                    break;
                                default:
                                    break;
                            }
                            
                            break;
                        case 3://emoticones
                            int r4=-1;
                            while(r4<0||r4>chat.getNemotes()-1){//verificar valido
                                r4=v.emotes(chat.getEmotes());
                            }
                            chat.newPost_emote(r4, hash, nombre);
                            v.separador();
                            v.post();
                            v.separador();
                            break;
                        case 4: //salir
                            break;
                        default:
                            break;
                    }
                    break;
                case 2://hacer un comentario
                    if(chat.getNposts()!=0){//verificar vacio
                        int r4=-1;
                        while(r4<0||r4>chat.getNposts()-1){//verificar valido
                            r4=v.select_post();
                        }
                        String coment="";
                        while(coment==""){//colocar comentario
                            coment=v.ingreso_coment();
                        }
                        chat.comentar(r4, coment);
                        v.separador();
                        v.comentario();
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 3://dar like
                    if(chat.getNposts()!=0){//verificar vacio
                        int r4=-1;
                        while(r4<0||r4>chat.getNposts()-1){//verificar valido
                            r4=v.select_post();
                        }
                        chat.dar_like(r4);//dar like
                        v.separador();
                        v.like();
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 4:// buscar un hashtag
                    if(chat.getNposts()!=0){//verificar vacio
                        String hash_search="";
                        while(hash_search==""){//verificar valido
                            hash_search=v.ingreso_hash();
                        }
                        v.separador();
                        v.posts(chat.getPosts("HASH",hash_search));//mostrar con criterio de hashtag
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 5://Buscar fecha
                    if(chat.getNposts()!=0){//verificar vacio
                        String date_search="";
                        while(date_search==""){//verificar valido
                            date_search=v.ingreso_fecha();
                        }
                        v.separador();
                        v.posts(chat.getPosts("DATE",date_search));//mostrar con criterio de fecha
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 6://Buscar hora
                    if(chat.getNposts()!=0){
                        String hour_search="";
                        while(hour_search==""){
                            hour_search=v.ingreso_hora();
                        }
                        v.separador();
                        v.posts(chat.getPosts("HOUR",hour_search));//mostrar con criterio de hora
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 7://Reproducir
                    if(chat.getNposts()!=0){
                        int r4=-1;
                        while(r4<0||r4>chat.getNposts()-1){
                            r4=v.select_post();
                        }
                        v.separador();
                        v.posts(chat.reproducir(r4));
                        v.separador();
                    }else{
                        v.separador();
                        v.nopost();
                        v.separador();
                    }
                    break;
                case 8:
                    v.separador();
                    v.posts(chat.getPosts("NA",""));//mostrar sin criterio
                    v.separador();
                    break;
                case 9:
                    salir=true;
                    break;
                default:
                    break;
            }
        }

    }
}
