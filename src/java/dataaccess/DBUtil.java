package dataaccess;

import java.sql.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static final EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("Lab9_StartingPointPU");
    
    public static EntityManagerFactory getEntityFactory(){
        return DBUtil.entityFactory;
    }
}