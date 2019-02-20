package com.boraji.tutorial.springboot.clients;

import com.concretepage.wsdl.GetAllBillsRequest;
import com.concretepage.wsdl.GetAllBillsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BillClient  extends WebServiceGatewaySupport {

    public GetAllBillsResponse getAllBills() {
        GetAllBillsRequest request = new GetAllBillsRequest();
        GetAllBillsResponse response = (GetAllBillsResponse) getWebServiceTemplate().
                marshalSendAndReceive(request,
                        new SoapActionCallback("http://localhost:8080/soapws/GetAllBillsRequest"));
        return response;
    }
}
