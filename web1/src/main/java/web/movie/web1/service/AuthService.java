//package web.movie.web1.service;
//
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import web.movie.web1.entity.User;
//import web.movie.web1.exception.BadRequestException;
//import web.movie.web1.exception.ResourceNotFound;
//import web.movie.web1.model.request.LoginRequest;
//import web.movie.web1.repository.UserRepository;
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class AuthService{
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//    private  final HttpSession session;
//
//    public void login(LoginRequest loginRequest) {
//        User user = userRepository.findByEmail(loginRequest.getEmail())
//                .orElseThrow(() -> new BadRequestException("Tài khoản hoặc mật khẩu không đúng"));
//
//        //  kiểm tra pasword
//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            throw new BadRequestException("Tài khoản hoặc mật khẩu không đúng");
//
//        }
//        session.setAttribute("currentUser" , user);
//    }
//}
