package co.simplon.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import co.simplon.crud.model.Foo;

@Controller
@RequestMapping("/foos")
class FooController {

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

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Foo create(@RequestBody Foo resource) {
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo read(@PathVariable("id") Long id) {
		return new Foo(id, "fake read");
  }
	
}