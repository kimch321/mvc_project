package project.spring4.mvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.service.EMPService;

@Controller
public class EMPController {
    private EMPService empsrv;

    @Autowired
    public EMPController(EMPService empsrv) {
        this.empsrv = empsrv;
    }

    @GetMapping(value = "/emplist")
    public ModelAndView emplist() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("emps", empsrv.readEmpList());
        mv.setViewName("emplist");

        return mv;
    }
}
