package Main;



import Controllers.AppController;

public class StreamDeck {
    
    //public static EventBus comunicacion = new EventBus();
 
    public static void main(String[] args) {
        
        AppController ac = new AppController();
        ac.iniciar();
        
    }
}
