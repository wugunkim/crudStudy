package com.example.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.domain.Member;


class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("SpringKim");
		
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		Assertions.assertEquals(member, result);
		
}
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
		
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		
		List<Member> result = repository.findall();
		assertThat(result.size()).isEqualTo(2);
		

	}
}
