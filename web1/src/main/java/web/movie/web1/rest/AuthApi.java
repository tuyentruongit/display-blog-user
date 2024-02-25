//package web.movie.web1.rest;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import web.movie.web1.model.request.LoginRequest;
//import web.movie.web1.service.AuthService;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthApi {
//
//    private final AuthService authService;
//    @PostMapping("/log-in")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
//        authService.login(loginRequest);
//        return ResponseEntity.ok().build();
//    }
//}
