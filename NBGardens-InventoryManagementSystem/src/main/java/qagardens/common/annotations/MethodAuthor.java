package qagardens.common.annotations;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

/**
 * Used to mark an author on constructors, methods and fields.
 * @author James Thompson
 */
@Target({CONSTRUCTOR, METHOD, FIELD})
@Documented
public @interface MethodAuthor {
	String value();
}