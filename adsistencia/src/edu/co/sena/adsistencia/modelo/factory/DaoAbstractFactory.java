/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.factory;



/**
 *
 * @author users
 */
public abstract class DaoAbstractFactory implements DaoFactory{
 public static final int MYSQL_FACTORY = 1;
    

    public static DaoAbstractFactory getDAOFactory(int factoryType) {
        switch (factoryType) {
           
            case MYSQL_FACTORY:
                return new MysqlDaoFactory();

            default:
                System.out.println("no funciona la base de datos");
                return null;

        }
    }
    
    
    
}
