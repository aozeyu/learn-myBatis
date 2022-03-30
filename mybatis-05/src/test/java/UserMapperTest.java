
import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void  test() {
       SqlSession sqlSession =  MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserByID() {
        SqlSession sqlSession =  MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        sqlSession.close();
    }
}
