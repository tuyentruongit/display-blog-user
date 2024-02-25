//package web.movie.web1.Config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.query.sqm.mutation.internal.Handler;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import web.movie.web1.entity.User;
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // Lấy thông tin user từ session
//        User user = (User) request.getSession().getAttribute("currentUser");
//
//        // Nếu currentUser == null => báo lỗi 401
//        if (user == null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        return true;
//    }
//}
