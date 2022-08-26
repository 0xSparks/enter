package cool.sparks.security.converter;

import cool.sparks.security.controller.dto.MenuDto;
import cool.sparks.security.dao.po.MenuPo;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuConverter {

    MenuDto convert(MenuPo menu);

    List<MenuDto> convert(List<MenuPo> list);

    MenuPo convert(MenuDto menu);
}
