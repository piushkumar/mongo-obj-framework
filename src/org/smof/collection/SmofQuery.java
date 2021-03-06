/*******************************************************************************
 * Copyright (C) 2017 Joao
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package org.smof.collection;

import java.util.regex.Pattern;

import org.smof.element.Element;

@SuppressWarnings("javadoc")
public interface SmofQuery<E extends Element, T extends SmofQuery<E, ?>> {

	Class<E> getElementClass();
	
	T withFieldEquals(String fieldName, Object value);
	T withFieldNotEquals(String fieldName, Object value);
	T withFieldIn(String fieldName, Object[] values);
	T withFieldNotIn(String fieldName, Object[] values);
	T withFieldRegex(String fieldName, Pattern value);
	
	T withFieldGreater(String fieldName, Object value);
	T withFieldGreater(String fieldName, Object value, boolean greaterOrEqual);
	T withFieldGreaterOrEqual(String fieldName, Object value);
	
	T withFieldSmaller(String fieldName, Object value);
	T withFieldSmaller(String fieldName, Object value, boolean smallerOrEqual);
	T withFieldSmallerOrEqual(String fieldName, Object value);
	
	T withFieldMod(String fieldName, int divisor, int remainder);
	
	T withFieldAll(String fieldName, Object[] values);
	
	ArrayQuery<E> beginAnd();
	ArrayQuery<E> beginOr();
	ArrayQuery<E> beginNor();
	DocumentQuery<E> beginNot();
	
	SmofResults<E> results();
}
