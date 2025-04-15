package cholog;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * ResponseJsonTest#responseJson 에서의 역직렬화를 위해서는
     * 기본 생성자가 필요하기 때문에 추가했다.
     */
    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
