/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * CAW_OrderService     210817    Initial development framework
 * BZ24240              271017    Can we remove JNDI hard coding and add it on Config              
 *== ================================================================
 */

package caw.orderservice.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import caw.orderservice.bean.CawOrderServiceApp;
import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.utils.CawPropertiesConfig;

@Configuration
@ComponentScan("caw.orderservice.*")
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
public class ApplicationContextConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {

        //Begin BZ24240
        String datasource_context = CawPropertiesConfig
                .get(CawPKeyConstant.JNDI_DATASOURCE);
        DataSource dataSource = null;
        try {
            Context initialContext = new InitialContext();
            if (datasource_context != null) {
                dataSource = (DataSource) initialContext
                        .lookup(datasource_context);
            } else {

                dataSource = (DataSource) initialContext
                        .lookup("jdbc/order_service");
            }
            //End BZ24240
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "orderServiceApp")
    public CawOrderServiceApp orderServiceApp() {

        return new CawOrderServiceApp();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer getProperties() {

        return new PropertySourcesPlaceholderConfigurer();
    }
}
