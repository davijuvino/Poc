package employees.b2w.digital.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import employees.b2w.digital.service.CargoService;

@ExtendWith(SpringExtension.class)
public class CargoControllerTest {

	
	@InjectMocks
	private CargoController cargoController;
	
	@Mock
	private CargoService cargoServiceMocks;
	
	
	@BeforeEach
	void setUp() {
		
					 
	}
  
}


