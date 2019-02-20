package com.concretepage.endpoints;


import com.concretepage.entity.User;
import com.concretepage.gs_ws.*;
import com.concretepage.gs_ws.LoginUserInfo;
import com.concretepage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://www.concretepage.com/article-ws";
	@Autowired
	private IUserService userService;



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
	@ResponsePayload
	public com.concretepage.gs_ws.GetUserByIdResponse getUser(@RequestPayload com.concretepage.gs_ws.GetUserByIdRequest request) {
		com.concretepage.gs_ws.GetUserByIdResponse response = new com.concretepage.gs_ws.GetUserByIdResponse();
		com.concretepage.gs_ws.UserInfo UserInfo = new UserInfo();
		User tempUser = userService.getUserById(request.getUserId());
//		BeanUtils.copyProperties(userService.getUserById(request.getUserId()), UserInfo);
		UserInfo.setUserId(tempUser.getId());
		UserInfo.setName(tempUser.getName());
		UserInfo.setBalance(tempUser.getBalance());
		response.setUserInfo(UserInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
	@ResponsePayload
	public com.concretepage.gs_ws.LoginResponse payBill(@RequestPayload com.concretepage.gs_ws.LoginRequest request) {
		com.concretepage.gs_ws.LoginResponse response = new com.concretepage.gs_ws.LoginResponse();
		LoginUserInfo loginUserInfo = new LoginUserInfo();
		User result = userService.checkUserNameAndPassword(request.getUsername(),request.getPassword());
		if(result!=null)
		{
			loginUserInfo = new LoginUserInfo();
			loginUserInfo.setName(result.getName());
			loginUserInfo.setBalance(result.getBalance());
			loginUserInfo.setEmail(result.getEmail());
			loginUserInfo.setRolename(result.getRole().getName().name());
			loginUserInfo.setUserId(result.getId());
            loginUserInfo.setRequeststatus(true);
			response.setLoginUserInfo(loginUserInfo);
		}
		else
		{
			loginUserInfo.setRequeststatus(false);
			response.setLoginUserInfo(loginUserInfo);
		}
		return response;
	}
}
