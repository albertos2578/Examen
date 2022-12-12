package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

public class UsuarioDAO {
    
    private Connection connection;
    
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/examen?zeroDateTimeBehavior=CONVERT_TO_NULL";
    /* Completar consultas */
    static final String INSERT_QUERY ="INSERT INTO `usuario` ( `nombre`, `apellidos`, `dni`) VALUES ( ?, ?, ?);";
    static final String LIST_QUERY="SELECT * FROM `usuario`";
    static final String GET_BY_DNI="select * FROM `usuario` WHERE dni=(?)";
    
    
    public void connect(){
        try {
            
            /* completar código de conexión */
             
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Logger.getLogger(UsuarioDAO.class.getName()).info("Conexión establecida con exito");
        } catch (SQLException ex) {
             System.out.println("Error al conectar a la base de datos");
            System.out.println("ex");
        }
           
    }
    
    
    public void close(){
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println("Error al cerrar la base de datos");     
        }
    }
    
    public void save(Usuario user){
         try(var pst =  connection.prepareStatement(INSERT_QUERY)){
           
             pst.setString(1, user.getNombre());
              pst.setString(2, user.getApellidos());
              pst.setString(3, user.getDni());
               pst.executeUpdate();
                pst.close();
               
          } catch (SQLException ex) {
              Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        /**
         * Completar código para guardar un usuario 
         * Este método no debe generar el id del usuario, ya que la base
         * de datos es la que lo genera.
         * Una vez obtenido el id del usuario tras la consulta sql,
         * hay que modificarlo en el objeto que se pasa como parámetro 
         * de forma que pase a tener el id correcto.
         */


 
    }
    
   
       
    

    public ArrayList<Usuario> list(){
 
        var salida = new ArrayList<Usuario>();
        try(var pst=connection.prepareStatement(LIST_QUERY)){
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                  var  pedido = new Usuario();
            pedido.setId(resultado.getLong("id"));
            pedido.setApellidos(resultado.getString("apellidos"));
            pedido.setNombre(resultado.getString("nombre"));
            pedido.setDni(resultado.getString("dni"));
          
               salida.add(pedido);
                
            }
        } catch (SQLException ex) {
              Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
     return salida;
    }
    
    
    public Usuario getByDNI(String dni){
        
        Usuario salida = new Usuario();
        
		     
		   try(var pst=connection.prepareStatement(GET_BY_DNI)){
                         pst.setString(1, dni);
	            ResultSet resultado = pst.executeQuery();
                     
                       
	            while(resultado.next()){
	            
	            salida.setId(resultado.getLong("id"));
	            salida.setNombre(resultado.getString("nombre"));
	            salida.setApellidos(resultado.getString("apellidos"));
	            salida.setDni(resultado.getString("dni"));
	               
	                
	            }
	        } catch (SQLException ex) {
	              Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	          }
	    

        return salida;
    }    
}
