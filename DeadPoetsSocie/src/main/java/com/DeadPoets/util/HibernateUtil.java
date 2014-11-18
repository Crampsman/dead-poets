package com.DeadPoets.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;


@Component
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null; 
     
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
                //creates the session factory from hibernate.cfg.xml
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
              e.printStackTrace();
        }
        
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
