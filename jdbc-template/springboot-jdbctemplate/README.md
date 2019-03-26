简化了原生spring的配置，例如springboot可以省略jdbcTemplate的bean配置

<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"/>
</bean>

如何springboot想配置自己的bean可以在类前面加上如下注解：

@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "xxx")  // 配置文件中的前缀
