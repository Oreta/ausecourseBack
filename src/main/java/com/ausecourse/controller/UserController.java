package com.ausecourse.controller;



import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ausecourse.config.SecurityConfig;
import com.ausecourse.config.SecurityUtility;
import com.ausecourse.dao.IListeCourseDAO;
import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.dao.IReviewDAO;
import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.ListeCourse;
import com.ausecourse.model.Order;
import com.ausecourse.model.OrderState;
import com.ausecourse.model.Review;
import com.ausecourse.model.User;
import com.ausecourse.model.security.Role;
import com.ausecourse.model.security.UserRole;
import com.ausecourse.repository.OrderRepository;
import com.ausecourse.utility.MailConstructor;


@RestController
@RequestMapping("/user")
public class UserController {
//routes


	@Autowired
	private IUserDao userDao ;
	@Autowired
	private IOrderDAO orderDao ;
	@Autowired 
	private IListeCourseDAO listeCourseDao ; 
	@Autowired
	private MailConstructor mailConstructor ;
	@Autowired
	private IReviewDAO reviewDao;

	//@Autowired//import jdk.internal.jline.internal.Log;
	//private JavaMailSender mailSender ;


	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public ResponseEntity newUserPost(HttpServletRequest request,
										@RequestBody HashMap<String,String> mapper) throws Exception {

		String username = mapper.get("username") ;
		String userEmail = mapper.get("email");
		String password = mapper.get("password") ;
		String mode = mapper.get("mode");
		String addressClient = mapper.get("addressLivraison");
		String tel = mapper.get("telephone") ;


		if(userDao.findByUsername(username) != null){
			return new ResponseEntity("usernameExists" , HttpStatus.BAD_REQUEST);
		}

		if(userDao.findByEmail(userEmail) != null){
			return new ResponseEntity("emailExists" , HttpStatus.BAD_REQUEST);
		}

		User user = new User();
		user.setNickname(username);
		user.setTel(Integer.parseInt(tel));
		user.setCity(addressClient);
		user.setEmail(userEmail);
		//String encryptedPassword = SecurityConfig.passwordEncoder().encode(password) ;
		user.setPassword(password);
		if(mode.equals("livreur")) 
			user.setDeliverer(true);
		else
			user.setClient(true);
	


		Role role = new Role();
		role.setRoleId("1");
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role)) ;
		userDao.createUser(user, userRoles);

		SimpleMailMessage email = mailConstructor.construcNewUserEmail(user,password) ;
		//mailSender.send(email);
		return new ResponseEntity("User Added Successfully", HttpStatus.OK);
	}
	
	
	

	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(userDao.findAll());
	}
	@RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
	public ResponseEntity forgetPassword(HttpServletRequest request,
										@RequestBody HashMap<String,String> mapper) throws Exception {
		User user = userDao.findByEmail(mapper.get("email")) ;

		if(user == null){
			return new ResponseEntity("Email not found" , HttpStatus.BAD_REQUEST);
		}

		String password = SecurityUtility.randomPassword() ;
		String encryptedPassword = SecurityConfig.passwordEncoder().encode(password) ;
		user.setPassword(encryptedPassword);
		userDao.save(user);

		SimpleMailMessage newEmail = mailConstructor.construcNewUserEmail(user,password) ;
		//mailSender.send(newEmail);

		return new ResponseEntity("Email sent!", HttpStatus.OK);

	}
	
	@RequestMapping(value="/newUserOk", method=RequestMethod.POST)
	public ResponseEntity newUserOk(HttpServletRequest request,
										@RequestBody User user) throws Exception {

		

		if(userDao.findByUsername(user.getUsername()) != null){
			return new ResponseEntity("usernameExists" , HttpStatus.BAD_REQUEST);
		}

		if(userDao.findByEmail(user.getUsername()) != null){
			return new ResponseEntity("emailExists" , HttpStatus.BAD_REQUEST);
		}

		
		user.setNickname(user.getName());

		user.setEmail(user.getEmail());
		//String encryptedPassword = SecurityConfig.passwordEncoder().encode(password) ;
		user.setPassword(user.getPassword());


		Role role = new Role();
		role.setRoleId("1");
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role)) ;
		userDao.createUser(user, userRoles);

		//SimpleMailMessage email = mailConstructor.construcNewUserEmail(user,user.getPassword()) ;
		//mailSender.send(email);
		return new ResponseEntity("User Added Successfully", HttpStatus.OK);
	}




	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
	public ResponseEntity profileInfo(
				@RequestBody HashMap<String, Object> mapper
			) throws Exception{

		String id = (String) mapper.get("id");
		String email = (String) mapper.get("email");
		String username = (String) mapper.get("username");
		String newPassword = (String) mapper.get("newPassword");
		String currentPassword = (String) mapper.get("currentPassword");

		Optional<User> currentUser = userDao.findById(id);

		if(currentUser == null) {
			throw new Exception ("User not found");
		}


		SecurityConfig securityConfig = new SecurityConfig();


			BCryptPasswordEncoder passwordEncoder = SecurityConfig.passwordEncoder();
			String dbPassword = currentUser.get().getPassword();

			if(null != currentPassword)
			if(passwordEncoder.matches(currentPassword, dbPassword)) {
				if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
					currentUser.get().setPassword(passwordEncoder.encode(newPassword));
				}
			} else {
				return new ResponseEntity("Incorrect current password!", HttpStatus.BAD_REQUEST);
			}



		currentUser.get().setNickname(username);

		currentUser.get().setEmail(email);



		userDao.save(currentUser.get());

		return new ResponseEntity("Update Success", HttpStatus.OK);
	}

	@RequestMapping(value ="/getCurrentUser" , method = RequestMethod.GET)
	@ResponseBody
	public User getCurrentUser(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		User user = new User();
		if(null != principal) {
			user = this.userDao.findByUsername(principal.getName()) ;
		}
		

		return user ;

	}

	@RequestMapping(value ="/getLivreurs" , method = RequestMethod.GET)
	@ResponseBody
	public List<User> getLivreurs(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		List<User> users = this.userDao.findAll(); 
		List<User> res = new ArrayList<User>() ;
		
		for(int i=0;i<users.size();i++) {
			if(users.get(i).isDeliverer())
				res.add(users.get(i)); 
		}
		
		return res; 
	}
	
	
	
	@RequestMapping(value ="/notifyLivreur" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity notifyLivreur(HttpServletRequest request,
			@RequestBody Order order) throws Exception {
		User livreur = this.userDao.findById(order.getLivreurId()).get(); 
		//livreur.getCourses().add(order.getListeCourse().getId()) ;
		//this.userDao.save(livreur) ; 
		order.setOrderState(OrderState.CREATE);
		this.orderDao.save(order);
		System.out.println("after save order : " + order.getAddress());
		//modifications
		livreur.getOrdersToHandle().add(order);
		System.out.println("before save livreur hehe");
		this.userDao.save(livreur) ; 
		System.out.println("after save livreur hehe");
 		return new ResponseEntity("notification success", HttpStatus.OK);
	
	}
/*	
	@RequestMapping(value ="/getNotification" , method = RequestMethod.POST)
	@ResponseBody
	public List<ListeCourse> getNotification(@RequestBody String id) throws Exception {
		User user = this.userDao.findById(id).get() ; 
		List<ListeCourse> res = new ArrayList<ListeCourse>(); 
		for(int i=0;i<user.getCourses().size();i++) {
			ListeCourse listeCourse = this.listeCourseDao.findById(user.getCourses().get(i)) ; 
			res.add(listeCourse);
		}
		return res ; 
	
	}
*/
	
	@RequestMapping(value ="/getNotification" , method = RequestMethod.POST)
	@ResponseBody
	public List<Order> getNotification(@RequestBody String id) throws Exception {
		User user = this.userDao.findById(id).get() ; 
		return user.getOrdersToHandle();
	
	}
	
	
	@RequestMapping(value ="/getUserById" , method = RequestMethod.POST)
	@ResponseBody
	public User getUserById(@RequestBody String userId) throws Exception {
		return this.userDao.findById(userId).get()  ;
	
	}
	
	@RequestMapping(value ="/makeReview" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity makeReview(HttpServletRequest request,
			@RequestBody HashMap<String,String> mapper) throws Exception {
		String livreurId = mapper.get("livreurId") ; 
		String nbStars = mapper.get("nbStars"); 
		User livreur = this.userDao.findById(livreurId).get() ; 
		Review review = new Review(); 
		review.setStars(Integer.parseInt(nbStars));
		review.setUser(livreur);
		this.reviewDao.save(review); 
		List<Review> allreviews = this.reviewDao.findAll(); 
		List<Review> livreurReviews = new ArrayList<Review>();
		for (int i=0;i<allreviews.size();i++) {
			if(allreviews.get(i).getUser().getId().equals(livreurId))
				livreurReviews.add(allreviews.get(i)); 
		}
		//update nb stars
		double res = livreur.getStars(); 
		for(int i=0;i<livreurReviews.size();i++)
			res = res + livreurReviews.get(i).getStars();
		livreur.setStars(res/livreurReviews.size());
		
		//save livreur
		this.userDao.save(livreur);
		System.out.println("after save livreur : " + this.userDao.findById(livreurId).get().getStars());
		return new ResponseEntity("review Added", HttpStatus.OK);

	}

}
