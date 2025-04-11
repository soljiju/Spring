package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {

        // given
        String uid = "a1001";

        // when
        User1 user1 = user1Repository.findUser1ByUid(uid);

        // then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {
        List<User1> user1List = user1Repository.findUser1ByName("홍길동");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> user1List = user1Repository.findUser1ByNameNot("홍길동");
        System.out.println(user1List);
    }


    @Test
    void findUser1ByUidAndName() {
    }

    @Test
    void findUser1ByUidOrName() {
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void findUser1ByNameLike() {
    }

    @Test
    void findUser1ByNameContains() {
    }

    @Test
    void findUser1ByNameStartsWith() {
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByNameOrderByUid() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ByName() {
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1ByName() {
    }

    @Test
    void selectUser1ByNameParam() {
    }

    @Test
    void selectUser1ByUid() {
    }

    @Test
    void selectAllParentWithChild() {

        // given
        String pid = "p101";

        // when
        List<Object[]> list = user1Repository.selectAllParentWithChild(pid);

        // then
        for(Object[] arr : list){

            Parent parent = (Parent) arr[0];
            Child child = (Child) arr[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }
}