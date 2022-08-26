package cool.sparks.security.converter;

import dto.UserRoleDto;
import cool.sparks.security.dao.po.UserRolePo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleConverter {

    UserRoleDto convert(UserRolePo role);
    UserRolePo convert(UserRoleDto role);

    List<UserRoleDto> convert(List<UserRolePo> role);

}
