package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[]args){

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        /**
         * 기본 문법 쿼리
         */
//        try {
//
//            Member member=new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Member singleResult = em.createQuery("select m from Member  m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult = " + singleResult.getUsername());
//
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * 프로젝선 여러 값 조회
         * new 명령어로 조회
         */
//        try {
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO (m.username ,m.age) from Member m ", MemberDTO.class).getResultList();
//            MemberDTO memberDTO=result.get(0);
//            System.out.println("memberDTO = " + memberDTO);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }
        /**
         * 페이징
         */

//        try {
//            for (int i=0;i<100;i++){
//                Member member=new Member();
//                member.setUsername("member"+i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member  m order by m.age desc ", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * 조인
         */
//            try {
//            Team team=new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setTeam(team);
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member  m left  join Team  t on m.username=t.name", Member.class)
//                    .getResultList();
//                System.out.println("result = " + result.size());
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * jpql타입 표현
         */
//        try {
//            Team team=new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Object[]>result = em.createQuery("select m.username, 'HELLO', true FROM Member m where m.type= :userType")
//                    .setParameter("userType",MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[1] = " + objects[1]);
//                System.out.println("objects[2] = " + objects[2]);
//            }
//
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * 조건식 case식
         */
//        try {
//            Team team=new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<String> result = em.createQuery("select" +
//                    " case when m.age<=10 then '학생요금'" +
//                    "when m.age>=60 then '경로요금'" +
//                    "else '일반요금'" +
//                    "end " +
//                    "from Member m", String.class).getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }
//            
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

//        /**
//         * 조건 case식
//         */
//
//        try {
//            Team team=new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<String> result = em.createQuery("select nullif(m.username,'관리자') from Member m", String.class).getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }
//
//            tx.commit();
//
//        }catch (Exception e){
//
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * jpql 기본함수
         */

        try {
            Team team=new Team();
            team.setName("teamA");
            em.persist(team);

            Member member=new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            member.setTeam(team);
            em.persist(member);

            Member member1=new Member();
            member1.setUsername("member2");
            member1.setAge(30);
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            List<String> result = em.createQuery("select nullif(m.username,'관리자') from Member m", String.class).getResultList();
            List<Team> resultList = em.createQuery("select m.team from Member m", Team.class).getResultList();
            for (Team team1 : resultList) {
                System.out.println("team1 = " + team1.getMembers());
            }
            for (String s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();

        }catch (Exception e){

            tx.rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }


    }
}
