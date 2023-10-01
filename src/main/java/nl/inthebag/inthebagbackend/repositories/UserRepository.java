package nl.inthebag.inthebagbackend.repositories;

import nl.inthebag.inthebagbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
