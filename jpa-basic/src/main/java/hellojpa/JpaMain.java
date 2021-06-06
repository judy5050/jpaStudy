package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
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
        /**
         * 단 방향 연관관계 매핑후 코드
         */
//        try{
//
//
//            //저장
//           Team team=new Team();
//           team.setName("TeamA");
//           em.persist(team);
//
//           Member member=new Member();
//           member.setUsername("member1");
//           member.setTeam(team);
//
//           em.persist(member);
//
//           //조회 쿼리 보고 싶을 때
//           em.flush();
//           em.clear();
//
//
//
//           //조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            Team findTeam=findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 양방향 매핑시 가장 많이 하는 실수
         */

//        try{
//
//
//            Member member=new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            //저장
//            Team team=new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);
//
//
//
//            em.persist(member);
//
//            //조회 쿼리 보고 싶을 때
//            em.flush();
//            em.clear();
//
//
//
//
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 연관관계 매핑시 가장 많이하는 실수 해결본
         */
//        try{
//
//            //저장
//            Team team=new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member=new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);
//
//
//
//
//
//            em.persist(member);
//
//            //조회 쿼리 보고 싶을 때
//            em.flush();
//            em.clear();
//
//
//
//
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 단방향 연관관계( 일이 연관관계 주인일때)
         *
         */

//        try{
//
//            Member member=new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team=new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);
//
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();;
//        }finally {
//            em.close();
//        }

        /**
         *상속 관계 전략 -조인전략
         */

//        try {
//
//            Movie movie=new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//
//            em.flush();
//            em.clear();
//
//            Movie findMove=em.find(Movie.class,movie.getId());
//            System.out.println("findMove = " + findMove);
//
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * mapped superclass 예
         */

//        try {
//
//            Member member=new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }
        /**
         * 프록시 사용법 및 타입 비교 연산
         */
//        try {
//
//            Member member1=new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Member member2=new Member();
//            member2.setUsername("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1=em.find(Member.class,member1.getId());
//            Member m2=em.getReference(Member.class,member2.getId());
//
//            //객체비교시 ==연산 x
//            System.out.println("(m1.getClass() ==m2.getClass()) = " + (m1.getClass() == m2.getClass()));
//            //객체 비교시 instance of로 하기
//            System.out.println("(m1 instanceof Member) = " + (m1 instanceof Member));
//
//
////            Member findMember=em.find(Member.class,member.getId());
////            System.out.println("findMember.id = " + findMember.getId());
////            System.out.println("findMember.username = " + findMember.getUsername());
//
//            //getReferenct만 사용할 경우, db에 쿼리가 날아가지 x
////            Member findMember = em.getReference(Member.class, member1.getId());
////            System.out.println("findMember = " + findMember.getClass());
////            System.out.println("findMember.id = " + findMember.getId());
////            System.out.println("findMember.username = " + findMember.getUsername());
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 컨텍스트에 찾는 엔티티 이미 존재시, em.getReference()를 호출해도 실제 엔티티를 반환
         */
//        try {
//
//            Member member1=new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member m1=em.find(Member.class,member1.getId());
//            System.out.println("m1.getClass() = " + m1.getClass());
//
//            Member reference = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass());
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 컨텍스트의 도움을 받을 수 없는 준영속 상태일 때 프록시 초기화 하면 문제 발생
         */
//        try {
//
//            Member member1=new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); //Proxy
//
////            em.clear();
////            em.detach(refMember);
////            em.close();
//
//            refMember.getUsername();
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

//        /**
//         * 지연로딩 사용해 프록시로 조회
//         */
//
//        try {
//
//            Team team=new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1=new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            //멤버 조회 쿼리만 날아감
//            Member m = em.find(Member.class, member1.getId());
//
//            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//
//            System.out.println("====================");
//            m.getTeam().getName();
//            System.out.println("====================");
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * 영속성 전이와 고아객체
         */

//        try {

            //영속성 전이 사용 전
//            Child child1=new Child();
//            Child child2=new Child();
//
//            Parent parent=new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            //parent 중심으로 코드를 짜고 있는데 em.persist를 3번이나 하는게 좀 귀찮음
//            //parent가 child 도 관리해줬으면 함
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            //영속성 전이 사용 후
//            Child child1=new Child();
//            Child child2=new Child();
//
//            Parent parent=new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            //
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//
//            //고아객체 자동 삭제 orphanRemovel =true로 할때
//            //부모객체에서 자식 list의 어떤 인덱스 값을 지우면 자동 삭제
////            findParent.getChildList().remove(0);
//
//            //CasecadeType.ALL할때 or CasecadeType.DELETE
////            em.remove(findParent);
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            e.printStackTrace();
//
//        }finally {
//            em.close();
//        }

        /**
         * 임베디드 타입 사용법
         */
//        try {
//
//
//            Member member=new Member();
//            member.setUsername("hello");
//            member.setAddress(new Address("city","street","10"));
//
//
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
         * 임베디드 값 타입 공유시 문제점
         */
//
//        try {
//
//
//            Address address=new Address("city","street","10000");
//
//            //member 와 member2가 같은 address사
//            Member member=new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Member member2=new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(address);
//            em.persist(member2);
//
//            //member에 해당하는 city만 변경하고 싶어 !
//            //하지만 값 타입을 공유할 경우 member의 주소가 바뀌면 공유된 주소를 갖는 member2의 주소도 변경됨
//            member.getHomeAddress().setCity("newCity");
//
//
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        /**
         * 임베디드 값 타입 공유시 문제점 해결-값 타입 복사
         */


        try {


            Address address=new Address("city","street","10000");

            //member 와 member2가 같은 address사
            Member member=new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);

            //불변 객체에서 값을 변경하고 싶으면, 새로 생성
            Address newAddress=new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);


            Address copyAddress=new Address(address.getCity(), address.getStreet(), address.getZipcode());
            Member member2=new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            //member에 해당하는 city만 변경하고 싶어 !
            //하지만 값 타입을 공유할 경우 member의 주소가 바뀌면 공유된 주소를 갖는 member2의 주소도 변경됨
//            member.getHomeAddress().setCity("newCity");



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }



    }
}

