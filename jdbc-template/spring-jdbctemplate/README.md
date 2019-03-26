#### 方式1:

UserDAO1通过@Autowired注解维护JdbcTemplate的引用，通过@Repository发布自己，以便其他类可以通过dao1=context.getBean(UserDAO1.class)得到

#### 方式2:

UserDAO2通过继承JdbcDaoSupport得到JdbcTemplate的引用，因此，appliactionContext.xml中必须定义UserDAO2的bean，
其他类通过dao2=(IUserDAO)context.getBean("userDao2")得到，因此这种方式不要开启spring注解扫描
