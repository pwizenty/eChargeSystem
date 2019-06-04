package de.fhdo.echarge.usermanagementservice.repository;

import de.fhdo.echarge.usermanagementservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
