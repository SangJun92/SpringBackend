//package com.mysite.springbackend.exception;
//
//import com.mysite.springbackend.entity.Board;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class BoardNotFoundAdvice {
//    @ResponseBody
//    @ExceptionHandler(BoardNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, String> exceptionHandler(BoardNotFoundException exception) {
//        Map<String, String> errorMsg = new HashMap<>();
//        errorMsg.put("message", exception.getMessage());
//        return errorMsg;
//    }
//}
