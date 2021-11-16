package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;

public class RoleDB {
    
    public List<Role> getAll() throws Exception {
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        try{
            List<Role> RoleList = entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
            return RoleList;
        }finally{
            entityManager.close();
        }
    }
    
    public Role get(int index) throws Exception
    {
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        
        try{
            Role role = entityManager.find(Role.class, index);
            return role;
            
        }finally{
            entityManager.close();
        }
        
    }
    public void update(Role inputRole)throws Exception{
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        try{
            entityTransaction.begin();
            entityManager.merge(inputRole);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    
    
    
    }
    public void insert(Role inputRole)throws Exception{
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        try{
            entityTransaction.begin();
            entityManager.persist(inputRole);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    
    
    
    }
    public void delete(Role inputRole)throws Exception{
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        try{
            entityTransaction.begin();
            entityManager.remove(inputRole);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    }
}
