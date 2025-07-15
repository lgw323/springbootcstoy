package com.iamjesus.homework.domain.Member.controller;

import com.iamjesus.homework.domain.Member.controller.code.MemberExceptionCode;
import com.iamjesus.homework.domain.Member.controller.code.MemberSuccessCode;
import com.iamjesus.homework.domain.Member.dto.MemberRequest;
import com.iamjesus.homework.domain.Member.dto.WithdrawRequest;
import com.iamjesus.homework.domain.Member.service.MemberService;
import com.iamjesus.homework.global.exception.domain.UnauthorizedException;
import com.iamjesus.homework.global.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return PostResponse.of(MemberSuccessCode.OK_LOGGED_IN_MEMBER);
    }
    @PostMapping("/withdrawal")
    public PostResponse<Void> withdrawal(@RequestHeader("Authorization") String username, @RequestBody WithdrawRequest req) {
        if (req.password() == null || req.password().isBlank()) {
            throw new UnauthorizedException(MemberExceptionCode.BAD_REQUEST);
        }
        memberService.withdrawMember(username, req.password());
        return PostResponse.of(MemberSuccessCode.OK_WITHDRAWAL_MEMBER);
    }
}