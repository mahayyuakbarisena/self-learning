package com.sena.fetchOneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.aspectj.runtime.internal.Conversions.longValue;

@Setter
@Getter
public class PostDTO {
    public static final String ID_ALIAS = "p_id";

    public static final String TITLE_ALIAS = "p_title";

    private Long id;

    private String title;

    private List<PostCommentDTO> comments = new ArrayList<>();

    public PostDTO(
            Object[] tuples,
            Map<String, Integer> aliasToIndexMap) {

        this.id = longValue(tuples[aliasToIndexMap.get(ID_ALIAS)]);
        this.title = (String) tuples[aliasToIndexMap.get(TITLE_ALIAS)];
    }
}
