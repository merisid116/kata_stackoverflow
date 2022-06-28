package com.javamentor.qa.platform.models.dto;

import com.javamentor.qa.platform.models.entity.chat.Chat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto  implements Serializable {

    private Long id;
    private String email;
    private String fullName;
    private String linkImage;
    private String city;
    private Long reputation;
    private LocalDateTime registrationDate;
    private Long votes;
    private List<TagDto> listTop3TagDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        UserDto userDto = (UserDto) o;
        return id != null &&
                id.equals(userDto.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
