package dao;

import hibernate.HibernateUtil;
import org.hibernate.SessionFactory;

public class UrunTuruDao{

    private SessionFactory sessionFactory;

    public UrunTuruDao(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


}
