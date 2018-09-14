package net.chibidevteam.ddlmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.chibidevteam.apiversioning.annotation.ApiRequestMapping;
import net.chibidevteam.apiversioning.annotation.ApiVersion;

@Controller
@ApiVersion(">1.5")
@RequestMapping("/example")
public class MyController {

    @ApiVersion("<2.5")
    @ApiRequestMapping("/")
    @ResponseBody
    public String example() {
        return "Hello World";
    }

    @ApiVersion({ ">2.5", "!3" })
    @ApiRequestMapping
    @ResponseBody
    public String newExample() {
        return "Hello in version higher than 2.5!";
    }

    @ApiVersion("3")
    @ApiRequestMapping
    @ResponseBody
    public String exampleV3() {
        return "Hello in version 3!";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getTest() {
        return "Hello Test";
    }
}
