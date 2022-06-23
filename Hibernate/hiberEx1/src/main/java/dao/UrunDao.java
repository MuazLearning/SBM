package dao;

import hibernate.HibernateUtil;
import org.hibernate.SessionFactory;

public class UrunDao {

    SessionFactory sessionFactory;

    public UrunDao(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
}
