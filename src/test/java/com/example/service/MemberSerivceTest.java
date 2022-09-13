package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.domain.Member;
import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;

public class MemberSerivceTest {
	
	MemberService memberService ;
	MemoryMemberRepository memberRepository ;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	@Test
	void 회원가() {
		//given
		Member member = new Member();
		member.setName("hello");
		//when
		Long saveId = memberService.join(member);
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("Spring");
		
		Member member2 = new Member();
		member2.setName("Spring");
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다,");
//		
//		try {
//		memberService.join(member2);
//		fail();
//		}catch (IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
		//then 
	}
	
	@Test
	void fndMembers() {
	}
	
	@Test
	void findOne() {
	}
}
