package presentation;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        //instancxiation dynamique
        //MetierImpl metier=new MetierImpl();
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        IDao dao=(IDao) cDao.getConstructor().newInstance();
        System.out.println(dao.getData());
        // Metier instanciation
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        //lorsqu'on avait un constructeur sans param
            //IMetier metier=(IMetier) cMetier.getConstructor().newInstance();
        //2eme version constructeur avec param
            IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
        //metier.setDao(new DaoImpl()); //i should call setDao but setDao is not a method of IMetier , its a method of MetierImpl
                                        //so we will call it dynamically , by using the Class Method as so:
        /* //lorsqu'on avait un constructeur sans param , so now no need to get the setter and invoke it
        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class); //this will look up for this method in any implementation of this interface,
                                                                            //another take to take into consideration, multiple methods with the same name , that s why we should precise also the type of the parameters
        setDao.invoke(metier,dao); // invoke the method : setDao() on the object of class : MetierImpl by passing as a parameter the object of class: DaoImpl 1 or 2

        */
        //System.out.println(metier.calcul());
        System.out.println(metier.calcul());
    }
}
