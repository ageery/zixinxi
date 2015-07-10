/**
 * This class is generated by jOOQ
 */
package com.zixinxi.repo.jooq.tables;


import com.zixinxi.repo.jooq.Public;
import com.zixinxi.repo.jooq.tables.records.GetCedictWordPartsRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class GetCedictWordParts extends TableImpl<GetCedictWordPartsRecord> {

	private static final long serialVersionUID = -819605624;

	/**
	 * The reference instance of <code>public.get_cedict_word_parts</code>
	 */
	public static final GetCedictWordParts GET_CEDICT_WORD_PARTS = new GetCedictWordParts();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<GetCedictWordPartsRecord> getRecordType() {
		return GetCedictWordPartsRecord.class;
	}

	/**
	 * The column <code>public.get_cedict_word_parts.trad_chars</code>.
	 */
	public final TableField<GetCedictWordPartsRecord, String> TRAD_CHARS = createField("trad_chars", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.get_cedict_word_parts.simp_chars</code>.
	 */
	public final TableField<GetCedictWordPartsRecord, String> SIMP_CHARS = createField("simp_chars", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.get_cedict_word_parts.pinyin</code>.
	 */
	public final TableField<GetCedictWordPartsRecord, String> PINYIN = createField("pinyin", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>public.get_cedict_word_parts</code> table reference
	 */
	public GetCedictWordParts() {
		this("get_cedict_word_parts", null);
	}

	/**
	 * Create an aliased <code>public.get_cedict_word_parts</code> table reference
	 */
	public GetCedictWordParts(String alias) {
		this(alias, GET_CEDICT_WORD_PARTS);
	}

	private GetCedictWordParts(String alias, Table<GetCedictWordPartsRecord> aliased) {
		this(alias, aliased, new Field[1]);
	}

	private GetCedictWordParts(String alias, Table<GetCedictWordPartsRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetCedictWordParts as(String alias) {
		return new GetCedictWordParts(alias, this, parameters);
	}

	/**
	 * Rename this table
	 */
	public GetCedictWordParts rename(String name) {
		return new GetCedictWordParts(name, null, parameters);
	}

	/**
	 * Call this table-valued function
	 */
	public GetCedictWordParts call(Object wi) {
		return new GetCedictWordParts(getName(), null, new Field[] { DSL.val(wi) });
	}

	/**
	 * Call this table-valued function
	 */
	public GetCedictWordParts call(Field<Object> wi) {
		return new GetCedictWordParts(getName(), null, new Field[] { wi });
	}
}