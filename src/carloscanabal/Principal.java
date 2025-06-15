package carloscanabal;

import Vistas.Gui.VentanaPrincipal;


/**
 *
 * @author lm-carlos
 */
public class Principal {
    
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Prueba base de datos");
        
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        
        
        
    }

}
