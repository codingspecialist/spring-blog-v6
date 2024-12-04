package com.example.blog._core.error;

import com.example.blog._core.error.ex.Exception400;
import com.example.blog._core.error.ex.Exception401;
import com.example.blog._core.error.ex.Exception403;
import com.example.blog._core.error.ex.Exception404;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 에러처리
@ControllerAdvice
public class MyControllerAdvice {


    @ResponseBody
    @ExceptionHandler(Exception403.class)
    public String err403(Exception403 e){
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}",e.getMessage());

        return body;
    }

    @ResponseBody
    @ExceptionHandler(Exception400.class)
    public String err400(Exception400 e){
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}",e.getMessage());

        return body;
    }

    @ResponseBody
    @ExceptionHandler(Exception401.class)
    public String err401(Exception401 e){
        String body = """
                <script>
                    alert('${msg}');
                    location.href='/login-form';
                </script>
                """.replace("${msg}",e.getMessage());
        return body;
    }

    @ResponseBody
    @ExceptionHandler(Exception404.class)
    public String err404(Exception404 e){
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}",e.getMessage());

        return body;
    }
}
