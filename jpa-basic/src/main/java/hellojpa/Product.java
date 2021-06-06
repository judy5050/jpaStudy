package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {


    @Id
    @GeneratedValue
    private Long id;

    private String name;


    //다대 다 연관관계
    //양방향 매핑시
    //연관관계 주인 x
//    @ManyToMany(mappedBy = "products")
//    private List<Member> members=new ArrayList<>();

    //다대다 연관관계 한계 극복
    @OneToMany(mappedBy = "product")
    private List<MemberProduct>memberProducts=new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
