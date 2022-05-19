/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.factories;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import sat.recruitment.api.domain.user.User;
import sat.recruitment.api.domain.user.UserNormal;
import sat.recruitment.api.domain.user.UserPremium;
import sat.recruitment.api.domain.user.UserSuper;

/**
 *
 * @author lsanmartin
 */
@Service
public class UserFactory {
    static final Map<String, Class<?>> classes = new HashMap<>();
    
    @PostConstruct
    public void initFactoryCache() {
            classes.put("Normal", UserNormal.class);
            classes.put("Premium", UserPremium.class);
            classes.put("SuperUser", UserSuper.class);
    }
    
    
    public static User getUserByType(String type) throws InstantiationException, IllegalAccessException {
        User newUser = (User) classes.get(type).newInstance();
        if(newUser == null) throw new RuntimeException("Unknown user type: " + type);
        return newUser;
    }
    
    
    
}
