package sugimomoto.crudapplicationsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import sugimomoto.crudapplicationsample.model.*;
import sugimomoto.crudapplicationsample.repostitory.*;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping("/")
    public String showList(@ModelAttribute Employee employee, Model model){
        model.addAttribute("employees", repository.findAll());
        model.addAttribute("count", repository.findAll().size());
        return "index";
    }

    @GetMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee){
        return "form";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Employee employee, BindingResult result, Model model){
        model.addAttribute("employees", repository.searchByName("%" + employee.getName() + "%"));
        model.addAttribute("count", repository.searchByName("%" + employee.getName() + "%").size());
        return "index";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Employee employee, BindingResult result){
        
        if(result.hasErrors()){
            return "form";
        }

        repository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        model.addAttribute("employee", repository.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/";
    }
}
