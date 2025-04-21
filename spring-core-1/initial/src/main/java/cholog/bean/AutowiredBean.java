package cholog.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBean {
    /*
    어떤 방법으로 Component에 Bean을 주입하는지 학습하기
     */
    private SpringBean springBean;

    /**
     * 생성자가 하나만 있는 경우에는 @Autowired를 생략할 수 있다.
     */
    @Autowired
    public AutowiredBean(SpringBean springBean) {
        this.springBean = springBean;
    }

    public String sayHello() {
        return springBean.hello();
    }
}
