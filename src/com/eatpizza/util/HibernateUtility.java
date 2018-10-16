package com.eatpizza.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
public static SessionFactory sf;
    
	private HibernateUtility() {	
	}
	
    public static synchronized SessionFactory getSessionFactory() {
 
    	// implementación del patrón Singleton, para que no haya más que una 
    	// instancia de la factoria de sesiones.
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }

}
