package com.sena.fetchOneToMany;

import com.sena.fetchOneToMany.entity.Post;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Post> findAll(){
        List<Post> posts = entityManager.createQuery(" select distinct p " +
                                                    "from Post p "+
                                                    "join fetch p.comments pc " +
                                                    "order by pc.id")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return posts;
    }

}
