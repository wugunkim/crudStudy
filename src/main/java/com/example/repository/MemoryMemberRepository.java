package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.domain.Member;


public class MemoryMemberRepository implements MemberRepository{
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence =0L;
	
	
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(),member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findall() {
		// store의 멤버들 (values()) 들을 반환 
		return new ArrayList<>(store.values());
	}
	public void clearStore() {
		store.clear();
	}

}
