package cholog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class UpdatingDAO {
    private JdbcTemplate jdbcTemplate;

    public UpdatingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    private final RowMapper<Customer> actorRowMapper = (resultSet, rowNum) -> {
        Customer customer = new Customer(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name")
        );
        return customer;
    };
    추후 rowMapper에 대해 학습해보고 이용해보기
    */

    /**
     * public int update(String sql, @Nullable Object... args)
     *
     * JdbcTemplates#update()를 사용해 db에 데이터를 삽입할 수 있다.
     *
     * excute와의 차이점은 무엇일까?
     * 정확한 차이까지는 알아보지 못했으나 공식문서에서 excute는 주로 DDL을 실행할 때 사용한다고 한다.
     */
    public void insert(Customer customer) {
        //todo: customer를 디비에 저장하기
        String sql = "insert into customers(first_name, last_name) values(?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName());
    }
    /**
     * public int update(String sql, @Nullable Object... args)
     *
     * update의 반환 값은 해당 쿼리로 영향을 받은 row의 개수다.
     */
    public int delete(Long id) {
        //todo: id에 해당하는 customer를 지우고, 해당 쿼리에 영향받는 row 수반환하기
        String sql = "delete from customers where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * public int update(final PreparedStatementCreator psc, final KeyHolder generatedKeyHolder)
     *
     * KeyHolder는 db에서 자동으로 생성된 key들을 불러와 가지는 인터페이스로, 주로 insert문을 실행할때 사용된다.
     * 한 개 로우의 키를 Map으로 보관하며, 전체 로우에 대한 키들을 List로 보관한다.
     * List<Map<String, Object>>형식. GeneratedKeyHolder.class 참고
     *
     * getKey()는 getKeyAs(Number.class)와 같다.
     * 
     * getKeyAs()는 주어진 타입으로 key를 가져온다.
     * 이때 row는 1개이며 하나의 key 값만 가진다는 것을 전제로한다.
     * 즉 List의 사이즈는 1이며, Map의 사이즈도 1이어야한다.
     * 아니면 예외를 발생한다.
     *
     * getKeys()는 하나의 row의 키들을 Map으로 반환한다.
     * 만약 List의 사이즈가 1을 초과하면 예외를 발생한다.
     *
     * getKeyList()는 생성된 모든 key 값들을 List<Map<String, Object>> 형태로 받아올 수 있다.
     */
    public Long insertWithKeyHolder(Customer customer) {
        String sql = "insert into customers (first_name, last_name) values (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        //todo : keyHolder에 대해 학습하고, Customer를 저장후 저장된 Customer의 id를 반환하기
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }
}
