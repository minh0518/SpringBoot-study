package hello.springpart2.beanfind;

import hello.springpart2.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

//    @Test
//    @DisplayName("모든 빈 출력하기")
//    public void findAllBean(){
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//                            //스프링에 등록된 모든 빈 이름을 조회합니다
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = ac.getBean(beanDefinitionName);
//            //어느 객체 타입이 들어있는지 모르기 때문에
//            // 모든 것을 받기 위해 Object형으로 받아줍니다
//
//            System.out.println("name = " + beanDefinitionName + "  object =" + bean);
//        }
//
//        }

        @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
                                            //인자로 받은 빈에 대한 정보들을 리턴

            //ROLE_APPLICATION옵션은 스프링 자체적으로 사용되는 빈이 아니라
            //내가 직접 개발하면서 만든 빈들 or 외부 라이브러리들을 의미합니다
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "  object =" + bean);
            }
        }

        }

}
