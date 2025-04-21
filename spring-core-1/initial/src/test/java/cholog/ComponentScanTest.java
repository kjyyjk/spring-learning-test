package cholog;

import cholog.scan.ComponentScanBean;
import cholog.scan.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static cholog.utils.ContextUtils.getApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class ComponentScanTest {
    /**
     * https://www.baeldung.com/spring-component-scanning
     */
    /**
     * 만약 그냥 SpringCoreApplication.class를 configuration으로 사용했다면.
     * 해당 패키지와 그 하위 패키지에 있는 것들이 모두 빈으로 등록됐을 것이다.
        * -> 이게 어떻게 가능하냐?
        * SpringCoreApplication에 있는 @SpringBootApplication에는 @ComponentScan과 @Configuration이 모두 포함되어있기 때문.
     * 본 테스트에서는 ContextConfiguration을 기반으로하기 때문에 내가 @ComponentScan을 달아줘야한다.
     */
    @Test
    void scanComponent() {
        ApplicationContext context = getApplicationContext(ContextConfiguration.class);
        ComponentScanBean componentScanBean = context.getBean("componentScanBean", ComponentScanBean.class);
        assertThat(componentScanBean).isNotNull();
    }
}
