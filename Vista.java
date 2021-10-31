/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Vista.java
Lenguaje: Java
Creación: 29/10/2021
Modificacion: 30/10/2021
*/
import java.util.Scanner;

public class Vista {
    Scanner sc = new Scanner(System.in);
    public Vista(){

    }

    public void bienvenida(){//bienvenida
        System.out.println("Bienvenido a Que Onda Mano!");
    }
    
    /** 
     * @return int
     */
    public int menu (){//menu principal
        try{ 
            System.out.println("1. Hacer un post");
            System.out.println("2. Hacer un comentario");
            System.out.println("3. Dar like");
            System.out.println("4. Buscar un hashtag");
            System.out.println("5. Buscar una fecha");
            System.out.println("6. Buscar una hora");
            System.out.println("7. Reproducir");
            System.out.println("8. Mostrar todo");
            System.out.println("9. Salir");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @return int
     */
    public int menu_post (){//menu de tipo de post
        try{ 
            System.out.println("Ingrese el tipo de post");
            System.out.println("1. Texto");
            System.out.println("2. Multimedia");
            System.out.println("3. Emoticon");
            System.out.println("4. Salir");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @return int
     */
    public int menu_multimedia (){//menu de tipo de multimedia
        try{ 
            System.out.println("Ingrese el tipo de multimedia:");
            System.out.println("1. Imagen");
            System.out.println("2. Video");
            System.out.println("3. Audio");
            System.out.println("4. Salir");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @param emotes
     * @return int
     */
    public int emotes (String emotes){//menu de emotes
        try{ 
            System.out.println("Ingrese el emote que quiere publicar:");
            System.out.println(emotes);
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return -1;
        }
    }
    
    /** 
     * @return int
     */
    public int select_post (){ // sellecion del numero de post
        try{ 
            System.out.println("Ingrese numero del post: ");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return -1;
        }
    }
    
    /** 
     * @return String
     */
    public String ingreso_nombre(){//ingreo del nombre
        try{
            System.out.println("Ingrese su nombre: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_hash(){//ingreso del hashtag
        try{
            System.out.println("Ingrese sus hashtags iniciando con \"#\": ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_texto(){//ingreso del texto
        try{
            System.out.println("Ingrese el texto: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_link(){//ingreso del link
        try{
            System.out.println("Ingrese el URL: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_size(){//ingreso del tamaño
        try{
            System.out.println("Ingrese el tamaño del archivo en kB: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_format(){//ingreso del formato
        try{
            System.out.println("Ingrese el formato del archivo: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_resol(){//ingreso de la resolucion
        try{
            System.out.println("Ingrese la resolución de la imagen en megapixeles: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_fps(){//ingreso de frames
        try{
            System.out.println("Ingrese el FrameRate del video: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_sample(){//ingreso de sample
        try{
            System.out.println("Ingrese el SampleRate del audio en kHz: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_bit(){//ingreso de bitdepth
        try{
            System.out.println("Ingrese el BitDepth del audio: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }  
    }
    
    /** 
     * @return String
     */
    public String ingreso_coment(){//ingreso del comentario
        try{
            System.out.println("Ingrese su comentario: ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_fecha(){//ingreso de fecha
        try{
            System.out.println("Ingrese la fecha (dd/mm/yyyy): ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    
    /** 
     * @return String
     */
    public String ingreso_hora(){//ingreso de hora
        try{
            System.out.println("Ingrese la hora en formato de 24 horas (hh:mm): ");
            return sc.nextLine();
        }catch(Exception e){
            return "";
        }
        
    }
    public void posts(String posts){//mostrar posts
        System.out.println(posts);
    }
    
    public void separador(){//separador
        System.out.println("\n************************************************************\n");
    }
    

    public void chars(){//
        System.out.println("El texto sobrepasa los 20 caracteres");//mensaje de exceso de caracteres
    }
    public void link(){
        System.out.println("Ingrese unicamente URL's validos");//mensaje de url no valido
    }
    public void comentario(){
        System.out.println("Comentario publicado");//mensaje de exito al comentar
    }
    public void post(){
        System.out.println("Se ha publicado el post");//mensaje de exito al publicar
    }
    public void like(){
        System.out.println("Se ha agregado su like");//mensaje de exito al dar like
    }
    public void nopost(){
        System.out.println("No hay posts disponibles al momento");//mensaje de no posts disponibles
    }
}
