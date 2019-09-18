package com.hwlee.service;

import com.hwlee.domain.BoardVO;
import com.hwlee.domain.Criteria;

import java.util.List;

public interface BoardService {

    //    1.create
    public void register(BoardVO board);

    //    2.read
    public BoardVO get(Long bno);

    //    3.update
    public boolean modify(BoardVO board);

    //    4.delete
    public boolean remove(Long bno);

    //    2.read(전체를 collection으로)
//    public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);

    public int getTotal(Criteria cri);

}
