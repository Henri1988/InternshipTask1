//@Component
//public class JpaGroupDao extends dao.GenericDaoJpaImpl<Group> implements GroupDao {
//
//
//    static AnnotationConfigApplicationContext context =
//            new AnnotationConfigApplicationContext(Main.class);
//    static EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
//    static EntityManager em = emf.createEntityManager();
//
//    public JpaGroupDao(Class<Group> persistentClass) {
//        super(persistentClass);
//    }
//
//
//    @Override
//    public Group save(Group group) {
//        em.getTransaction().begin();
//        em.persist(group);
//        em.getTransaction().commit();
//        return group;
//    }
//
//    @Override
//    public Group update(Group entity) {
//        return null;
//    }
//    @Override
//    public void delete(Group entity) {
//    }
//
//    @Override
//    public void find(int id) {
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//}
