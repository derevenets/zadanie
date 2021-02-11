package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @NonNull
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User>users;
    @OneToMany(mappedBy = "role",  cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;

//    public void  addUser(User user){
//        if (user==null) user = new HashSet<>();
//        this.users.add(user);


    @Override
    public String toString(){
        return "Role{" +
                "id=" + id +
                " , name'" + name + '\''+
                '}';
    }

}
