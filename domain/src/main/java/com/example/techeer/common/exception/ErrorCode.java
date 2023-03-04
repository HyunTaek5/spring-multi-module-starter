package com.example.techeer.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /* 예시 */
    NO_DATA_IN_DB(-1, "데이터베이스에 값이 존재하지 않습니다."),
    OMISSION_REQUIRE_PARAM(-2, "request 파라미터가 누락되었습니다."),

    /* 레스토랑 */
    RESTAURANT_ID_NOT_FOUND(-200, "존재하지 않는 restaurant 입니다."),

    /* 리뷰 */
    ORDER_REVIEW_ALREADY_EXISTS(-600, "요청 주문에 대한 리뷰가 이미 존재합니다."),
    USER_REVIEW_NOT_FOUND(-601, "요청 유저가 작성한 리뷰가 존재하지 않습니다."),;


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
