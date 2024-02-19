package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class presentation1 {
    public static void main(String[] args) {
        //1ere version we had no constructor
        /*
        MetierImpl metier=new MetierImpl();//instanciation statique=couplage fort
        metier.setDao(new DaoImpl());//injection des dependances
         */
        //2eme version we have now a constructor with params
        MetierImpl metier=new MetierImpl(new DaoImpl());//instanciation statique=couplage fort
        System.out.println(metier.calcul());
    }
}
