package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    //@Autowired //v=en l'utilisant , on viole le principe de l'encapsulation , parcequ'il injecte directement la valeur en accedant à la variable et ne passe pas via un setter
              //instead we should pass the value either by setter or contructor(recomended) et on a plus besoin à cette annotation
    private IDao dao; //couplage faible : cette classe dépend d'une interface et non pas d'une classe
                      //cette classe peut fonctionner avec n'importe quelle classe qu'implémente cette interface
                      //au cas d'un changement cette classe n'aura aucune modification

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data=dao.getData();
        double result=data*10;
        return result;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) { //permet d'injecter dans la variable dao un objet(instance d'une classe qu'implémente l'interface IDao) de type IDao
        this.dao = dao;
    }
}
