**原生使用hibernate：**
>>>>0.添加依赖<br>
>>>>1.建立model<br>
>>>>2.建立映射文件<br>
>>>>3.建立hibernate核心配置文件<br>
>>>>4.编辑dao实现类<br>
>>>>5.测试<br>

**Spring整合Hibernate有什么好处？**<br>
>>>>1、由IOC容器来管理Hibernate的SessionFactory<br>
>>>>2、让Hibernate使用上Spring的声明式事务

**Hibernate在Springboot中的使用：**<br>
>>>>1、Spring-data-jpa默认使用Hibernate作为jpa的实现，因此需要引入spring-boot-starter-data-jpa，这个starter引入jpa开发需要的所有jar包，再加上spring-boot-starter-parent引入的核心jar包，极大简化了pom.xml的配置，不需要开发者去引入众多的jar包。<br>
>>>>2、因为使用jpa，对象关系映射.xml被@Table @Column这样的注解替代；原来hibernate.cfg.xml的配置由application.yml接管（如MySQL5InnoDBDialect的配置）；applicationContext.xml的部分配置由application.yml接管（如数据源的配置），还有大部分配置被设置成默认约定而被省略。<br>
>>>>3、不能逆向生成表，而上面两种都可以（不知是否是缺少某些设置的原因）<br>
>[参考链接](https://www.xncoding.com/2017/07/03/spring/sb-hibernate.html)
