package com.example.techeer.persistence.post.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchPostReq {

    private String title;

    private String body;

}