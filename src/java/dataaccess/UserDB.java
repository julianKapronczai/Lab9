
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;


public class UserDB {
    
    public List<User> getAll() throws Exception {
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        try{
            List<User> RoleList = entityManager.createNamedQuery("User.findAll", User.class).getResultList();
            return RoleList;
        }finally{
            entityManager.close();
        }
    }
    public User get(String index) throws Exception
    {
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        
        try{
            User role = entityManager.find(User.class, index);
            return role;
            
        }finally{
            entityManager.close();
        }
        
    }
    public void update(User inputRole)throws Exception{
        
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
    public void insert(User inputRole)throws Exception{
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        try{
            Role role = inputRole.getRole();
            role.getUserList().add(inputRole);
            entityTransaction.begin();
            entityManager.persist(inputRole);
            entityManager.merge(role);
            entityTransaction.commit();
            
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    }
    public void delete(User inputRole)throws Exception{
        
        EntityManager entityManager = DBUtil.getEntityFactory().createEntityManager();
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        try{
            User confirmedUser = entityManager.merge(this.get(inputRole.getEmail()));
            Role user = inputRole.getRole();
            user.getUserList().remove(inputRole);
            entityTransaction.begin();
            entityManager.remove(confirmedUser);
            entityManager.merge(user);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    }
}
