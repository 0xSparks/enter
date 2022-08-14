package cool.sparks.user.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sparks
 * @date 2022/8/13
 */
@RestController
@Api(tags = "User")
public class UserController {
    @Operation(summary = "Get user information")
    @GetMapping("/users")
    public String getUserName() {
        return "你好你好你好";
    }
}
