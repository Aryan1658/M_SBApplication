package com.metateam.sba.controller;

import com.metateam.sba.dto.GlobalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController is the Combination of Controller + ResponseBody
@RestController
public class MainController extends BaseClass {

    @RequestMapping("/")
    public ResponseEntity<GlobalApiResponse> mainRequest(){
        List<String> list = new ArrayList<>();
                list.add("Hello spring webservices is working");
                list.add("Hello spring webservices is working");
                list.add("Hello spring webservices is working");
                list.add("Hello spring webservices is working");
                list.add("Hello spring webservices is working");
                try{
                    return new ResponseEntity<>(successResponse("Data fetched successfully",list), HttpStatus.OK);


                }catch (Exception ex){
                    return new ResponseEntity<>(failureResponse("Data fetched failed",ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);


                }
    }

}
