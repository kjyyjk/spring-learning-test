package cholog.di;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjection {
    private InjectionBean injectionBean;
    private String name;

    /*
    ConstructorInjection으로 InjectionBean 주입받기
     */

    // 생략 가능
//    @Autowired
    public ConstructorInjection(InjectionBean injectionBean) {
        this.injectionBean = injectionBean;
    }

    public String sayHello() {
        return injectionBean.hello();
    }
}
