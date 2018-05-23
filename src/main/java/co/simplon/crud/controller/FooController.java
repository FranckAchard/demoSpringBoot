package co.simplon.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import co.simplon.crud.model.Foo;
import co.simplon.crud.service.FooService;

@Controller
@RequestMapping("/foos")
class FooController {
	
	@Inject
	FooService fooService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Foo> findAll() {
		List<Foo> foos = new ArrayList<Foo>();
		Foo foo1 = new Foo( " Test 1 ");
		Foo foo2 = new Foo ("Test 2");

		foos.add(foo1);
		foos.add(foo2);

		return foos;
	}
	
	@RequestMapping(value = "/getCookie", method = RequestMethod.GET)
	@ResponseBody
	public String getCookie(@CookieValue(value="wtf", defaultValue="ben alors") String theCookie) {
		return ("Valeur cookie = " + theCookie);
	}

	@RequestMapping(value="/setCookie", method = RequestMethod.GET)
	@ResponseBody
	public String myAddCookie(HttpServletResponse resp) {
		resp.addCookie(new Cookie("mdr", "lol"));
		return ("Cookie créé");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Foo create(@RequestBody Foo resource) {
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo read(@PathVariable("id") Long id) {
		return new Foo(id, "salut poilu!");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Foo update(@PathVariable("id") Long id) {
		return new Foo(id, "adieu poilu!");
	}
	
	@RequestMapping(value="/testRequestParam")
	@ResponseBody
	public String testRequestParam(@RequestParam("id") int id){
		return "testRequestParam with id= "+id;
	}
}