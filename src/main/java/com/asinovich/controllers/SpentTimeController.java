package com.asinovich.controllers;

import com.asinovich.controllers.forms.SpentTimeForm;
import com.asinovich.controllers.validator.SpentTimeFormValidator;
import com.asinovich.dto.SpentTimeDTO;
import com.asinovich.service.SpentTimeService;
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
 * TODO : still not finish
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class SpentTimeController {

    private static final String All_SPENTTIME = "allSpentTime";
    private static final String SAVE_SPENTTIME = "saveSpentTime";
    private static final String ERROR_PAGE = "errorPage";

    @Autowired
    private SpentTimeFormValidator spentTimeFormValidator;
    @Autowired
    private SpentTimeService spentTimeService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(spentTimeFormValidator);
    }

    @RequestMapping (value = "all/spentTime", method = RequestMethod.GET)
    public String showAllSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("spentTime", spentTimeService.getAll());
        return All_SPENTTIME;
    }

    @RequestMapping(value = "/add/spentTime", method = RequestMethod.GET)
    public String showPageAddSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("spentTimeForm", new SpentTimeForm());
        return SAVE_SPENTTIME;
    }

    @RequestMapping(value = "/save/spentTime/{id}", method = RequestMethod.GET)
    public String showPageEditSpentTime(@PathVariable (value = "id") Long id, ModelMap modelMap) {
        SpentTimeDTO spentTimeDTO = spentTimeService.getById(id);
        if (spentTimeDTO == null) {
            return ERROR_PAGE;
        }
        modelMap.addAttribute("spentTimeForm", new SpentTimeForm(spentTimeDTO));
        return SAVE_SPENTTIME;
    }

    @RequestMapping(value = "/save/spentTime", method = RequestMethod.POST)
    public String getSaveSpentTime(@Validated SpentTimeForm spentTimeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_SPENTTIME;
        }
        if ("".equals(spentTimeForm.getId())) {
            SpentTimeDTO spentTimeDTO = getSpentTimeDTO(spentTimeForm);
            spentTimeService.insert(spentTimeDTO);
        } else {
            SpentTimeDTO spentTimeDTO = getSpentTimeDTO(spentTimeForm);
            spentTimeDTO.setId(spentTimeForm.getId());
            spentTimeService.update(spentTimeDTO);
        }
        return "redirect:/all/spentTime";
    }

    private SpentTimeDTO getSpentTimeDTO (@Validated SpentTimeForm spentTimeForm) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        spentTimeDTO.setNumberOfHour(spentTimeForm.getNumberOfHour());
        return spentTimeDTO;
    }

    @RequestMapping(value = "/delete/spentTime/{id}", method = RequestMethod.GET)
    public RedirectView deleteSpentTime(@PathVariable(value = "id") Long id) {
        spentTimeService.deleteById(id);
        return new RedirectView("/all/spentTime");
    }
}
