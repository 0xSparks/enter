package cool.sparks.security.service.permission;

import org.springframework.stereotype.Service;

/**
 * @author Sparks
 * @date 2022/8/25
 */
@Service
public class AuthorizedManagerServiceImpl implements AuthorizedManagerService{
    @Override
    public boolean hasPermission(String permission) {
        if(permission == null){
            return true;
        }
        System.out.println("进入AuthorizedManagerService"+permission);
        return false;
    }
}
