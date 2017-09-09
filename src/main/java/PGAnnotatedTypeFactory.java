

import org.checkerframework.checker.initialization.qual.FBCBottom;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.framework.type.QualifierHierarchy;
import org.checkerframework.framework.util.MultiGraphQualifierHierarchy.MultiGraphFactory;
import org.checkerframework.framework.util.ViewpointAdaptor;
import org.checkerframework.javacutil.AnnotationUtils;
import qual.Bottom;

import qual.Poly;
import qual.Right;

import qual.Left;
import qual.Top;

import javax.lang.model.element.AnnotationMirror;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PGAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {

    public final AnnotationMirror TOP, LEFT, POLY, RIGHT, BOTTOM;

    public PGAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker, true);
        TOP = AnnotationUtils.fromClass(elements, Top.class);
        LEFT = AnnotationUtils.fromClass(elements, Left.class);
        POLY = AnnotationUtils.fromClass(elements, Poly.class);
        RIGHT = AnnotationUtils.fromClass(elements, Right.class);
        BOTTOM = AnnotationUtils.fromClass(elements, Bottom.class);
        postInit();
    }


    @Override
    protected Set<Class<? extends Annotation>> createSupportedTypeQualifiers() {
        return new LinkedHashSet<Class<? extends Annotation>>(
                Arrays.asList(
                        Top.class,
                        Left.class,
                        Poly.class,
                        Right.class,
                        Bottom.class));
    }
}
