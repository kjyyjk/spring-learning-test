package cholog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    /**
     * /hello 경로의 서블릿 요청이 들어오면 해당 메서드로 매핑한다.
     * 그리고 @RequestParam으로 서블릿 요청 파라미터(쿼리 스트링)를 메서드의 파라미터로 바인딩한다.
     * Model을 활용해 주입 받은 값을 View로 전달한다.
     * return "hello" -> templates/hello.html
     */
    @GetMapping("/hello")
    public String world(@RequestParam(name = "name") String name, Model model) {
        // TODO: /hello 요청 시 resources/templates/static.html 페이지가 응답할 수 있도록 설정하세요.
        // TODO: 쿼리 파라미터로 name 요청이 들어왔을 때 해당 값을 hello.html에서 사용할 수 있도록 하세요.
        model.addAttribute("name", name);
        return "hello";
    }

    /**
     * @ResponseBody 애너테이션을 사용하면
     * 반환값을 HttpMessageConverter로 역직렬화한 뒤 response-body에 담아 반환할 수 있다.
     */
    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.
        return new Person("brown", 20);
    }
}
