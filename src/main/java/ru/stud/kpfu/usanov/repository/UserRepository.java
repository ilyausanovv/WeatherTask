package ru.stud.kpfu.usanov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.stud.kpfu.usanov.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
