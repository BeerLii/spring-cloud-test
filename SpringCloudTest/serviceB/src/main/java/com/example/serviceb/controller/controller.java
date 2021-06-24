package com.example.serviceb.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicea")
interface EchoService {
    @RequestMapping(value = "/config/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable("str") String str);
}


@RestController
public class controller {
    @Autowired
    private EchoService echoService;
    @RequestMapping(value = "/hellob/{str}", method = RequestMethod.GET)
    public String hellob(@PathVariable String str){
        return echoService.echo(str);
    }
    @RequestMapping(value = "/hellobs", method = RequestMethod.GET)
    public String hellobs(){ return "gggg"; }

}
