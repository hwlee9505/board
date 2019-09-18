package com.hwlee.mapper;

import com.hwlee.domain.BoardVO;
import com.hwlee.domain.Criteria;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    //    @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

    //    페이징 처리를 위해 생긴 메서드
    public List<BoardVO> getListWithPaging(Criteria cri);

    //    1.create(insert)처리
    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    //    2.read(select)처리
    public BoardVO read(Long bno);

    //    3.delete 처리    반환형이 int인 이유 : 등록, 삭제, 수정과 같은 DML 작업은 '몇 건의 데이터가 삭제(혹은 수정)되었는지'를 반환할 수 있습니다.
    public int delete(Long bno);

    //    4.update 처리
    public int update(BoardVO board);

    public int getTotalCount(Criteria cri);

}
