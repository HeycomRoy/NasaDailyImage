package webService;

import javax.jws.WebService;

@WebService
public interface WebServiceInterface {

	public String greet(String clientName);
}
