package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{
    /**
     * 다대 일
     * 다가 연관관계 주인일때
     */
//    @Id
//    @GeneratedValue
//    @Column(name = "TEAM_ID")
//    private Long id;
//    private String name;
//
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
//
//    @OneToMany(mappedBy = "team")
//    private List<Member> members=new ArrayList<>();
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//
//    }

    /**
     * 일대 다 일이 연관관계 주인일 때
     */

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    //암베디드 타입과 테이블 매핑에서 Member 엔티티에서 team을 제거 했기 때문에 팀 엔티티도 수정
//    @OneToMany(mappedBy = "team")
//    @JoinColumn(name = "TEAM_ID")
//    private List<Member> members=new ArrayList<>();

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

//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
}
