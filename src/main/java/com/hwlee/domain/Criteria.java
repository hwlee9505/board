package com.hwlee.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
public class Criteria {

    //페이징 처리를 위해서 필요한 파라미터는 1) 페이지 번호(pageNum) 2) 한 페이지당 몇 개의 데이터(amount)를 보여줄
    //것인지가 결정되어야만 합니다.

    private int pageNum;
    private int amount;

    private String type;
    private String keyword;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypeArr() {
        return type == null ? new String[]{} : type.split("");
    }

    public String getListLink(){

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNun", this.pageNum)
                .queryParam("amount", this.getAmount())
                .queryParam("keyword", this.getKeyword())
                .queryParam("type" , this.getType());

        return builder.toUriString();

    }


}
