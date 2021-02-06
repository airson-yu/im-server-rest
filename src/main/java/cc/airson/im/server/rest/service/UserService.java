package cc.airson.im.server.rest.service;

import cc.airson.im.server.rest.dao.mapper.UserMapper;
import cc.airson.im.server.rest.dao.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public User load(Long id) {
        return mapper.load(id);
    }

    public User selectForLogin(String username, String password) {
        return mapper.selectForLogin(username, password);
    }

    public int insert(User user){
        return mapper.insert(user);
    }

    public int update(User user){
        return mapper.update(user);
    }

    public int delete(long id){
        return mapper.delete(id);
    }

}
