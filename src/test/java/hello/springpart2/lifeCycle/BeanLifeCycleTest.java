package hello.springpart2.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        //ApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //
        NetworkClient client = ac.getBean(NetworkClient.class);

        ac.close();
        //직접 에플리케이션을 close할 필요가 거의 없기 때문에
        //기본적으로 제공하지 않고 이를 상속받는 구체적이 하위클래스에서 따로 사용
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return  networkClient;
        }

    }
}
