package project.nftshop.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성");

    String gender;

    public static Gender of(String gender){
        return Arrays.stream(Gender.values())
                .filter(g -> g.toString().equals(gender))
                .findAny().orElseThrow(() -> new RuntimeException("해당 성별은 없습니다."));
    }
}
