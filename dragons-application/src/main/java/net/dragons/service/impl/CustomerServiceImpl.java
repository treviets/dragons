package net.dragons.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import net.dragons.dto.CustomerDetailDto;
import net.dragons.dto.CustomerDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Currency;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.jpa.entity.Language;
import net.dragons.jpa.entity.SocialLinkAccount;
import net.dragons.repository.CustomerNewRepository;
import net.dragons.repository.CustomerRepository;
import net.dragons.repository.SocialLinkReponsitory;
import net.dragons.service.CurrencyService;
import net.dragons.service.CustomerService;
import net.dragons.service.LanguageService;
import net.dragons.service.SocialLinkAccountService;
import util.CustomerRoleConstant;
import util.CustomerStatusConstant;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerNewRepository customerNewRepository;

	@Autowired
	SocialLinkReponsitory socialLinkRepository;

	@Autowired
	LanguageService languageService;

	@Autowired
	CurrencyService currencyService;
	
//	@Autowired
//	SocialLinkAccountService socialLinkAccountService;

	ModelMapper mapper;

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
	public int createCustomer(CustomerDto customerNewDto) {
		CustomerNewEntity customer = new CustomerNewEntity();

		customer.setEmail(customerNewDto.getEmail());
		customer.setFirstName(customerNewDto.getFirstname());
		customer.setLastName(customerNewDto.getLastname());
		customer.setPassword(customerNewDto.getPassword());
		customer.setRoleId(CustomerRoleConstant.CUSTOMER_ROLE);
		customer.setStatus(CustomerStatusConstant.ENABLE);

		try {
			customerNewRepository.save(customer);
		} catch (Exception e) {
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
	public ResponseDto updateNewUser(CustomerDto customerNewDto) {

		CustomerNewEntity entity = customerNewRepository.findByEmail(customerNewDto.getEmail());
		entity.setPhone(customerNewDto.getPhone());

		customerNewRepository.save(entity);
		ResponseDto response = new ResponseDto();
		response.setData(entity);
		response.setMessage("OK");
		response.setStatus(HttpStatus.OK);

		return response;
	}

	@Override
	public SocialLinkAccount signUpBySocial(CustomerDto customerNewDto) {
		SocialLinkAccount entity = new SocialLinkAccount();
		entity.setFullName(customerNewDto.getFullname());

		if (customerNewDto.getGoogleid() != null) {
			entity.setGgId(customerNewDto.getGoogleid());
		} else {
			entity.setFbId(customerNewDto.getFbid());
		}

		entity.setFamilyName(customerNewDto.getLastname());
		entity.setGivenName(customerNewDto.getFirstname());
		entity.setImg(customerNewDto.getAvatar());
		entity.setUserId(customerNewDto.getUserId());
		SocialLinkAccount result = socialLinkRepository.save(entity);

		return result;
	}

	@Override
	public SocialLinkAccount getByCustomerId(CustomerDto customerNewDto) {
		SocialLinkAccount result = socialLinkRepository.findByUserId(customerNewDto.getUserId());
		return result;
	}

	@Override
	public CustomerDetailDto getCustomerDetail(Long customerId) {
		CustomerDetailDto dto = new CustomerDetailDto();

		Customer customer = customerRepository.findById(customerId);
		if (customer != null) {
			dto.setCustomer(customer);
		}
		
		SocialLinkAccount result = socialLinkRepository.findByUserId(customerId.intValue());
		dto.setSocialLinkAccount(result);

		

		List<Language> languages = languageService.findAll();
		if (languages != null && !languages.isEmpty()) {
			dto.setLanguage(languages);
		}

		List<Currency> currency = currencyService.findAll();
		if (currency != null && !currency.isEmpty()) {
			dto.setCurrency(currency);
		}

		return dto;
	}

	@Override
	public void updateCustomerDetail(CustomerDetailDto dto) {
		Customer customer = customerRepository.findById(dto.getCustomer().getId());
		
		if(dto.getCustomer().getPassword() =="") {
			customer.setPassword(customer.getPassword());
		}else {
			String pass = BCrypt.hashpw(dto.getCustomer().getPassword(), BCrypt.gensalt(12));
			customer.setPassword(pass);
		}
		
		customer.setAvatar(dto.getCustomer().getAvatar());
		customer.setDateOfBirth(dto.getCustomer().getDateOfBirth());
		customer.setEmail(dto.getCustomer().getEmail());
		customer.setFirstName(dto.getCustomer().getFirstName());
		customer.setHometown(dto.getCustomer().getHometown());
		customer.setIntroduction(dto.getCustomer().getIntroduction());
		customer.setLastName(dto.getCustomer().getLastName());
		customer.setPhone(dto.getCustomer().getPhone());
		customer.setPreferCurrency(dto.getCustomer().getPreferCurrency());
		customer.setPreferLanguage(dto.getCustomer().getPreferLanguage());
		customer.setSchool(dto.getCustomer().getSchool());
		customer.setWork(dto.getCustomer().getWork());
		customer.setWorkEmail(dto.getCustomer().getWorkEmail());
		
		customerRepository.save(customer);
	}

}
