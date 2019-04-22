package com.web.spittr.config.security;

import com.web.spittr.data.SpittleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
@EnableWebMvcSecurity
//@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 在第一个查询中，我们获取了用户的用户名、密码以及是否启用的信息，这些信息会用来进行用户认证。
     * 接下来的查询查找了用户所授予的权限，用来进行鉴权，
     * 最后一个查询中，查找了用户作为群组的成员所授予的权限
     */
    public static final String DEF_USERS_BY_USERNAME_QUERY = "select username, password, enabled from users where username = ?";
    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select username, authority from authorities where username = ?";
    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY = "select g.id, g.group_name, ga.authority " +
            "from group g, group_members gm, group_authorities ga " +
            "where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id";

    @Autowired
    DataSource dataSource;

    @Autowired
    SpittleRepository spittleRepository;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        System.out.println(" 加载Security  HttpSecurity---------------------");
        log.debug("加载Security。。。 http");
        // 启用默认的登录页
        httpSecurity
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/spittle/")
                .failureUrl("/spittle/login?error=true")
                //.and()
                //    .logout()
                //    .logoutSuccessUrl("/login")
                //    .logoutUrl("/signout")
                //.and()
                //.rememberMe()
                //.tokenValiditySeconds(2439800)
                //.key("spittrKey")
                //.and()
                //.httpBasic()
                //.realmName("Spittr")
                //.and()
                //    .authorizeRequests()
                //    .antMatchers("/spittle/me").hasRole("USER")
                //    .anyRequest()
                //    .permitAll()
                //.and()
                //    .requiresChannel()
                //    .antMatchers("/spittle/from")
                //    .requiresSecure()

        ;

        httpSecurity.csrf().disable();

        // 需要HTTPS
        //httpSecurity.authorizeRequests()
        //        .antMatchers("/spitter/me").hasRole("SPITTER")
        //        .antMatchers(HttpMethod.POST, "/spitter/me").hasRole("SPITTER")
        //        .anyRequest().permitAll()
        //        .and()
        //        .requiresChannel()
        //        .antMatchers("/spitter/from")
        //        .requiresSecure();

        //httpSecurity.authorizeRequests()
        //        .antMatchers("/spitters/me")
        //        .authenticated()
        //        .antMatchers(HttpMethod.POST, "/spittles")
        //        .authenticated()
        //        .anyRequest()
        //        .permitAll();
        //.antMatchers("/spitter/**","/spitters/mine").authenticated()

    }
    /**
     *  LDAP简单查询
     * @param auth
     * @throws Exception
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启用内存用户储存
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("(member={0})")
                .contextSource().root("dc=habuma,dc=com").ldif("classpath:users.ldif")
                //.passwordCompare()
                //.passwordEncoder(new MD5())
                //.passwordAttribute("passcode")
                ;
       // auth.userDetailsService(new SpitterUserDetailService());
    }*/

    /**
     *  使用jdbc进行访问
     *   只重写了认证和基本权限的查询语句
     * @param auth
     * @throws Exception
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启用内存用户储存
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from Spitter where username = ?")
                .authoritiesByUsernameQuery("selcet username, 'ROLE_USER' from Spitter where username= ?")
              //  .passwordEncoder(new StandardPasswordEncoder("33"))
        ;
    }*/

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("加载Security。。。读取权限");
        // 启用内存用户储存
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("1").roles("USER").and()
                .withUser("admin").password("1").roles("USER","ADMIN");
    }

    /*protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }*/


/*    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 配置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 第一次启动的时候自动建表（可以不用这句话，自己手动建表，源码中有语句的）
//         jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }*/



}
