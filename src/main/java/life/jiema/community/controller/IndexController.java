package life.jiema.community.controller;

import life.jiema.community.dto.PaginationDTO;
import life.jiema.community.dto.QuestionDto;
import life.jiema.community.dto.User;
import life.jiema.community.mapper.QuestionMapper;
import life.jiema.community.mapper.UserMapper;
import life.jiema.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Zhoujunjie
 * @create 2019/9/24 11:21
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        //model.addAttribute("test","test!!!!");
        return "index";
    }
}


