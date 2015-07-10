/**
 * This class is generated by jOOQ
 */
package com.zixinxi.repo.jooq.tables.records;


import com.zixinxi.repo.jooq.tables.FindWords;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


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
public class FindWordsRecord extends TableRecordImpl<FindWordsRecord> implements Record5<String, String, String, Object, String[]> {

	private static final long serialVersionUID = -1539745765;

	/**
	 * Setter for <code>public.find_words.trad</code>.
	 */
	public void setTrad(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.find_words.trad</code>.
	 */
	public String getTrad() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>public.find_words.simp</code>.
	 */
	public void setSimp(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.find_words.simp</code>.
	 */
	public String getSimp() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.find_words.transcription</code>.
	 */
	public void setTranscription(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.find_words.transcription</code>.
	 */
	public String getTranscription() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.find_words.transcription_json</code>.
	 */
	public void setTranscriptionJson(Object value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.find_words.transcription_json</code>.
	 */
	public Object getTranscriptionJson() {
		return (Object) getValue(3);
	}

	/**
	 * Setter for <code>public.find_words.defs</code>.
	 */
	public void setDefs(String[] value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.find_words.defs</code>.
	 */
	public String[] getDefs() {
		return (String[]) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<String, String, String, Object, String[]> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<String, String, String, Object, String[]> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return FindWords.FIND_WORDS.TRAD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return FindWords.FIND_WORDS.SIMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return FindWords.FIND_WORDS.TRANSCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Object> field4() {
		return FindWords.FIND_WORDS.TRANSCRIPTION_JSON;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String[]> field5() {
		return FindWords.FIND_WORDS.DEFS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getTrad();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getSimp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getTranscription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object value4() {
		return getTranscriptionJson();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] value5() {
		return getDefs();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord value1(String value) {
		setTrad(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord value2(String value) {
		setSimp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord value3(String value) {
		setTranscription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord value4(Object value) {
		setTranscriptionJson(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord value5(String[] value) {
		setDefs(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindWordsRecord values(String value1, String value2, String value3, Object value4, String[] value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached FindWordsRecord
	 */
	public FindWordsRecord() {
		super(FindWords.FIND_WORDS);
	}

	/**
	 * Create a detached, initialised FindWordsRecord
	 */
	public FindWordsRecord(String trad, String simp, String transcription, Object transcriptionJson, String[] defs) {
		super(FindWords.FIND_WORDS);

		setValue(0, trad);
		setValue(1, simp);
		setValue(2, transcription);
		setValue(3, transcriptionJson);
		setValue(4, defs);
	}
}