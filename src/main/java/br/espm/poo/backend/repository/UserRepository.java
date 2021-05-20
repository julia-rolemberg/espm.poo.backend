package br.espm.poo.backend.repository;

import br.espm.poo.backend.model.UserModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, String> { // aqui eu faço as manipulações no banco

    @Override
    Iterable<UserModel> findAll();

    @Override
    Optional<UserModel> findById(String s);

    @Override
    UserModel save(UserModel user);

    @Override
    void deleteById(String s);

    @Query("SELECT u FROM UserModel u WHERE u.txtName LIKE(concat( '%',:name,'%'))") //isso não é sql, é jpql; busca o objeto
    List<UserModel> listByUserName(@Param("name") String name);
}
