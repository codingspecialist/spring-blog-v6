package com.example.blog.user;

import com.example.blog._core.error.ex.Exception401;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    
    public User 로그인(UserRequest.LoginDTO loginDTO){
        User userPS = userRepository.findByUsername(loginDTO.getUsername());
        if(!userPS.getPassword().equals(loginDTO.getPassword())){
            throw new Exception401("비밀번호가 일치하지 않습니다");
        }
        return userPS;
    }
}
