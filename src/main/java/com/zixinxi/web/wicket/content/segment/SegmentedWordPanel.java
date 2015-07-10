package com.zixinxi.web.wicket.content.segment;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.wicketstuff.minis.model.LoadableDetachableDependentModel;

import com.zixinxi.domain.OpFunction;
import com.zixinxi.domain.external.SegmentedWord;
import com.zixinxi.domain.external.WordParts;
import com.zixinxi.web.wicket.behavior.SameTitleAsContentAppender;
import com.zixinxi.web.wicket.model.BlankToNbspModel;
import com.zixinxi.web.wicket.model.LambdaModel;

public class SegmentedWordPanel extends Panel {

	public SegmentedWordPanel(String id, IModel<SegmentedWord> model) {
		super(id, model);
		add(new Label("transcriptions", new BlankToNbspModel(new SegmentedWordTranscriptionsModel(model)))
			.add(new SameTitleAsContentAppender())
			.setEscapeModelStrings(false));
		add(new Label("characters", new LambdaModel<>(model, new OpFunction<>(SegmentedWord.FUNCTION_TEXT)))
			.add(new SameTitleAsContentAppender()));
		add(new Label("definitions", new BlankToNbspModel(new SegmentedWordDefinitionsModel(model)))
			.add(new SameTitleAsContentAppender())
			.setEscapeModelStrings(false));
	}
	
	private static class SegmentedWordTranscriptionsModel extends LoadableDetachableDependentModel<String, SegmentedWord> {

		public SegmentedWordTranscriptionsModel(IModel<SegmentedWord> dependentModel) {
			super(dependentModel);
		}

		@Override
		protected String load() {
			SegmentedWord word = getDependentModel().getObject();
			return word.getWordStream()
					.map(WordParts::getTranscription)
					.collect(Collectors.joining("; "));
		}
		
	}
	
	private static class SegmentedWordDefinitionsModel extends LoadableDetachableDependentModel<String, SegmentedWord> {

		public SegmentedWordDefinitionsModel(IModel<SegmentedWord> dependentModel) {
			super(dependentModel);
		}

		@Override
		protected String load() {
			SegmentedWord word = getDependentModel().getObject();
			return word.getWordStream()
					.map(WordParts::getDefinitionStream)
					.flatMap(Function.identity())
					.collect(Collectors.joining("; "));
		}
		
	}

}