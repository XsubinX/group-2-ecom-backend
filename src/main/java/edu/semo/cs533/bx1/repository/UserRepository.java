package edu.semo.cs533.bx1.repository;

import edu.semo.cs533.bx1.dao.EcomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EcomUser, Long> {

}
