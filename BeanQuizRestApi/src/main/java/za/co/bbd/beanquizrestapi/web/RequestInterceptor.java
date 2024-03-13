package za.co.bbd.beanquizrestapi.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    public static Optional<String> token;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
        token = Optional.ofNullable(request.getHeader("Authorization"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
    }
}
