package com.wutian.spring.beverage.context;

import com.wutian.spring.beverage.repository.CustomerRepository;
import com.wutian.spring.beverage.repository.InventoryItemRepository;
import com.wutian.spring.beverage.repository.SalesOrderRepository;
import com.wutian.spring.beverage.service.InventoryService;
import com.wutian.spring.beverage.service.OrderService;
import com.wutian.spring.beverage.service.impl.InventoryServiceImpl;
import com.wutian.spring.beverage.service.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@Import(DataConfig.class)
@PropertySource("classpath:./application.properties")
//@PropertySource("classpath:./application-${spring.profiles.active}.properties")
class AppConfig {

    /**
     * Spring takes system variable first, then classpath variable
     */
    @Value("${greetings.header}")
    private String greetingHeader;
    @Value("${greetings.text}")
    private String greetingText;
    //Read the environment information
    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private static boolean isDev;

    @Bean
    @Scope("prototype")
    public HelloConfig getHelloConfig(){
        return new HelloConfig(this.greetingHeader, this.greetingText);
    }

    // Example of Spring Profile 
    // /**
    //  * The @Bean method must not be private or final
    //  */
    // @Bean
    // @Profile("dev") //Configure environment variable as spring.profiles.active=dev
    // public HelloConfig getHelloConfigDev(){
    //     return new HelloConfig("Hello", this.greetingText);
    // }

    // @Bean
    // @Profile("prod") //Configure environment variable as spring.profiles.active=prod
    // public HelloConfig getHelloConfigProd(){
    //     return new HelloConfig("Greetings", this.greetingText);
    // }
    

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    private CustomerRepository CustomerRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Bean
    public OrderService getOrderService(InventoryService inventoryService, CustomerRepository customerRepository,
            SalesOrderRepository salesOrderRepository) {
        return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
    }

    @Bean
    public InventoryService getInventoryService(InventoryItemRepository inventoryItemRepository) {
        return new InventoryServiceImpl(inventoryItemRepository);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloConfig helloConfig = (HelloConfig)context.getBean(HelloConfig.class);
        helloConfig.greeting();
        HelloConfig helloConfig2 = (HelloConfig)context.getBean(HelloConfig.class);
        helloConfig2.greeting();
        // System.out.println(isDev);

        OrderService orderService = (OrderService) context.getBean(OrderService.class);
        System.out.println(orderService == null ? "Iniation Failed!" : "Done!");
        ((AbstractApplicationContext) context).close();
    }
}