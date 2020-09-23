package com.sena.fetchOneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static org.aspectj.runtime.internal.Conversions.longValue;

@Setter
@Getter
public class PostCommentDTO {
    public static final String ID_ALIAS = "pc_id";

    public static final String REVIEW_ALIAS = "pc_review";

    private Long id;

    private String review;

    public PostCommentDTO(
            Object[] tuples,
            Map<String, Integer> aliasToIndexMap) {
        this.id = longValue(tuples[aliasToIndexMap.get(ID_ALIAS)]);
        this.review = (String) tuples[aliasToIndexMap.get(REVIEW_ALIAS)];
    }
}
