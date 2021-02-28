package net.tklearn.payroll;

import lombok.extern.slf4j.Slf4j;
import net.tklearn.payroll.model.Employee;
import net.tklearn.payroll.model.Order;
import net.tklearn.payroll.model.Status;
import net.tklearn.payroll.repository.EmployeeRepository;
import net.tklearn.payroll.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("team lead", "Tai", "Tran"));
            employeeRepository.save(new Employee("thief", "Frodo", "Baggins"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
