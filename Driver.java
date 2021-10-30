public class Driver {
    public static void main(String[] args) {
        QueOndaMano chat = new QueOndaMano();
        Vista v = new Vista();
        boolean salir=false;
        v.bienvenida();
        while(!salir){
            int r=0;
            while (r!=1&&r!=2&&r!=3&&r!=4&&r!=5&&r!=6&&r!=7&&r!=8){
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
                            chat.newPost_txt(texto, hash, nombre);
                            break;
                        case 2://multimedia
                            String link="";
                            while(link==""||!link.contains("https")||link.contains(" ")){//escribir url
                                link=v.ingreso_link();
                                if(!link.contains("https")||link.contains(" ")){
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
                                r3=v.menu_multimedia();
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
                                    String caract = "Formato: "+format+" Resolucion: "+res+" Tamaño: "+size+"kB";
                                    chat.newPost_multimd(link, hash, nombre, caract, "Imagen");
                                    break;
                                case 2://video
                                    String fps="";
                                    while(fps==""){//escribir fps
                                        format=v.ingreso_fps();
                                    }
                                    String caract2 = "Framerate: "+fps+" Tamaño: "+size+"kB";
                                    chat.newPost_multimd(link, hash, nombre, caract2, "Video");
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
                                    String caract3 = "SampleRate: "+samplerate+"kHz"+" BitDepth: "+bit+" Tamaño: "+size+"kB";
                                    chat.newPost_multimd(link, hash, nombre, caract3, "Audio");
                                    break;
                                case 4://salir                                    
                                    break;
                                default:
                                    break;
                            }
                            
                            break;
                        case 3://emoticones
                            int r4=-1;
                            while(r4<0||r4>chat.getNemotes()-1){
                                r4=v.emotes(chat.getEmotes());
                            }
                            chat.newPost_emote(r4, hash, nombre);
                            break;
                        case 4: //salir
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    v.separador();
                    v.posts(chat.getPosts());
                    v.separador();
                    break;
                case 8:
                    salir=true;
                    break;
                default:
                    break;
            }
        }

    }
}
