package com.javamentor.qa.platform.models.dto;

import com.javamentor.qa.platform.models.entity.chat.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    private Long id;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        TagDto tagDto = (TagDto) o;
        return id != null &&
                id.equals(tagDto.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
