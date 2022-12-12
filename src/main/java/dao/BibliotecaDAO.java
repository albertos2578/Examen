package dao;

import java.util.HashSet;
import java.util.List;
import models.Libro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class BibliotecaDAO {
    
    
        private static final SessionFactory sessionFactory;
    
  

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static{
        try{

            sessionFactory = new Configuration().configure().buildSessionFactory();
            
            System.out.println("Conexión  realizada");
        }catch(Exception ex){
            System.out.println("Error iniciando Hibernate");
            System.out.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public void saveLibro( Libro e ){
        
        /* Guarda un libro con todos sus ejemplares en la base de datos */
        
       try(var s = sessionFactory.openSession()){
            Transaction t = s.beginTransaction();
            s.save(e);
            t.commit();
            s.close();
    }
    }
  
    public HashSet<Libro> findByEstado(String estado){
        
        HashSet<Libro> salida = new HashSet<Libro>();
           Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            
         String hql = "FROM Ejemplar where estado=:estado";
         Query query = s.createQuery(hql);
         query.setParameter("estado", estado);
        
        List list = s.createQuery("FROM Ejemplar").list();
    
         s.close();
      
         
        /* 
         Devuelve el conjunto de libros que tenga el estado indicado      
        */
        
        
        return salida;
        
    }
    
    public void printInfo(){
        
        /* 
          Muestra por consola todos los libros de la biblioteca y el número
          de ejemplares disponibles de cada uno.
          
          Debe imprimirlo de esta manera:
        
          Biblioteca
          ----------
          Como aprender java en 24h. (3)
          Como ser buena persona (1)
          Aprobando exámenes fácilmente (5)
          ...
        
        */
        System.out.println("Método printInfo no implementado");
        
    }
    
}
