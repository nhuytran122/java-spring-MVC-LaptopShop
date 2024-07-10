package vn.hoidanit.laptopshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;

@Repository
// crud: create, read, update, delete
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User hoidanit);;

}
