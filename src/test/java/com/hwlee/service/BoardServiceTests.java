package com.hwlee.service;

import com.hwlee.domain.BoardVO;
import com.hwlee.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/Users/hyunwoo/IdeaProjects/spirng190908/web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test   //  테스트의 목적: BoardService 객체가 제대로 주입이 가능한지 확인하는 작업으로 시작
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test   //  이 로직 정확히 이해하기 못했어욧!!!!
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        service.register(board);

        log.info("생성된 게시물의 번호: " + board.getBno());
    }

    @Test
    public void testGetList() {
        service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
    }

    @Test
    public void testGet() {
        log.info(service.get(1L));
    }

    @Test
    public void testDelete() {
        log.info("REMOVE RESULT: " + service.remove(24L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(1L);

        if(board == null){
            return;
        }
        board.setTitle("제목 수정합니다.");
        log.info("MODIFY RESULT:  " + service.modify(board));
    }
}
