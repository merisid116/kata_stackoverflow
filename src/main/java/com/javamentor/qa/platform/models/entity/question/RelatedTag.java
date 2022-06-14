package com.javamentor.qa.platform.models.entity.question;

import com.javamentor.qa.platform.models.entity.chat.Chat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "related_tag")
public class RelatedTag implements Serializable {

    private static final long serialVersionUID = 2976172897344367292L;
    @Id
    @GeneratedValue(generator = "RelatedTag_seq")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "main_tag")
    private Tag mainTag;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "child_tag")
    private Tag childTag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        RelatedTag relatedTag = (RelatedTag) o;
        return id != null &&
                id.equals(relatedTag.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
