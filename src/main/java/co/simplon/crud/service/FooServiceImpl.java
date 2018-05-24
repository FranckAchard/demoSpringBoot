package co.simplon.crud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.crud.model.Foo;
import co.simplon.crud.repository.FooRepository;

@Named
public class FooServiceImpl implements FooService {

    @Inject
    FooRepository fooRepository;
	
    public Foo saveFoo(Foo foo) {
	  fooRepository.save(foo);
	  return foo;
    }

    public List<Foo> getAll() {
	  return fooRepository.findAll();
    }
    
    public Optional<Foo> findbyId(Long id) {	
	  return fooRepository.findById(id);
    }

	public List<Foo> findbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Foo> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}