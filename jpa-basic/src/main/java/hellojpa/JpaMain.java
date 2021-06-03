package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[]args){
        //에플리케이션 로딩 시점에 딱 하나
        //db당 한개
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");

        //일관적인 단위를 할때다마 em을 만들어 줘야함
        //트랜잭션 단위별 , db 커넥션을 얻어 데이터 보내고 끝내야 함
        EntityManager em =emf.createEntityManager();




        //jpa에서는 트랜잭션이라는 단위가 매우 중요
        //데이터를 변경하는 모든 작업은 트랜잭션 안에서 해야함

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        /**
         * 회원 등록
         */
//        try{
//            Member member=new Member();
//            member.setId(1L);
//            member.setName("helloA");
//
//            em.persist(member);
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 단건 조회
         */
//        try{
//            Member findMember=em.find(Member.class,1L);
//            System.out.println("findMember.getId = " + findMember.getId());
//            System.out.println("findMember.getName = " + findMember.getName());
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 삭제
         */
//        try{
//            Member findMember=em.find(Member.class,1L);
//            em.remove(findMember);
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 수정
         */
//        try{
//            Member findMember=em.find(Member.class,1L);
//            findMember.setName("HelloJPA");
//
//            //이렇게 저장하지 않아도 됨
//            //자바 컬렉션에 저장하는 것 처럼 사용하기 때문
//            //데이터 번경우뮤를 tx.commit직전 확인
////            em.persist(findMember);
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * Jpql
         */
//        try{
//
//            //객체를 대상으로 쿼리를 작성 , 객체를 다 가지고 와
//            List<Member> result = em.createQuery("select m from Member  as m", Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 컨텍스트
         * 데이터를 저장후, 가져올때 확인
         */
//        try{
//
//            //비영속
//            Member member=new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속 (db에 저장 전)
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember=em.find(Member.class,101L);
//
//            //select query가 날아기지 x
//            //1차캐시에서 가져옴
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 컨텍스트
         * 데이터를 디비에서 가져오고, 또 다시 조회할 경우
         */
//        try{
//
//
//
//            //findMember1를 조회할 때는 DB에서 조회
//            Member findMember1=em.find(Member.class,101L);
//
//            //findMember2를 조회할 때는 1차캐시에서 조회
//            Member findMember2=em.find(Member.class,101L);
//
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속 엔티티의 동일성 보장
         */

//        try{
//            //findMember1를 조회할 때는 DB에서 조회
//            Member findMember1=em.find(Member.class,101L);
//
//            //findMember2를 조회할 때는 1차캐시에서 조회
//            Member findMember2=em.find(Member.class,101L);
//
//            //마치 자바 컬렉션에서 꺼내오는 것 처럼
//            System.out.println("result = " + (findMember1==findMember2));
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 엔티티 등록 트랜잭션을 지원하는 쓰기 지연
         */

//        try{
//
//            Member member1=new Member(150L,"A");
//            Member member2=new Member(160L,"B");
//
//            //영속성 컨텍스트에 저장
//            //쓰기 지연 SQL저장소에 저장됨
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("==================");
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }




        /**
         * 엔티티 수정 변경감지
         */

//        try{
//
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//
//            //변경시 밑의 persist 사용 x
////            em.persist(member);
//
//            System.out.println("=========================");
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 컨텍스트 플러시 하는 방법 중 직접 호출 방법
         */

//        try{
//
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();
//            System.out.println("=========================");
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         *영속성 컨텍스트 ->준 영속
         */
//        try{
//
//
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//
//            System.out.println("=========================");
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * Enum Type 의 설정에서 Origin을 사용하면 안되는 이유
         */
//        try{
//
//
//            Member member=new Member();
//            member.setId(2L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }
        try{


            Member member=new Member();
            member.setUsername("C");
            em.persist(member);
            System.out.println("==============");
            System.out.println("member = " + member.getId());
            System.out.println("==============");
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }


        //실제 에플리케이션 종료시 entityfactory 중단
       emf.close();

    }
}
