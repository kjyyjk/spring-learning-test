package cholog.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
ComponentScan에 대해 학습하고, ComponenetScanBean을 Bean으로 등록하기
 */

/**
 * `@ComponentScan`을 달아주면,
 * 기본적으로 해당 configuration이 위치한 패키지와 그 하위 패키지를 스캔해 스프링 빈을 등록한다.
 */
@ComponentScan
@Configuration
public class ContextConfiguration {
}
