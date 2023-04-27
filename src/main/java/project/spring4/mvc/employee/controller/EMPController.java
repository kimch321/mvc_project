package project.spring4.mvc.employee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.model.EMPVO;
import project.spring4.mvc.employee.service.EMPService;

@Controller
public class EMPController {
    private static final Logger logger = LogManager.getLogger(EMPController.class);
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

    @GetMapping("/add")
    public String add() {
        return "empnew";
    }

    @PostMapping(value="/add")
    public ModelAndView addok(EMPVO emp) {
        ModelAndView mv = new ModelAndView();
        String view = "empfail";

        if(empsrv.newEmp(emp)) {
            view = "redirect:/list";
        }
        mv.setViewName(view);

        return mv;
    }

    @ExceptionHandler(BindException.class)
    public String typeMismatchParam(BindException ex) {
        logger.info("매개변수 관련 오류");
        System.out.println(ex.getMessage());

        return "empfail";
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam int empno) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("emp", empsrv.readOneEmp(empno));
        mv.setViewName("empview");
        return mv;
    }
}
