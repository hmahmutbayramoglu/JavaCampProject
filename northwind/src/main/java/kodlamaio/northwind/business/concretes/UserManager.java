package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
	
	super();
	this.userDao = userDao;
	}
	
	@Override
	public DataResult<User> findByEmail(String emailAddress) {
	 
		var data = this.userDao.findByEmail(emailAddress);
		return new SuccessDataResult<User>(data, "User found");
	}

	@Override
	public Result add(User user) {
	 
		this.userDao.save(user);
		return new SuccessResult(user.getEmail() +" "+"Added user :)");
	}

}
