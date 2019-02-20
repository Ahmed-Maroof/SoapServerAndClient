package com.boraji.tutorial.springboot.clients;

import com.concretepage.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport  {


//	public GetAllBillsResponse getAllArticles() {
//		GetAllBillsRequest request = new GetAllBillsRequest();
//		GetAllBillsResponse response = (GetAllBillsResponse) getWebServiceTemplate().
//				                       marshalSendAndReceive(request,
//					new SoapActionCallback("http://localhost:8080/soapws/GetAllBillsRequest"));
//     	return response;
//	}

	public LoginResponse login(String userName , String password) {
		LoginRequest request = new LoginRequest();
		request.setPassword(password);
		request.setUsername(userName);
		LoginResponse response = (LoginResponse) getWebServiceTemplate().
				marshalSendAndReceive(request,
						new SoapActionCallback("http://localhost:8080/soapws/LoginsRequest"));
		return response;
	}

    public GetBillsByUserIdResponse getBills(Long userId) {
		GetBillsByUserIdRequest request = new GetBillsByUserIdRequest();
                  request.setUserid(userId);
		GetBillsByUserIdResponse response = (GetBillsByUserIdResponse) getWebServiceTemplate().
                marshalSendAndReceive(request,
                        new SoapActionCallback("http://localhost:8080/soapws/getBillsByUserIdRequest"));
        return response;
    }
}