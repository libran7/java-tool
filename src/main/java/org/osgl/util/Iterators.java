package org.osgl.util;

/*-
 * #%L
 * Java Tool
 * %%
 * Copyright (C) 2014 - 2017 OSGL (Open Source General Library)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.osgl.$;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 23/10/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Iterators {
    ;
    public static <T> Iterator<T> filterIndex(Iterator<? extends T> itr, $.Function<Integer, Boolean> predicate) {
        return new IndexFilteredIterator<T>(itr, predicate);
    }

    public static <T> Iterator<T> filter(Iterator<? extends T> itr, $.Function<? super T, Boolean> predicate) {
        return new FilteredIterator<T>(itr, predicate);
    }

    public static <T> Iterator<T> filterWhile(Iterator<? extends T> itr, $.Function<? super T, Boolean> predicate) {
        return new FilteredIterator<T>(itr, predicate, FilteredIterator.Type.WHILE);
    }

    public static <T> Iterator<T> filterUntil(Iterator<? extends T> itr, $.Function<? super T, Boolean> predicate) {
        return new FilteredIterator<T>(itr, predicate, FilteredIterator.Type.UNTIL);
    }

    public static <T> Iterator<T> composite(Iterator<? extends T> i1, Iterator<? extends T> i2) {
        return new CompositeIterator<T>(i1, i2);
    }

    public static <T> Iterator<T> of(T t) {
        return new SingletonIterator<T>(t);
    }

    public static <T, R> Iterator<R> map(Iterator<? extends T> itr, $.Function<? super T, ? extends R> mapper) {
        return new MappedIterator<T, R>(itr, mapper);
    }

    public static <T, R> Iterator<R> flatMap(Iterator<? extends T> itr, $.Function<? super T, ? extends Iterable<? extends R>> mapper) {
        return new FlatMappedIterator<T, R>(itr, mapper);
    }

}
