package com.concretepage.endpoints;

import com.concretepage.entity.Bill;
import com.concretepage.gs_ws.BillInfo;
import com.concretepage.gs_ws.GetAllBillsResponse;
import com.concretepage.gs_ws.GetBillsByUserIdResponse;
import com.concretepage.gs_ws.PayBillResponse;
import com.concretepage.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BillEndpoint {
	private static final String NAMESPACE_URI = "http://www.concretepage.com/article-ws";
	@Autowired
	private IBillService billService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBillsRequest")
	@ResponsePayload
	public com.concretepage.gs_ws.GetAllBillsResponse getAllBills() {
		com.concretepage.gs_ws.GetAllBillsResponse response = new GetAllBillsResponse();
		List<com.concretepage.gs_ws.BillInfo> BillInfoList = new ArrayList<>();
		List<Bill> BillList = billService.retriveAllBills();
		for (int i = 0; i < BillList.size(); i++) {
			 com.concretepage.gs_ws.BillInfo ob = new BillInfo();
			 ob.setBillId(BillList.get(i).getId());
			ob.setName(BillList.get(i).getName());
			ob.setUserName(BillList.get(i).getUser().getName());
			ob.setValue(BillList.get(i).getValue());
			ob.setStatus(BillList.get(i).isStatus());
//		    BeanUtils.copyProperties(BillList.get(i), ob);
		     BillInfoList.add(ob);
		}
		response.getBillInfo().addAll(BillInfoList);
		return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "payBillRequest")
	@ResponsePayload
	public com.concretepage.gs_ws.PayBillResponse payBill(@RequestPayload com.concretepage.gs_ws.PayBillRequest request) {
		com.concretepage.gs_ws.PayBillResponse response = new PayBillResponse();
		if( billService.payBill(request.getBillId()))
		{
			response.setStatus(true);
		}
		else
		{
			response.setStatus(false);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBillsByUserIdRequest")
	@ResponsePayload
	public com.concretepage.gs_ws.GetBillsByUserIdResponse getBill(@RequestPayload com.concretepage.gs_ws.GetBillsByUserIdRequest request) {
		com.concretepage.gs_ws.GetBillsByUserIdResponse response = new GetBillsByUserIdResponse();

		List<BillInfo> BillInfoList = new ArrayList<>();
		List<Bill> BillList = billService.retriveBillsByUserId(request.getUserid());
		for (int i = 0; i < BillList.size(); i++) {
			BillInfo ob = new BillInfo();
			ob.setBillId(BillList.get(i).getId());
			ob.setName(BillList.get(i).getName());
			ob.setUserName(BillList.get(i).getUser().getName());
			ob.setValue(BillList.get(i).getValue());
			ob.setStatus(BillList.get(i).isStatus());
//		    BeanUtils.copyProperties(BillList.get(i), ob);
			BillInfoList.add(ob);
		}
		response.getBillInfo().addAll(BillInfoList);

		return response;
	}

}
