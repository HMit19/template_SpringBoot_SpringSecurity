package com.example.spring_security_boot.controller;

import com.example.spring_security_boot.model.Customer;
import com.example.spring_security_boot.service.impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

// Các bước để tạo một Controller
// 1. Tạo một class Controller và thêm annotation @Controller vào class Controller để đánh dấu class này là một Controller
// 2. Thêm annotation @Autowired vào các thuộc tính dùng để gọi các phương thức của giao diện khác
// 3. Thêm annotation @RequestMapping để mapping đường dẫn với class Controller
// 4. Tạo các phương thức để xử lý các request từ client
// 5. Thêm annotation @GetMapping, @PostMapping, @PutMapping, @DeleteMapping để xác định phương thức xử lý request
// 6. Thêm annotation @PathVariable, @RequestParam, @RequestBody để lấy dữ liệu từ request.
//@PathVariable: lấy dữ liệu từ url còn @RequestParam: lấy dữ liệu từ query string. query string là chuỗi kết nối sau dấu ? trong url.
// 7. Thêm annotation @ModelAttribute để lấy dữ liệu từ form dạng model
// 8. Thêm annotation @SessionAttribute để lưu trữ dữ liệu trong session
// 9. Thêm annotation @CookieValue để lấy giá trị của cookie
// 10. Thêm annotation @RequestHeader để lấy thông tin từ header
// 11. Thêm annotation @ResponseStatus có tác dụng để trả về một status code

@Controller
@RequestMapping("/admin")
public class CustomerController {
    // class này dùng để xử lý các request từ client.
    // Ta có thể thêm các phương thức khác vào class này.

    @Autowired
    private ICustomerService customerService;
    // có tác dụng để gọi các phương thức của giao diện ICustomerService để thao tác với database.

    @GetMapping("/customers")
    public ModelAndView showListCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("Customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            return new ModelAndView("/customer/error.404");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
