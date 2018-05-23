package co.simplon.crud.repository;

@Named
public interface FooRepository extends JpaRepository<Foo, Long> {
	List<Foo> findByName(String name);
	Optional<Foo> findById(Long Id);
	public List<Foo> findByNameLike(@Param("name") String name);
}