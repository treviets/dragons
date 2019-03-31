import net.dragons.jpa.entity.Currency;

import net.dragons.service.CurrencyService;

public class TestCurrencyService {

	private Long currencyId = 1;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void testFindById(Long id) {
		Currency currency = currencyService.findById(currencyId);
		assertTrue("VND", currency.getCode());
	}
}
