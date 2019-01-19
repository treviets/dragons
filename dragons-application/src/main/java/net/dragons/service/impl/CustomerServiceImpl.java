package net.dragons.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.bouncycastle.crypto.tls.EncryptionAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.dragons.dto.CustomerDto;
import net.dragons.dto.CustomerNewDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.repository.CustomerNewRepository;
import net.dragons.repository.CustomerRepository;
import net.dragons.service.CustomerService;
import util.CustomerRoleConstant;
import util.CustomerStatusConstant;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerNewRepository customerNewRepository;


	@Override
	public Customer getById(Long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Long create(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setPassword(customerDto.getPassword());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setRoleId(CustomerRoleConstant.CUSTOMER_ROLE);
		customer.setStatus(CustomerStatusConstant.ENABLE);
		
		customerRepository.save(customer);
		
		return customer.getId();
	}

	@Override
	public void delete(Long customerId) {

	}

	@Override
	public void update(CustomerDto customerDto) {
		Customer customer = customerRepository.findById(customerDto.getCustomerId());
		
		customer.setPassword(customerDto.getPassword());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setRoleId(CustomerRoleConstant.CUSTOMER_ROLE);
		customer.setStatus(CustomerStatusConstant.ENABLE);
		
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createCustomer(CustomerNewDto customerNewDto) {
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		CustomerNewEntity customer = new CustomerNewEntity();
		
		customer.setEmail(customerNewDto.getEmail());
		customer.setFirstName(customerNewDto.getFirstname());
		customer.setLastName(customerNewDto.getLastname());
		customer.setPassword(customerNewDto.getPassword());
		try {
			customer.setDateOfBirth(formatter.parse(customerNewDto.getDayofbirth()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			customer.setDateOfBirth(null);
			e1.printStackTrace();
		}
		customer.setRoleId(CustomerRoleConstant.CUSTOMER_ROLE);
		customer.setStatus(CustomerStatusConstant.ENABLE);

		try {
			customerNewRepository.save(customer);
		}catch (Exception e) {
			// TODO: handle exception
            System.out.println("++++++++++++++++++++");
            System.out.println(e.getMessage());

		}
		
		return customer.getId();
	}

	@Override
	public CustomerNewEntity getByEmail(String email) {
		// TODO Auto-generated method stub
		return customerNewRepository.findByEmail(email);
	}

	@Override
	public ResponseDto updateNewUser(CustomerNewDto customerNewDto) {
		
		CustomerNewEntity entity = customerNewRepository.findByEmail(customerNewDto.getEmail());
		entity.setPhone(customerNewDto.getPhone());
		
		customerNewRepository.save(entity);
		ResponseDto response = new ResponseDto();
		response.setData(entity);
		response.setMessage("OK");
		response.setStatus(HttpStatus.OK);

		return response;
	}
	
	
}
