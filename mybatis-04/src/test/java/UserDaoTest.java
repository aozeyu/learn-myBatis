import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
   static Logger logger =  Logger.getLogger((UserDaoTest.class));
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j");
        logger.debug("debugger:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map= new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",2);
       List<User> userList =  mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1,2);
       List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowbounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
       sqlSession.close();
    }
}
