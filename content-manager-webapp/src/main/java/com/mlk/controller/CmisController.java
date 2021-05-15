package com.mlk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.chemistry.opencmis.client.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mlk.cmis.service.impl.CmisConnectServiceImpl;
import com.mlk.model.Person;
import com.mlk.model.enums.UserType;
import com.mlk.service.impl.PersonServiceImpl;

@Controller
@RequestMapping("/alfresco")
public class CmisController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CmisController.class);

	private static final String REDIRECT_PREFIX = "redirect:";

	private static final String LOGIN_PAGE = "cmis/cmis-connect-login";
	private static final String HOME_PAGE = "cmis/cmis-index";
	private static final String USER_INFO_PAGE = "cmis/user-info";
	private static final String MANAGE_CONTENT_PAGE = "cmis/manage-content";

	private static final String USER_ATTRIBUTE = "user";
	private static final String CMIS_SESSION_ATTRIBUTE = "cmisSession";
	private static final String CONNECTED_PERSON_ATTRIBUTE = "connectedPerson";

	private String errorMessage = null;

	@GetMapping(value = "/home")
	public String cmisHome(HttpSession httpSession) {
		if (httpSession != null && httpSession.getAttribute(CMIS_SESSION_ATTRIBUTE) != null) {
			return HOME_PAGE;
		}
		return REDIRECT_PREFIX + "login";
	}

	@GetMapping("/login")
	public String cmisConnect(HttpSession httpSession, Model model) {
		if (httpSession != null && httpSession.getAttribute(CMIS_SESSION_ATTRIBUTE) != null && httpSession.getAttribute(USER_ATTRIBUTE) != null) {
			return REDIRECT_PREFIX + "home";
		}
		model.addAttribute(USER_ATTRIBUTE, new Person());

		model.addAttribute("errorMessage", errorMessage);

		return LOGIN_PAGE;
	}

	@PostMapping("/result")
	public String cmisConnectionResult(HttpSession httpSession, @ModelAttribute(USER_ATTRIBUTE) Person user, Model model) {

		try {
			Session session = user != null
					? new CmisConnectServiceImpl().getSession(user.getUserName(), user.getPassword())
					: null;
			if (session != null) {
				httpSession.setAttribute(CMIS_SESSION_ATTRIBUTE, session);
				httpSession.setAttribute(USER_ATTRIBUTE, user);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			errorMessage = e.getMessage();
			httpSession.setAttribute(CMIS_SESSION_ATTRIBUTE, user); // to remove
			httpSession.setAttribute(USER_ATTRIBUTE, user); // to remove
		}

		return REDIRECT_PREFIX + "home";
	}
	
	@GetMapping("/user-info")
	public String showUserInfo(HttpSession httpSession, Model model) {
		
		if(httpSession != null && httpSession.getAttribute(CMIS_SESSION_ATTRIBUTE) != null && httpSession.getAttribute(USER_ATTRIBUTE) != null) {
			// return REDIRECT_PREFIX + "home";
		}
		
		Person user = (Person) httpSession.getAttribute(USER_ATTRIBUTE);
		Person connectedPerson = new PersonServiceImpl().getStoredPerson(user, UserType.ALFRESCO_USER);
		
		model.addAttribute(CONNECTED_PERSON_ATTRIBUTE, connectedPerson);
		
		return USER_INFO_PAGE;
	}
	
	@GetMapping("/content")
	public String manageContent(HttpSession httpSession, Model model, @RequestParam("item") String param) {
		
		if(httpSession != null && httpSession.getAttribute(CMIS_SESSION_ATTRIBUTE) != null && httpSession.getAttribute(USER_ATTRIBUTE) != null) {
			// return REDIRECT_PREFIX + "home";
		}
		String item = (String) model.getAttribute("item");
		List<String> list = new ArrayList<>();
		list.add("item 1");
		list.add("item 2");
		list.add("item 3");
		
		list.add(item);
		list.add(param);
		
		model.addAttribute("items", list);
		
		return MANAGE_CONTENT_PAGE;
	}
}
