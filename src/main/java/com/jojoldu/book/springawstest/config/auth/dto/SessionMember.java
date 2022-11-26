package com.jojoldu.book.springawstest.config.auth.dto;

import com.jojoldu.book.springawstest.domain.user.Member;
import lombok.Getter;

@Getter
public class SessionMember {

    private String name;
    private String email;
    private String picture;

    public SessionMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}
