package kr.co.ch09.controller;

import jakarta.validation.Valid;
import kr.co.ch09.dto.User2DTO;
import kr.co.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final User2Service User2Service;

    // @ResponseBody는 메서드의 반환값을 응답객체 본문으로 출력하기 위한 어노테이션, 자동 JSON 변환 출력
    @ResponseBody
    @GetMapping("/user2")
    public List<User2DTO> list(){
        System.out.println("list!!");
        return User2Service.findAll();
    }

    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){ // @PathVariable는 주소 파라미터 값을 바인딩하기 위한 어노테이션
        return User2Service.findById(uid);
    }

    /*
        @RequestBody
         - 요청본문 내용에 포함된 데이터를 Java 객체로 변환하는 어노테이션, JSON 데이터 수신

        @Valid
         - REST API 서비스 특성상 클라이언트에서 유효성검사를 하기 어렵기 때문에 백엔드에서 유효성검사를 수행
         - 수신 처리되는 DTO의 각 속성 데이터를 유효성검사 하기위해 어노테이션(@NotBlank, @NotEmpty, @NotNull, @Email...) 사용
         - @Valid 어노테이션으로 DTO의 유효성검사 어노테이션을 수행
    */
    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO User2DTO){

        log.info("User2DTO : {}", User2DTO);

        User2DTO savedUser2 = User2Service.save(User2DTO);

        // ResponseEntity 응답객체를 반환하면 @ResponseBody 어노테이션은 생략가능
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedUser2);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO User2DTO){

        log.info("User2DTO : {}", User2DTO);

        User2DTO modifiedUser2 = User2Service.modify(User2DTO);

        // ResponseEntity 응답객체를 사용하면 응답에 대한 다양한 사용자 정의가 가능하기 때문에 개발의 유연성이 높음
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid){

        log.info("uid : {}", uid);

        boolean isDeleted = User2Service.delete(uid);

        log.info("deletedUser2 : {}", isDeleted);

        if(isDeleted){
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }

        return ResponseEntity.notFound().build();
    }

}
