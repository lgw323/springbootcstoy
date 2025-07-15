package com.iamjesus.homework.domain.Member.controller;

import com.iamjesus.homework.domain.Member.controller.code.MemberSuccessCode;
import com.iamjesus.homework.domain.Member.dto.MemberRequest;
import com.iamjesus.homework.domain.Member.service.MemberService;
import com.iamjesus.homework.global.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class MemberController {
    MemberService memberService;

    @PostMapping("/register")
    public PostResponse<Void> register(@RequestBody MemberRequest req) {
        memberService.createMember(req.username(), req.password());
        return PostResponse.of(MemberSuccessCode.OK_REGISTERED_MEMBER);
    }
    @PostMapping("/login")
    public PostResponse<Void> login(@RequestBody MemberRequest req) {
        memberService.validateMember(req.username(), req.password());
        return PostResponse.of(MemberSuccessCode.OK_LOOGGED_IN_MEMBER);
    }
}