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

    private static final String All_RECORDSPENTTIME = "allRecordSpentTime";
    private static final String SAVE_RECORDSPENTTIME = "saveRecordSpentTime";
    private static final String ERROR_PAGE = "errorPage";

    @Autowired
    private SpentTimeFormValidator spentTimeFormValidator;
    @Autowired
    private SpentTimeService spentTimeService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(spentTimeFormValidator);
    }

    @RequestMapping (value = "all/recordSpentTime", method = RequestMethod.GET)
    public String showAllRecordSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("recordSpentTime", spentTimeService.getAll());
        return All_RECORDSPENTTIME;
    }

    @RequestMapping(value = "/add/recordSpentTime", method = RequestMethod.GET)
    public String showPageAddRecordSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("recordSpentTimeForm", new SpentTimeForm());
        return SAVE_RECORDSPENTTIME;
    }

    @RequestMapping(value = "/save/recordSpentTime/{id}", method = RequestMethod.GET)
    public String showPageEditRecordSpentTime(@PathVariable (value = "id") Long id, ModelMap modelMap) {
        SpentTimeDTO spentTimeDTO = spentTimeService.getById(id);
        if (spentTimeDTO == null) {
            return ERROR_PAGE;
        }
        modelMap.addAttribute("recordSpentTimeForm", new SpentTimeForm(spentTimeDTO));
        return SAVE_RECORDSPENTTIME;
    }

    @RequestMapping(value = "/save/recordSpentTime", method = RequestMethod.POST)
    public String getSaveRecordSpentTime(@Validated SpentTimeForm spentTimeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_RECORDSPENTTIME;
        }
        if ("".equals(spentTimeForm.getId())) {
            SpentTimeDTO spentTimeDTO = getRecordSpentTimeDTO(spentTimeForm);
            spentTimeService.insert(spentTimeDTO);
        } else {
            SpentTimeDTO spentTimeDTO = getRecordSpentTimeDTO(spentTimeForm);
            spentTimeDTO.setId(spentTimeForm.getId());
            spentTimeService.update(spentTimeDTO);
        }
        return "redirect:/all/recordSpentTime";
    }

    private SpentTimeDTO getRecordSpentTimeDTO(@Validated SpentTimeForm spentTimeForm) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        spentTimeDTO.setNumberOfHour(spentTimeForm.getNumberOfHour());
        return spentTimeDTO;
    }

    @RequestMapping(value = "/delete/recordSpentTime/{id}", method = RequestMethod.GET)
    public RedirectView deleteRecordSpentTime(@PathVariable(value = "id") Long id) {
        spentTimeService.deleteById(id);
        return new RedirectView("/all/recordSpentTime");
    }
}
