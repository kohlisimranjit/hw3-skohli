package edu.cmu.deiis.annotator;
/**This annotator class assigns Confidence scores to each answer.
 * Based upon the threshold score it will assign a score of 1 or 0 to the answer.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;




//import org.cleartk.token.type.*;
import edu.cmu.deiis.constants.AnnotatorConstants;
import edu.cmu.deiis.subTypes.AnnotatedAnswer;
import edu.cmu.deiis.subTypes.AnnotatedNGram;
import edu.cmu.deiis.subTypes.AnnotatedQuestion;
import edu.cmu.deiis.subTypes.AnnotatedToken;
import edu.cmu.deiis.subTypes.Document;
import edu.cmu.deiis.subTypes.NGramMatrix;
import edu.cmu.deiis.subTypes.TokenizedDocument;
import edu.cmu.deiis.subTypes.TokenizedSentence;
import edu.stanford.nlp.dcoref.CoNLL2011DocumentReader.NamedEntityAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.util.CoreMap;

import org.cleartk.ne.type.NamedEntityMention;
import org.cleartk.token.type.Sentence;
import org.cleartk.token.type.Token;
//import org.cleartk.token.type.

public class AnswerScorer extends JCasAnnotator_ImplBase {
	static int intC = 0;
	/**
	   * Assigns final score to each answer string 
	   * If named entities are matched a higher scoe is assigned else score is penalized
	   * @param jcas JCas object that provides access to the CAS.
	   */
	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		
		
		System.out.println("Entered \t"+this.getClass().getName()+"hw3");

		FSIndex<Annotation> cleartkNamedEntityMentionIndex = jCas
				.getAnnotationIndex(NamedEntityMention.type);		//org.cleartk.token.type.Sentence
	//	FSIndex<Annotation> namedEntityIndex = jCas.getAnnotationIndex(edu.stanford.nlp.dcoref.CoNLL2011DocumentReader.NamedEntityAnnotation);	
		
		
		Iterator<Annotation> cleartkNamedEntityMentionIterator = cleartkNamedEntityMentionIndex.iterator();
	   // List<CoreMap> sentences = jCas.getAnnotationIndex(SentencesAnnotation.type);

		System.out.println("Sentence Iterator");
		HashMap<String, String> map=new HashMap<String, String>();
		//NamedEntityMention qMen=(NamedEntityMention) cleartkNamedEntityMentionIterator.next();
		//qMen.getMentionType();
		int line=0;
		while(cleartkNamedEntityMentionIterator.hasNext())
		{
			NamedEntityMention sentence=(NamedEntityMention) cleartkNamedEntityMentionIterator.next();
			org.cleartk.ne.type.NamedEntity nameEntity=sentence.getMentionedEntity();
			FSArray fs=nameEntity.getMentions();
			System.out.println("lineNo"+line+++"sentence.getCoveredText();"+sentence.getCoveredText());	
			//System.out.println("EntityId"+fs.get(0).toString());
			map.put(sentence.getCoveredText(), sentence.getMentionType());
			System.out.println(sentence.getMentionType());
			//sentence.get(SentencesAnnotation.class);
		//System.out.println(sentence.toString()+"\t"+sentence.getCoveredText()+"\t"+sentence.getBegin()+"\t"+sentence.getScore());
		}
		
		
		FSIndex<Annotation> nGramIndex = jCas
				.getAnnotationIndex(NGramMatrix.type);
		
		Iterator<Annotation> nGramIndexIterator = nGramIndex.iterator();
		
		NGramMatrix nGramMatrix=(NGramMatrix)nGramIndexIterator.next();
		
		TokenizedDocument tokenizedDocument = null;
		FSArray outer=null;
		FSArray inner=null;
		
		FSIndex<Annotation> tokDocIndex = jCas
				.getAnnotationIndex(TokenizedDocument.type);
		Iterator<Annotation> tokDocIterator = tokDocIndex.iterator();
		AnnotatedToken annotatedToken = new AnnotatedToken(jCas);
		tokenizedDocument = (TokenizedDocument) tokDocIterator.next();

		Document document = null;
		FSIndex<Annotation> docIndex = jCas.getAnnotationIndex(Document.type);
		// FSIndex<Annotation> docIndex =
		// jCas.getAnnotationIndex(Document.type);

		Iterator<Annotation> docIterator = docIndex.iterator();

		document = (Document) docIterator.next();
		AnnotatedQuestion annotatedQuestion = document.getQuestion();
		FSArray documentAnswerArray = document.getAnswers();
		// AnnotatedToken annotatedToken = new AnnotatedToken(jCas);

		//System.out.println("-----------------------------------------------------------------------");
		
		
		
		outer=nGramMatrix.getMatrix();
		double meanScore=0;
		for (int i = 0; i < tokenizedDocument.getTokenizedAnswers().size(); i++) {
			TokenizedSentence tokenizedAnswerInstance = tokenizedDocument
					.getTokenizedAnswers(i);

			double sentenceConfidence = 0;
			double nGramConfidence = 0;
			int equalizer = 0;
			AnnotatedAnswer annotatedAnswer = (AnnotatedAnswer) documentAnswerArray
					.get(i);
			
			inner =(FSArray)outer.get(i);
			//System.out.println("annotatedAnswer.getSentiment()"+annotatedAnswer.getSentiment()+"\t annotatedQuestion.getConfidence()"+annotatedQuestion.getConfidence());
			if(annotatedAnswer.getSentiment()==annotatedQuestion.getSentiment()){
			for (int j = 1; j <= AnnotatorConstants.MAX_GRAM; j++) {
				int weight = 1;
				equalizer += weight;
				//equalizer=1;	
				FSArray nGramSentence = (FSArray)inner.get(j-1);
		//		inner.set(j, nGramSentence);
				double currConfidence =0;
				currConfidence=getNGramConfidence(annotatedQuestion,nGramSentence, annotatedAnswer,map);
				
				nGramConfidence += weight * currConfidence;
				// System.out.println("nGramConfidence"+nGramConfidence+"\t equalizer"+equalizer);
			}
			
			//outer.set(i, inner);
			sentenceConfidence = nGramConfidence / equalizer;}
			
			if(sentenceConfidence<1&& sentenceConfidence>0)
			meanScore+=sentenceConfidence;
			annotatedAnswer.setConfidence(sentenceConfidence);//Score(sentenceConfidence);
			//System.out.println(sentenceConfidence);
		}
		//meanScore=Math.sqrt(meanScore);
		meanScore/=tokenizedDocument.getTokenizedAnswers().size();
	document.setThreshold(meanScore);	
	
	
	
	for (int i = 0; i < tokenizedDocument.getTokenizedAnswers().size(); i++) 
		{	
		AnnotatedAnswer annotatedAnswer = (AnnotatedAnswer) documentAnswerArray
				.get(i);
		if(annotatedAnswer.getConfidence()>=document.getThreshold())
		
		{annotatedAnswer.setScore(1);}
		}
	
	
	
//System.out.println("meanScore"+meanScore);
	}

	
	

	double getNGramConfidence(AnnotatedQuestion annotatedQuestion,
			FSArray nGramSentence, AnnotatedAnswer annotatedAnswer, HashMap<String, String> map) {
		
		
		String questionText = annotatedQuestion.getText();
		String answerText = annotatedAnswer.getText();
		// System.out.println(questionText+"\t"+answerText);
		double confidence = 0;
		for (int k = 0; k < nGramSentence.size(); k++) {
			AnnotatedNGram annotatedNGram = (AnnotatedNGram) nGramSentence
					.get(k);
			String nGramString = annotatedNGram.getNGramToken();

			if (questionText.indexOf(nGramString) > -1)
				confidence++;
			// System.out.println(annotatedNGram.getNGramToken());

		String pers=map.get(nGramString);
	if(pers!=null && pers.equals("PERSON"))
		confidence=confidence+0.001;
	
	//if(confidence>1)
		//confidence=1;
		}
		// nGramSentence.get
		
		confidence /= nGramSentence.size();

		double fluffFacor = ((double) answerText.split(" ").length)
				/ (questionText.split(" ").length - 1);
		if (fluffFacor > 1) {


			confidence = confidence * fluffFacor;
		}
		
		if(confidence>1)
			confidence=1;
		return confidence;

	}

}
