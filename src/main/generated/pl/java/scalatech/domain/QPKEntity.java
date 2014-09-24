package pl.java.scalatech.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPKEntity is a Querydsl query type for PKEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QPKEntity extends EntityPathBase<PKEntity<?>> {

    private static final long serialVersionUID = -980366340L;

    public static final QPKEntity pKEntity = new QPKEntity("pKEntity");

    public final DateTimePath<java.util.Date> dateAdded = createDateTime("dateAdded", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateModification = createDateTime("dateModification", java.util.Date.class);

    public final BooleanPath disabled = createBoolean("disabled");

    public final SimplePath<Object> id = createSimple("id", Object.class);

    @SuppressWarnings("all")
    public QPKEntity(String variable) {
        super((Class)PKEntity.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QPKEntity(Path<? extends PKEntity> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QPKEntity(PathMetadata<?> metadata) {
        super((Class)PKEntity.class, metadata);
    }

}

