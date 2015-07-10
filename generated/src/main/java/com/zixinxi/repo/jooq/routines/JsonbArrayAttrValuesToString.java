/**
 * This class is generated by jOOQ
 */
package com.zixinxi.repo.jooq.routines;


import com.zixinxi.domain.WordInfo;
import com.zixinxi.jooq.WordInfoConverter;
import com.zixinxi.repo.jooq.Public;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JsonbArrayAttrValuesToString extends AbstractRoutine<String> {

	private static final long serialVersionUID = 627967805;

	/**
	 * The parameter <code>public.jsonb_array_attr_values_to_string.RETURN_VALUE</code>.
	 */
	public static final Parameter<String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * The parameter <code>public.jsonb_array_attr_values_to_string.jsonb_arr</code>.
	 */
	public static final Parameter<WordInfo> JSONB_ARR = createParameter("jsonb_arr", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), false, new WordInfoConverter());

	/**
	 * The parameter <code>public.jsonb_array_attr_values_to_string.attr_name</code>.
	 */
	public static final Parameter<String> ATTR_NAME = createParameter("attr_name", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * The parameter <code>public.jsonb_array_attr_values_to_string.separator</code>.
	 */
	public static final Parameter<String> SEPARATOR = createParameter("separator", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public JsonbArrayAttrValuesToString() {
		super("jsonb_array_attr_values_to_string", Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(JSONB_ARR);
		addInParameter(ATTR_NAME);
		addInParameter(SEPARATOR);
	}

	/**
	 * Set the <code>jsonb_arr</code> parameter IN value to the routine
	 */
	public void setJsonbArr(WordInfo value) {
		setValue(JSONB_ARR, value);
	}

	/**
	 * Set the <code>jsonb_arr</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setJsonbArr(Field<WordInfo> field) {
		setField(JSONB_ARR, field);
	}

	/**
	 * Set the <code>attr_name</code> parameter IN value to the routine
	 */
	public void setAttrName(String value) {
		setValue(ATTR_NAME, value);
	}

	/**
	 * Set the <code>attr_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setAttrName(Field<String> field) {
		setField(ATTR_NAME, field);
	}

	/**
	 * Set the <code>separator</code> parameter IN value to the routine
	 */
	public void setSeparator(String value) {
		setValue(SEPARATOR, value);
	}

	/**
	 * Set the <code>separator</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setSeparator(Field<String> field) {
		setField(SEPARATOR, field);
	}
}