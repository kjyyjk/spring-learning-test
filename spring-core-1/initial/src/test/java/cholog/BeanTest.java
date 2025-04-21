package cholog;

import cholog.bean.AutowiredBean;
import cholog.bean.SpringBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static cholog.utils.ContextUtils.getApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class BeanTest {
    /**
     * -> NoSuchBeanDefinitionException이 발생
     * `spring Bean`이라는 이름을 가진 스프링 빈을 등록해줘야한다.
     * SpringBean 클래스에 @Component를 달아준다.
        * -> 나는 @Component를 달아줬을 뿐인데 통과한다. 스프링 빈의 이름은 무슨 기준인거지?
        * 추측하건데 클래스명을 따를 것이다.
        * 따로 지정하지 않는 경우 클래스 명의 카멜 케이스를 따르는 것 같다.
        * https://docs.spring.io/spring-framework/reference/core/beans/definition.html#page-title
     */
    @Test
    void registerBean() {
        ApplicationContext context = getApplicationContext();
        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        assertThat(springBean).isNotNull();
    }

    /**
     * https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired.html
     */
    @Test
    void autowiredBean() {
        ApplicationContext context = getApplicationContext();
        AutowiredBean autowiredBean = context.getBean("autowiredBean", AutowiredBean.class);
        assertThat(autowiredBean.sayHello()).isEqualTo("Hello");
    }
}
