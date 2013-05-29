/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import business.bread;
import java.io.File;

/**
 *
 * @author sistemas
 */
public class Main {
   
    
    public static void main(String args[]){
        
        //File f = new File("./nuevo.xls");
        
        //System.err.println(f.getAbsolutePath());
        //bread ob = new business.bread();
        //ob.nrorow();
        //ob.listadet();
        reader o = new reader();
        o.guardarCantidad();
    }
    
}
