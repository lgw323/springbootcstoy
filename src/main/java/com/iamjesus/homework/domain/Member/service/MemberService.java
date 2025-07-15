package com.iamjesus.homework.domain.Member.service;

import com.iamjesus.homework.domain.Member.controller.code.MemberExceptionCode;
import com.iamjesus.homework.domain.Member.model.Member;
import com.iamjesus.homework.domain.Member.repository.MemberRepository;
import com.iamjesus.homework.global.exception.domain.NotFoundException;
import com.iamjesus.homework.global.exception.domain.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;

    public void createMember(String username, String password) {
        Member member = Member.of(username, password);
        memberRepository.save(member);
    }
    public void validateMember(String username, String password) {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(MemberExceptionCode.NOT_FOUND_MEMBER));
        if(!member.getPassword().equals(password)) {
            throw new UnauthorizedException(MemberExceptionCode.UNAUTHORIZED_WRONG_PASSWORD);
        }
    }
}