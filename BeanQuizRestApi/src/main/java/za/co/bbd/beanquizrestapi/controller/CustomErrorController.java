package za.co.bbd.beanquizrestapi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    
    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public ResponseEntity<String> handleError() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page Not found");
    }
}
