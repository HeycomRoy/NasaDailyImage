package webService;

import javax.jws.WebService;

@WebService(
			endpointInterface = "example.WebServiceInterface",
			portName = "webservicePort",
			serviceName = "WebService")
public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String greet(String clientName) {
		// TODO Auto-generated method stub
		return "Hi, "+clientName+", this is WebService!";
	}

}
