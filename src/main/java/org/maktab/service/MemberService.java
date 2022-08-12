package org.maktab.service;

import org.maktab.entity.Member;
import org.maktab.repository.MemberRepository;
import org.maktab.util.list.MemberList;

import java.sql.SQLException;

public class MemberService {

    MemberRepository memberRepository = new MemberRepository();

    public boolean save(Member member) throws SQLException {
        if(memberRepository.load(member) == null){
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    public boolean remove(Member member) throws SQLException {
        if(memberRepository.remove(member) == 0){
            return false;
        }
        return true;

        /*if (memberRepository.load(member) != null){
            memberRepository.remove(member);
            return true
        }
        return false*/
    }

    public MemberList loadAll() throws SQLException {
        return memberRepository.loadAll();
    }

    public boolean edit(Member member) throws SQLException {
        if(memberRepository.load(member) != null){
            memberRepository.edit(member);
            return true;
        }
        return false;
    }

    public boolean load(Member member) throws SQLException {
        return memberRepository.load(member) != null;
    }


}
