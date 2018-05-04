package com.DE.Bots.Service;
/*package com.bolt.license.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.bolt.license.config.DataConfig;
import com.bolt.license.core.model.LoginConfig;
import com.bolt.license.repository.LoginConfigRepo;
import com.bolt.license.request.LoginRequest;
import com.bolt.license.response.DataResponse;

@Service
public class loginServiceImplementation implements LoginService {

	@Override
	public boolean checkCredential(LoginRequest details) {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LoginConfigRepo repo = ctx.getBean(LoginConfigRepo.class);
		LoginConfig fetchedData = repo.findByUserName(details.getUserName());
		if (fetchedData != null && fetchedData.getPassword().equals(details.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public DataResponse<List<LoginConfig>> getAllUsers() {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LoginConfigRepo repo = ctx.getBean(LoginConfigRepo.class);
		List<LoginConfig> list = repo.findAll();
		Iterator<LoginConfig> iterator = list.iterator();
		List<LoginConfig> listColl = new ArrayList<>();
		while (iterator.hasNext()) {
			LoginConfig c = iterator.next();
			listColl.add(c);
		}
		return new DataResponse<List<LoginConfig>>(listColl, 1);
	}

	@Override
	public String addNewUser(LoginRequest details) {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LoginConfigRepo repo = ctx.getBean(LoginConfigRepo.class);
		LoginConfig fetch = repo.findByUserName(details.getUserName());
		if (fetch == null) {
			LoginConfig temp = setter(details);
			repo.save(temp);
			return "user" + details.getName() + "successfully added.";
		}
		return "Username already taken. Please try again with differnt username";
	}

	@Override
	public String updateUser(LoginRequest details) {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LoginConfigRepo repo = ctx.getBean(LoginConfigRepo.class);
		LoginConfig fetch = repo.findByUserName(details.getUserName());
		if (fetch != null) {
			repo.delete(fetch);
			LoginConfig temp = setter(details);
			repo.save(temp);
		}
		return "username" + details.getUserName() + "not available in database to update the details.";
	}

	public LoginConfig setter(LoginRequest details) {
		LoginConfig temp = new LoginConfig();
		temp.setContactNo(details.getContactNo());
		temp.setEmail(details.getEmail());
		temp.setName(details.getName());
		temp.setPassword(details.getPassword());
		temp.setUserName(details.getUserName());
		return temp;
	}

}
*/