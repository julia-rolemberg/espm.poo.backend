package br.espm.poo.backend.model;


import br.espm.poo.backend.dataype.UserBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="users")
public class UserModel { //representa o banco de dados

    @Id
    private String idUsers;
    private String txtName;

    public UserModel(){

    }

    public UserModel(UserBean b){
        this.idUsers = b.getId().toString();
        this.txtName = b.getName();
    }
    public UserBean to(){
        UserBean b = new UserBean();
        b.setId(UUID.fromString(idUsers));
        b.setName(txtName);
        return b;
    }


}
