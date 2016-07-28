package dagger.sigvent.ch.testdagger;

import java.lang.annotation.Retention;

import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jacky on 28.07.2016.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
