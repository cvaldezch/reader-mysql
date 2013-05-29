/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

/**
 *
 * @author sistemas
 */
import business.bread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Sheet;
//import jxl.write.Number;
import jxl.Workbook;
import jxl.write.*;

public class reader {
    
    public void Escribirxls(){
        try {
            WritableWorkbook libro = Workbook.createWorkbook(new File("./lista.xls"));
            WritableSheet hoja = libro.createSheet("Lista", 0);
            //Label label = new Label(label)
            bread ob = new bread();
            List<bread> lista = ob.listadet();
            Label matid = null, fec = null , cant = null;
            for (int i = 0; i < lista.size(); i++) {
                matid = new Label(1, i, lista.get(i).getMatid());
                fec = new Label(2, i, lista.get(i).getFecha().toString());
                cant = new Label(3, i, lista.get(i).getCantidad().toString());
                hoja.addCell(matid);
                hoja.addCell(fec);
                hoja.addCell(cant);
            }
            libro.write();
            libro.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /*public void ingresos(){
        try {
            File fi = new File(".//ingresos.xls");
            Workbook libro = Workbook.getWorkbook(fi);
            WritableWorkbook copy = Workbook.createWorkbook(fi, libro);
            //Sheet hoja = libro.getSheet(0);
            WritableSheet sheet = copy.getSheet(0);
            sheet.insertRow(1);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
    
    public void guardarCantidad(){
        try {
            File f;
            File fd = new File(".//modelo.xls");
            //JOptionPane.showMessageDialog(null, fd.getAbsolutePath());
            bread r = new bread();
            List<bread> listid = r.listaid();
            for (int i = 0; i < listid.size(); i++) {
                listid.get(i).getMatid();
                f = new File(".//document//"+listid.get(i).getMatid()+".xls");
                Copiar(fd, f);
                if (f.exists()) {
                    escribirCantidad(f, listid.get(i).getMatid().trim());
                }else{
                    Copiar(fd, f);
                    escribirCantidad(f, listid.get(i).getMatid().trim());
                }
                //if (i == 10) {
                //    break;
                //}
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void escribirCantidad(File filename,String id){
        try {
            // Creando nuevo libro eb memoria
             Workbook workbook = Workbook.getWorkbook(filename);
             WritableWorkbook copy = Workbook.createWorkbook(filename, workbook);
            
             WritableSheet sheet2 = copy.getSheet(0);
             // Agragando Codigo y Nombre del Material
             bread in = new bread();
             List<bread> listn = in.id_nombre(id);
             for (int i = 0; i < listn.size(); i++) {
                Label lid = new Label(2, 6, listn.get(i).getMatid());
                Label lnom = new Label(4,6, listn.get(i).getNombre());
                sheet2.addCell(lid);
                sheet2.addCell(lnom);
            }//fin de for
             
            // Agregando fecha y cantidad del articulo
                        
             in = new  bread();
             List<bread> listac = in.listaiddetallada(id);
             for (int i = 0; i < listac.size(); i++) {
                Label lfec = new Label(0,17+i,listac.get(i).getFecha().toString());
                sheet2.addCell(lfec);
                Label lcant = new Label(8,17+i, listac.get(i).getCantidad().toString());
                sheet2.addCell(lcant);
            }
             //Escribiendo la hoja
            copy.write();
            //Cerrando el archivo
            copy.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void Copiar(File dirOrigen, File dirDestino) throws Exception { 
 
	InputStream in = new FileInputStream(dirOrigen); 
	OutputStream out = new FileOutputStream(dirDestino); 
 
	byte[] buffer = new byte[1024];
	int len;
 
	try {
		// recorrer el array de bytes y recomponerlo
		while ((len = in.read(buffer)) > 0) { 
			out.write(buffer, 0, len); 
		} // end while
		out.flush();
	} catch (Exception e) {
		throw e;
	} finally {
		in.close(); 
		out.close(); 
	} // end ty
} // end Copiar
    
}
