

import org.checkerframework.checker.initialization.InitializationChecker;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;

/**
 * Created by mier on 20/06/17.
 */
public class PGChecker extends BaseTypeChecker {

    public PGChecker() {
        super();
    }

    @Override
    protected BaseTypeVisitor<?> createSourceVisitor() {
        return new PGVisitor(this);
    }
}
