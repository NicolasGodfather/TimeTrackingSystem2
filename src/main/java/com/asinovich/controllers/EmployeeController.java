package com.asinovich.controllers;

import com.asinovich.controllers.forms.EmployeeForm;
import com.asinovich.controllers.validator.EmployeeFormValidator;
import com.asinovich.dto.EmployeeDTO;
import com.asinovich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    private static final String All_EMPLOYEE = "allEmployee";
    private static final String SAVE_EMPLOYEE = "saveEmployee";
    private static final String ERROR_PAGE = "errorPage";

    @Autowired
    private EmployeeFormValidator employeeFormValidator;
    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(employeeFormValidator);
    }

    @RequestMapping(value = "all/employee", method = RequestMethod.GET)
    public String showAllEmployees(ModelMap modelMap) {
        modelMap.addAttribute("employees", employeeService.getAll());
        return All_EMPLOYEE;
    }

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public String showPageAddEmployee(ModelMap modelMap) {
        modelMap.addAttribute("employeeForm", new EmployeeForm());
        return SAVE_EMPLOYEE;
    }

    @RequestMapping(value = "/save/employee/{id}", method = RequestMethod.GET)
    public String showPageEditEmployee(@PathVariable(value = "id") Long id, ModelMap modelMap) {
        try {
            EmployeeDTO employeeDTO = employeeService.getById(id);
            modelMap.addAttribute("employeeForm", new EmployeeForm(employeeDTO));
            return SAVE_EMPLOYEE;
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = "/save/employee", method = RequestMethod.POST)
    public String getSaveEmployee(@Validated EmployeeForm employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_EMPLOYEE;
        }
        if ("".equals(employeeForm.getId())) {
            EmployeeDTO employeeDTO = getEmployeeDTO(employeeForm);
            employeeService.insert(employeeDTO);
        } else {
            EmployeeDTO employeeDTO = getEmployeeDTO(employeeForm);
            employeeDTO.setId(employeeForm.getId());
            employeeService.update(employeeDTO);
        }
        return "redirect:/all/employee";
    }

    private EmployeeDTO getEmployeeDTO(@Validated EmployeeForm employeeForm) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employeeForm.getFirstName());
        employeeDTO.setLastName(employeeForm.getLastName());
        return employeeDTO;
    }

    @RequestMapping(value = "/delete/employee/{id}", method = RequestMethod.GET)
    public RedirectView deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteById(id);
        return new RedirectView("/all/employee");
    }

}


