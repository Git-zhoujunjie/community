package life.jiema.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoujunjie
 * @create 2019/10/11 10:13
 */
@Data
public class PaginationDTO {
    private List<QuestionDto> questions;
    private Boolean showPrevious;
    private Boolean showNext;
    private Boolean showFirstPage;
    private Boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = (totalCount % size == 0)?(totalCount / size):(totalCount / size + 1);

        pages.add(page);
        for(int i=1;i<3;i++){
            if(page - i > 0){
                pages.add(0,page-i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }
        if(page<=1) page = 1;
        if(page>=totalPage) page=totalPage;

        this.page = page;
        showPrevious = page != 1;
        showNext = page != totalPage;
        showFirstPage = !pages.contains(1);
        showEndPage = !pages.contains(totalPage);
    }
}
