package com.zctech88.highlight_springmvc4.web.ch4_5;

import com.zctech88.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @RequestMapping(value = "/convert", produces = {"appliction/x-wisely"})
    public @ResponseBody
    DemoObj conver(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
