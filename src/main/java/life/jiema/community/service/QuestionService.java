package life.jiema.community.service;

import life.jiema.community.dto.PaginationDTO;
import life.jiema.community.dto.Question;
import life.jiema.community.dto.QuestionDto;
import life.jiema.community.dto.User;
import life.jiema.community.mapper.QuestionMapper;
import life.jiema.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoujunjie
 * @create 2019/10/10 16:37
 */
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page <= 1) page = 1;
        if (page > paginationDTO.getTotalPage())
            page = paginationDTO.getTotalPage();

        Integer offset = size * (page - 1);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questionList = questionMapper.list(offset, size);

        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            // Spring自动将一个对象中的属性内容注入到另一个对象的同名属性中
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        paginationDTO.setQuestions(questionDtoList);

        return paginationDTO;
    }
}
