package com.example.finalproject.controller;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.security.JwtProvider;
import com.example.finalproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {
    
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception{
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody Member member)throws Exception{
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

    @GetMapping("/member/findById/{memberId}")
    public ResponseEntity<Member> findById(@PathVariable int memberId){
        try {
            Member findMember = memberService.findById(memberId);
            if(findMember != null){
                return new ResponseEntity<Member>(findMember, HttpStatus.OK);
            }
        } catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/member/findByLoginId/{loginId}")
    public ResponseEntity<Member> findByLoginId(@PathVariable String loginId) {
        try {
            Member findMember = memberService.findByLoginId(loginId);
            System.out.println(findMember.toString());
            if (findMember != null) {
                return new ResponseEntity<>(findMember, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/member/delete/{memberId}")
    public ResponseEntity<Integer> delete(@PathVariable int memberId){
        boolean result = memberService.delete(memberId) == 1;
        return result == true ?
                new ResponseEntity<>(1 ,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @GetMapping("/member/findAllMember")
    public ResponseEntity<List<Member>> findAllMember(){
        List<Member> allMember = memberService.findAllMember();
        return allMember !=null ?
                new ResponseEntity<>(allMember,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/member/findByName/{name}")
    public ResponseEntity<List<Member>> findByName(@PathVariable String name) {
        List<Member> findName = memberService.findByName(name);
        return findName !=null?
                new ResponseEntity<>(findName,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/member/update")
    public ResponseEntity<String> update(@RequestBody Member member){
        return memberService.update(member) ==1 ?
                new ResponseEntity<>("ok",HttpStatus.OK) :
                new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
