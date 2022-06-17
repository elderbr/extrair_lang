package intefarces;

/**
 *
 * @author User
 */
public interface Querys {
    long insert(Dados obj);
    Object select(Dados obj);
    long delete(Dados obj);
    long update(Dados obj);
}
