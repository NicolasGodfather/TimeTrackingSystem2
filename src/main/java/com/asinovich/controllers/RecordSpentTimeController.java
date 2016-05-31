package com.asinovich.controllers;

import com.asinovich.controllers.forms.RecordSpentTimeForm;
import com.asinovich.controllers.validator.RecordSpentTimeFormValidator;
import com.asinovich.dto.RecordSpentTimeDTO;
import com.asinovich.service.RecordSpentTimeService;
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
public class RecordSpentTimeController {

    private static final String All_RECORDSPENTTIME = "allRecordSpentTime";
    private static final String SAVE_RECORDSPENTTIME = "saveRecordSpentTime";
    private static final String ERROR_PAGE = "errorPage";

    @Autowired
    private RecordSpentTimeFormValidator recordSpentTimeFormValidator;
    @Autowired
    private RecordSpentTimeService  recordSpentTimeService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator( recordSpentTimeFormValidator);
    }

    @RequestMapping (value = "all/recordSpentTime", method = RequestMethod.GET)
    public String showAllRecordSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("recordSpentTime", recordSpentTimeService.getAll());
        return All_RECORDSPENTTIME;
    }

    @RequestMapping(value = "/add/recordSpentTime", method = RequestMethod.GET)
    public String showPageAddRecordSpentTime(ModelMap modelMap) {
        modelMap.addAttribute("recordSpentTimeForm", new RecordSpentTimeForm());
        return SAVE_RECORDSPENTTIME;
    }

    @RequestMapping(value = "/save/recordSpentTime/{id}", method = RequestMethod.GET)
    public String showPageEditRecordSpentTime(@PathVariable (value = "id") Long id, ModelMap modelMap) {
        try {
            RecordSpentTimeDTO recordSpentTimeDTO = recordSpentTimeService.getById(id);
            modelMap.addAttribute("recordSpentTimeForm", new RecordSpentTimeForm(recordSpentTimeDTO));
            return SAVE_RECORDSPENTTIME;
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = "/save/recordSpentTime", method = RequestMethod.POST)
    public String getSaveRecordSpentTime(@Validated RecordSpentTimeForm recordSpentTimeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_RECORDSPENTTIME;
        }
        if ("".equals(recordSpentTimeForm.getId())) {
            RecordSpentTimeDTO recordSpentTimeDTO = getRecordSpentTimeDTO(recordSpentTimeForm);
            recordSpentTimeService.insert(recordSpentTimeDTO);
        } else {
            RecordSpentTimeDTO recordSpentTimeDTO = getRecordSpentTimeDTO(recordSpentTimeForm);
            recordSpentTimeDTO.setId(recordSpentTimeForm.getId());
            recordSpentTimeService.update(recordSpentTimeDTO);
        }
        return "redirect:/all/recordSpentTime";
    }

    private RecordSpentTimeDTO getRecordSpentTimeDTO(@Validated RecordSpentTimeForm recordSpentTimeForm) {
        RecordSpentTimeDTO recordSpentTimeDTO = new RecordSpentTimeDTO();
        recordSpentTimeDTO.setNumberOfHour(recordSpentTimeForm.getNumberOfHour());
        return recordSpentTimeDTO;
    }

    @RequestMapping(value = "/delete/recordSpentTime/{id}", method = RequestMethod.GET)
    public RedirectView deleteRecordSpentTime(@PathVariable(value = "id") Long id) {
        recordSpentTimeService.deleteById(id);
        return new RedirectView("/all/recordSpentTime");
    }
}
