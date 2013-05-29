/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sistemas
 */
public class bread {
    
    private String matid;
    private Date fecha;
    private Double cantidad;
    private String nombre;
    
    public List<bread> listadet(){
    List lista = new ArrayList();
        try {
            ResultSet rs;
            rs = new data.MySQLHelper().ExecuteDataSet("SELECT id_articulo,cant,fch_doc FROM dbicrperusa.guiaventai WHERE cast(fch_doc as char(10)) between \"2012-09-01\" AND \"2013-01-01\" " +
                                                        "ORDER BY fch_doc ASC;");
            bread obj;
            while (rs.next()) {                
                //obj = new bread();
                //obj.setMatid(matid);
                //System.out.println(""+rs.getString(1).trim()+" "+rs.getDate(3)+" -- "+rs.getDouble(2));
                obj = new bread();
                obj.setMatid(rs.getString(1));
                obj.setFecha(rs.getDate(3));
                obj.setCantidad(rs.getDouble(2));
                lista.add(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    public List<bread> listaid(){
        List lista = new ArrayList();
        try {
            ResultSet rs;
            rs = new data.MySQLHelper().ExecuteDataSet("SELECT DISTINCT id_articulo FROM dbicrperusa.guiaventai \n" +
                                                                                    "WHERE cast(fch_doc as char(10)) between \"2012-09-01\" AND \"2013-01-01\"\n" +
                                                                                    "ORDER BY fch_doc ASC;");
            bread ob;
            while (rs.next()) {                
                ob = new bread();
                ob.setMatid(rs.getString("id_articulo").trim());
                lista.add(ob);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    public List<bread> id_nombre(String id){
    List lista = new ArrayList();
        try {
            ResultSet rs;
            rs =  new data.MySQLHelper().ExecuteDataSet("SELECT DISTINCT g.id_articulo,a.nombre\n" +
                                                                                    "FROM dbicrperusa.guiaventai g INNER JOIN dbicrperusa.articulos a\n" +
                                                                                    "ON g.id_articulo LIKE a.id_articulo\n" +
                                                                                    "WHERE TRIM(g.id_articulo) LIKE "+'"'+id+'"'+" AND cast(g.fch_doc as char(10)) between \"2012-09-01\" AND \"2013-01-01\"\n" +
                                                                                    "ORDER BY g.fch_doc ASC");
            bread ob;
            while (rs.next()) {                
                ob = new bread();
                ob.setMatid(rs.getString("id_articulo").trim());
                ob.setNombre(rs.getString("nombre"));
                lista.add(ob);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return lista;
    }
    
    public List<bread> listaiddetallada(String id){
        List lista = new ArrayList();
        try {
            ResultSet rs;
            rs =  new data.MySQLHelper().ExecuteDataSet("SELECT id_articulo,cant,fch_doc FROM dbicrperusa.guiaventai \n" +
                                                                                    "WHERE TRIM(id_articulo) LIKE "+'"'+id+'"'+" AND cast(fch_doc as char(10)) between \"2012-09-01\" AND \"2013-01-01\"\n" +
                                                                                    "ORDER BY fch_doc ASC;");
            bread ob;
            while (rs.next()) {                
                ob = new bread();
                ob.setFecha(rs.getDate("fch_doc"));
                ob.setCantidad(rs.getDouble("cant"));
                lista.add(ob);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    public Double nrorow(){
        Double nro = null;
            try {
            ResultSet rs;
            rs = new data.MySQLHelper().ExecuteDataSet("SELECT count(*) FROM guiaventai");
            while(rs.next()){
                nro = rs.getDouble(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            System.err.println(nro);
        return nro;
    }

    /**
     * @return the matid
     */
    public String getMatid() {
        return matid;
    }

    /**
     * @param matid the matid to set
     */
    public void setMatid(String matid) {
        this.matid = matid;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
