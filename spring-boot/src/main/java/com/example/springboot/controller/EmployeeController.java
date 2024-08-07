package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import com.example.springboot.form.*;
import com.example.springboot.service.*;
import jakarta.annotation.*;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public EmployeeController() {
        // some kind of initialization code in here

        // in phase 1 of component scan the constructor is called to create the new object
        // however the autowired fields are not set yet
        // in phase 2 the autowired fields are set
        // in phase 3 the @PostConstruct method is called

        // constructors are no longer used very much in spring
    }

    @PostConstruct
    public void init() {
        // this is executed in phase 3 after all of the autowired fields are set
        // this takes the place of a constructor for initialization code
    }

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDao;

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

        return response;
    }



    @GetMapping("/create")
    public ModelAndView create() {
        // this method is setting up the view for rendering
        ModelAndView response = new ModelAndView("employee/create");

        loadDropdowns(response);

        return response;
    }

    private void loadDropdowns(ModelAndView response) {
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);
    }

    // these 2 annotations are essentially the same thing
    // @GetMapping("/edit")  <-- this is just a shortcut for the below line
    @RequestMapping(value = "/edit", method = RequestMethod.GET )
    public ModelAndView edit(@RequestParam(required = false) Integer employeeId) {
        // by setting required = false on the incoming parameter we allow null to enter the controller so that spring does not cause an error page
        // then we check if the input is null before trying to do our query

        // this view is the same for all the methods so far, even tho it is named create and we are using it for edit
        ModelAndView response = new ModelAndView("employee/create");

        // here again we have some duplicated code that could be refactored into a method
        loadDropdowns(response);

        // here I am checking the incoming employeeId to see if it is null or not
        if (employeeId != null) {
            // load the employee from the database and set the form bean with all the employee values
            // this is because the form bean is on the JSP page and we need to pre-populate the form with the employee data
            Employee employee = employeeDao.findById(employeeId);
            if (employee != null) {
                // we only do this code if we found an employee in the database
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();

                // when we are doing an edit we need to pass the employee id to the JSP page so it can put it in the hidden input field
                form.setEmployeeId(employee.getId());

                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstname());
                form.setLastName(employee.getLastname());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId()); // interesteing hibernate here

                response.addObject("form", form);
            } else {
                // the employee was not found in the database
                response.addObject("errorMessage", "The employee was not found in the database.");
            }
        }

        return response;
    }

    // this is /employee/createSubmit
    // this method is only called when the form is submitted
    // this is being used for both edit and create because we are checking the incoming employeeid if it is null then it is a create
    // you can use one or the other of @PostMapping or @RequestMapping
    //@PostMapping("/createSubmit")
    @RequestMapping(value = "/createSubmit", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        // arguement to the constructor here is the view name - the view name can be a JSP location or a redirect URL
        ModelAndView response = new ModelAndView();

        // we need to validate that the email does not exist in the database, however we only want to the check if this is a create
        // when doing a manual check in the controller we want this before the bindingResult.hasErrors() check so that it will fall into that block of code
        if ( form.getEmployeeId() == null ) {
            Employee e = employeeDao.findByEmailIgnoreCase(form.getEmail());
            // if the e is not null then it was found in the database which means the email is already in use
            if ( e != null ) {
                // this means the email already exists in the database
                bindingResult.rejectValue("email", "email", "This email is already in use. Manual Check");
            }
        }

        // the first thing we want to do is check if the incoming user input has any errors
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // TODO =  Cleanup this code to reduce the duplicated code in the create()

            // we are in this part of the if statement so we know for sure that an error has occured
            // we are going to add the binding result to the model, so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            loadDropdowns(response);

            // im going to set the view name to be
            response.setViewName("employee/create");

            // im going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", form);

            return response;
        } else {
            // call the employee service to create the employee
            Employee employee = employeeService.createEmployee(form);

            // redirecting to the employee detail page
            // however often times this would redirect to the edit page (which we have not created)
            // after the redirect is actually a URL not a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());

            // we added these 2 lines of code so that we could demonstrate using the network tab in the browser.
            // it prevents the redirect from happening so we can see the response in the network tab
            //loadDropdowns(response);
            //response.setViewName("employee/create");

            return response;
        }
    }
}